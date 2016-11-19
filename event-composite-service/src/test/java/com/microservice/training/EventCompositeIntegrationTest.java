package com.microservice.training;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.model.PactFragment;
import com.microservice.training.gateway.EventCompositeGateway;
import com.microservice.training.model.Event;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@RestClientTest(EventCompositeGateway.class)
public class EventCompositeIntegrationTest {

    private static String eventId = "57c811115d6fe2b86380d549";

    @MockBean
    private DiscoveryClient client;

    @MockBean
    private LoadBalancerClient loadBalancer;

    @Autowired
    private EventCompositeGateway eventCompositeGateway;

    @Before
    public void setUp() throws Exception {
        ServiceInstance eventServiceInstance = mock(ServiceInstance.class);
        ServiceInstance recommendationServiceInstance = mock(ServiceInstance.class);
        ServiceInstance reviewServiceInstance = mock(ServiceInstance.class);

        given(eventServiceInstance.getUri()).willReturn(new URI("http://localhost:9000"));
        given(recommendationServiceInstance.getUri()).willReturn(new URI("http://localhost:9010"));
        given(reviewServiceInstance.getUri()).willReturn(new URI("http://localhost:9020"));

        given(loadBalancer.choose("EVENT")).willReturn(eventServiceInstance);
        given(loadBalancer.choose("RECOMMENDATION")).willReturn(recommendationServiceInstance);
        given(loadBalancer.choose("REVIEW")).willReturn(reviewServiceInstance);
    }

    @Rule
    PactProviderRule eventServiceProvider =
            new PactProviderRule("EventService", "localhost", 9000, this);

    @Rule
    PactProviderRule recommendationServiceProvider =
            new PactProviderRule("RecommendationService", "localhost", 9010, this);

    @Rule
    PactProviderRule reviewServiceProvider =
            new PactProviderRule("ReviewService", "localhost", 9020, this);

    @Pact(state="WhenEventDetailIsAvailable", provider = "EventService", consumer = "EventCompositeService")
    public PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/hal+json;charset=UTF-8");

        return builder
                .given("event details is available")
                .uponReceiving("event detail request")
                .path("/events/" + eventId)
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\n" +
                        "  \"name\" : \"扎染小手帕 缤纷大创意\",\n" +
                        "  \"numberLimit\" : 20,\n" +
                        "  \"mainPhoto\" : \"http://cdn.kidsmeet.cn/FgF2b1_pLnil9Yu8L_HRwnZ8wPuk\",\n" +
                        "  \"introduction\" : \"劳动南路 | 亲子扎染 | 3岁以上 \",\n" +
                        "  \"startAt\" : \"2016-08-07T02:00:00.000+0000\",\n" +
                        "  \"endAt\" : \"2016-08-07T04:00:00.000+0000\",\n" +
                        "  \"_links\" : {\n" +
                        "    \"self\" : {\n" +
                        "      \"href\" : \"http://localhost:8080/events/57c811115d6fe2b86380d549\"\n" +
                        "    },\n" +
                        "    \"event\" : {\n" +
                        "      \"href\" : \"http://localhost:8080/events/57c811115d6fe2b86380d549\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}")
                .toFragment();
    }

    @Pact(provider = "RecommendationService", consumer = "EventCompositeService")
    public PactFragment createRecommendationsFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/hal+json;charset=UTF-8");

        return builder
                .given("recommendations for event are available")
                .uponReceiving("request event recommendations")
                .path("/recommendations")
                .query("eventId=" + eventId)
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"_links\":{\"self\":{\"href\":\"http://localhost:8080/recommendations?eventId=57c811115d6fe2b86380d549\"}},\"_embedded\":{\"recommendations\":[{\"eventId\":\"57c811115d6fe2b86380d549\",\"recommendationId\":\"1\",\"content\":\"content 1\"},{\"eventId\":\"57c811115d6fe2b86380d549\",\"recommendationId\":\"2\",\"content\":\"content 2\"},{\"eventId\":\"57c811115d6fe2b86380d549\",\"recommendationId\":\"3\",\"content\":\"content 3\"}]}}")
                .toFragment();
    }

    @Pact(provider = "ReviewService", consumer = "EventCompositeService")
    public PactFragment createReviewsFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/hal+json;charset=UTF-8");

        return builder
                .given("reviews for event are available")
                .uponReceiving("request event reviews")
                .path("/reviews")
                .query("eventId=" + eventId)
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"_links\":{\"self\":{\"href\":\"http://localhost:8080/reviews?eventId=57c811115d6fe2b86380d549\"}},\"_embedded\":{\"reviews\":[{\"eventId\":\"57c811115d6fe2b86380d549\",\"reviewId\":\"1\",\"author\":\"author 1\",\"subject\":\"subject 1\",\"content\":\"content 1\"},{\"eventId\":\"57c811115d6fe2b86380d549\",\"reviewId\":\"2\",\"author\":\"author 2\",\"subject\":\"subject 2\",\"content\":\"content 2\"},{\"eventId\":\"57c811115d6fe2b86380d549\",\"reviewId\":\"3\",\"author\":\"author 3\",\"subject\":\"subject 3\",\"content\":\"content 3\"}]}}")
                .toFragment();
    }

    @Test
    @PactVerification("EventService")
    public void shouldReturnEventDetails() throws Exception {
        Event event = eventCompositeGateway.getEvent(eventId);
        assertEquals("扎染小手帕 缤纷大创意",event.getName());
        assertEquals(20, event.getNumberLimit());
    }

    @Test
    @PactVerification("RecommendationService")
    public void shouldReturnRecommendations() throws Exception {
        List<Map> results = eventCompositeGateway.getRecommendations(eventId);
        assertThat(results.size(), is(3));
        assertThat(results.get(0).get("eventId"), is("57c811115d6fe2b86380d549"));
        assertThat(results.get(0).get("recommendationId"), is("1"));
    }

    @Test
    @PactVerification("ReviewService")
    public void shouldReturnReviews() throws Exception {
        List<Map> results = eventCompositeGateway.getReviews(eventId);
        assertThat(results.size(), is(3));
        assertThat(results.get(0).get("eventId"), is("57c811115d6fe2b86380d549"));
        assertThat(results.get(0).get("reviewId"), is("1"));
        assertThat(results.get(0).get("author"), is("author 1"));
    }
}