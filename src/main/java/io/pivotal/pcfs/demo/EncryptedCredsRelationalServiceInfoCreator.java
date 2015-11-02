package io.pivotal.pcfs.demo;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class EncryptedCredsRelationalServiceInfoCreator extends CloudFoundryServiceInfoCreator<EncryptedCredentialsServiceInfo>  {

	public EncryptedCredsRelationalServiceInfoCreator(){
		this(new Tags(""), new String[]{});
	}
	
	public EncryptedCredsRelationalServiceInfoCreator(Tags tags, String[] uriSchemes) {
		super(tags, uriSchemes);
	}

	public EncryptedCredentialsServiceInfo createServiceInfo(Map<String, Object> serviceData) {
		System.out.println("service data: " + serviceData);
		
		@SuppressWarnings("unchecked")
		Map<String, String> credentials = (Map<String, String>) serviceData.get("credentials");
		String serviceId = (String)serviceData.get("name");
		String host = credentials.get("host");

		int port = -1;
		if(credentials.containsKey("port")){
			port = Integer.parseInt(credentials.get("port"));
		}
		
		String username = credentials.get("username");
		String password = credentials.get("password");
		String jdbcUrl = credentials.get("jdbcUrl");
		String driverClassName = credentials.get("driverClassName");
		
		return new EncryptedCredentialsServiceInfo(serviceId, driverClassName, host, port, username, password, jdbcUrl);
	}
}
