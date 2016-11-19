#!/usr/bin/env bash

cd event-composite-service && ./gradlew clean build && cd -
cd event-service && ./gradlew clean build && cd -
cd review-service && ./gradlew clean build && cd -