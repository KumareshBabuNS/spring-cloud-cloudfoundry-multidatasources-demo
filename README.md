A simple application that demonstrates the use of the Spring Cloud Cloud Foundry component to read VCAP_SERVICES and initialize multiple datasources. 

The other purpose of this application is to demonstrate optional credential encryption which is a typical security requirement for PCF customers.


## Testing

This application has been configured with a Default profile with in-memory h2 databases for local development and testing. It has also been configured with a Cloud profile which is designed to use the Spring Cloud CloudFoundry component to initialize datasources from bound VCAP_SERVICES. 

To test using the Default, local profile:
`./gradlew test`

To test using the Cloud profile (currently fails, need help with this one):
`./gradlew test -Dspring.profiles.active=cloud`

TODO: set the VCAP_SERVICES variable with the two services required to run the Cloud profile.
 