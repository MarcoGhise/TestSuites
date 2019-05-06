###Requirement
- Local Docker environment up & running on port tcp://localhost:2375
- Java 1.8

###Running Steps
- Create Upload Docker image `mvn clean package docker:build docker:start` 
- Run Test on SpringTddExample `mvn clean verify -P docker`
- Destroy Upload Docker image `mvn docker:stop`  

###Test
- `SpringTddExampleApplicationFT` - Functional Test
- `SpringTddExampleApplicationIT` - Integration Test
- `SpringTddExampleApplicationTests` - Unit Test
- `SpringTddExampleApplicationMockito` - Integration Test with Mockito