# 马博文

### 联系方式

- Email：iambowen.m@gmail.com

---
### 个人信息

 - 马博文/男
 - 硕士/西安交通大学
 - 技术博客：[github.io](http://iambowen.github.io/) &&[简书]( http://www.jianshu.com/users/206a6b0af1c5/latest_articles)
 - Github：https://github.com/iambowen
 - 豆瓣: https://www.douban.com/people/iambowen/
 - 角色
  - Ruby/Java/Scala/Web developer
  - DevOps/Ops/Site Performance Engineer
  - Senior Consultant
  - [DevOps Xi'an Meetup](https://www.meetup.com/Xian-DevOps-Meetup/) 发起者

---

### 工作经历

#### Reporting项目(developer/build monkey)
项目内容: 网站所有的web应用通过Adobe Omniture收集访问用户的交互数据，通过建模导入MSSQL服务器。房产信息相关信息保存在MySQL数据库中，Reporting是一个Ruby On Rails应用，通过从MySQL数据库和MSSQL数据库中读取信息，应用业务规则，通过HighCharts将报表展示在网页上。
技术实践:
  - 敏捷开发(Jira)/TDD/BDD/持续集成
  - 利用Chef/AWS/Ruby，开发基于AWS SDK的DSL工具，可以很轻易的用一条命令来在AWS上创建一个完整的E2E的测试环境
主要工作内容: 进行客户要求的功能开发、测试以及交付，保证持续交付流水线的正常工作，维护测试环境的基础设施和配置，修复DSL工具出现的问题。

#### MyAccount 项目(Developer/DevOps)
项目内容: 将主站的用户管理模块从原有的主站单块系统剥离，微服务化，并用基于Scala的Play框架来重新架构，这也是客户第一个基于Scala的项目。
技术实践:
  - 敏捷开发(Leankit)/TDD/持续交付(Bamboo)/基础设施即代码
主要工作内容:
  - 功能开发，持续交付流水线搭建，基础设施建设，自动化部署，监控以及性能测试等
  - 将原有的针对NetScaler/VMware/Nagios的自动化蓝绿部署工具改进为类似PaaS的通用部署工具

#### My Property项目(DevOps/Developer)
项目内容: 收集用户住房信息，建立用户和房产关系。这也是客户第一个前后端分离项目，其中前端使用Nodejs,Grunt workflow，部署在AWS的S3上面，后端使用Scala/Play框架，部署在AWS EC2上面,为了解决前后端分离后集成测试的问题，我们使用了Pact测试，并且针对性的改进了相关的工具，如Pact-Jvm等。
技术实践:
  - 敏捷开发(Leankit)/TDD/持续交付/基础设施即代码/前后端分离/微服务
主要工作内容:
  - 前后端功能实现，Pact测试及工具实现
  - 持续交付流水线搭建，基础设施建设，自动化部署工具，CDN配置
  - 利用Docker去开发可以轻松构建本地E2E测试环境的工具
  - 为提高主站的安全性，实现双token的功能

#### Pixiu(Delivery Engineer) 项目(DevOps)
项目内容: 交付改进的纯工程性项目，内容包含标准化工具以提高开发效率，移植、分解遗留系统为微服务并移植到AWS上，降低运维的难度，提高维护系统的健康，以及提高网站的安全性、性能等。
技术实践:
  - 看板(Trello)/持续交付/基础设施即代码/微服务
主要工作内容:
  - 分解遗留系统，如将其中一个遗留系统拆分成微服务并部署到AWS，每月为客户节省3600$
  - 标准化工具，如开发前端工程，Scala工程的stencil项目，标准化流水线，在AWS上部署的最佳实践，安全扫描工具等
  - 降低运维难度，提高现有系统可维护性，维护现有的服务以及基础设施
  - 参与开发使用AWS和Docker的PaaS部署工具shipper，并使用该工具对微服务进行部署

#### Jade(Custodianship)项目(DevOps/Ops)
项目内容: 业务线负责的所有项目运维，问题修复，以及改进。
主要工作内容:
  - 系统维护，如维护主站的系统的稳定，部署以及问题修复，涉及几十个系统，技术栈涵盖Java/Ruby/Javascript/Nodejs/Scala等
  - 支持功能团队，协助架构设计，部署自动化，一些服务的架构实现使用了无服务器架构AWS Lambda服务，以及大规模实时数据处理和分析服务Kinesis。

#### Data Pipeline项目(DevOps/Ops)
项目内容: 构建数据流水线，应用或者服务器推送实时数据到Kinesis,通过Esper或者Spark去数据汇聚以及处理，然后呈现在类似于Caravel这样的dashboard上。一个实用的案例就是将A/B测试实时数据发送到Kinesis，然后由Esper读取，处理，计算P-Value值，并将结果存入MySQL数据库中。之后在Caravel连接数据库，将数据切分并呈现在Dashboard上面。
主要工作内容:
  - 尝试Data Pipeline流水线的实现，目前有多种解决方案，AWS的Kinesis加Esper、MySQL以及Caravel是已经spike成功的，hackday会尝试Kinesis、Snowplow、Spark、Druid以及Caravel的解决方案
  - 确立Data Pipeline的基础设施架构，并在AWS上部署

---
#### 技能清单
以下均为我熟悉或者了解的技能的清单:
  - Java/Spring/SpringBoot/Junit/Maven/Gradle
  - Ruby/Rails/Rspec/Capybara/Selenium/Cucumber/Rake/Ruby-Jmeter
  - JavaScripts/JQuery/HighCharts/UnderScore/Jasmine/Nodejs/Grunt/Mustache
  - Html5/Haml/CSS/ScSS
  - Scala/Play/Spec2/SBT/Gatling
  - Jenkins/Bamboo/Buildkite
  - Chef/Puppet/Ansible/Shell
  - MySQL/MSSQL/PostgreSQL
  - Splunk/Elastic Search
  - NetScaler/Nagios/VMware/Graphite/Prometheus
  - Akamai/CDN
  - Apache/Nginx/HaProxy
  - Network/Security
  - Newrelic/Pagerdauty/SpeedCurve
  - AWS主要服务(AWS Certified Solution Architect/Developer)
  - Docker/Rancher/Mesos/Kubernates
  - 持续交付/微服务/无服务架构(AWS Lambda)
  - 千万PV网站的运维
  - ……

### 公开课程
 - [微服务架构与实践（综合篇）](http://www.stuq.org/course/detail/1088)：主要讲授高级篇的内容。

### 翻译技术书籍
- [Scala编程实战](http://item.jd.com/11935577.html)
- [DevOps实践：驭DevOps之力强化技术栈并优化IT运行](http://item.jd.com/12035906.html)
- [基础设施即代码:管理云服务器](http://item.jd.com/10452619474.html) 即将出版
- [Devops手册](https://www.amazon.cn/The-Devops-Handbook-How-to-Create-World-Class-Agility-Reliability-and-Security-in-Technology-Organizations-Kim-Gene/dp/1942788002/)在译

### 公开演讲(近两年)

- 2015 CDConf 前后端分离在AWS上的实践
- 2015 Melboure InfraCoder meetup   CI Solution with Mesos
- 2016 DevOps Xi'an Meetup  3 years of DevOps
- 2016 Docker Xi'an Meetup  12 factors app and docker on AWS
- 2016 “说云解惑，共赢云端”技术分享沙龙   前后端分离在AWS上的实践
- 2016 CDConf  大型互联网公司微服务化之路
- 2016 DevOps Xi'an Meetup   BigData和DevOps(从构建数据流水线说起)
