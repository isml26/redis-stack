# Redis Stack - Rapid API

### Reference Documentation
For further reference, please consider the following sections:

* [Redis Stack](https://redis.io/docs/about/about-stack/)
* [Rapid API](https://rapidapi.com/Coinranking/api/coinranking1)
### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Bilding REST services with Springu](https://spring.io/guides/tutorials/rest/)

### Getting started
#### To start Redis Stack server using the redis-stack image, run the following command in your terminal:

docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest

#### You can then connect to the server using redis-cli, just as you connect to any Redis instance.

#### If you don’t have redis-cli installed locally, you can run it from the Docker container:

$ docker exec -it redis-stack redis-cli