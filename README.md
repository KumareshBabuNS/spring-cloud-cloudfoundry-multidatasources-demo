A simple application that demonstrates the use of the Spring Cloud Cloud Foundry component to read VCAP_SERVICES and initialize multiple datasources. 

The other purpose of this application is to demonstrate optional credential encryption which is a typical security requirement for PCF customers.


## Testing

This application has been configured with a Default profile with in-memory h2 databases for local development and testing. It has also been configured with a Cloud profile which is designed to use the Spring Cloud Cloud Foundry component to initialize datasources from bound VCAP_SERVICES. 

To test using the Default, local profile:
`./gradlew test`

To test using the Cloud profile: 
`./gradlew mockCloudTest`


## Deploying to Cloud Foundry

You may use either brokered services in Cloud Foundry, or User Provided Services with the Spring Cloud Cloud Foundry component. Documentation on what your User Provided Services must contain in order to work with this component can be found here: http://cloud.spring.io/spring-cloud-connectors/spring-cloud-cloud-foundry-connector.html
 