package io.pivotal.pcfs.demo;

import org.springframework.cloud.service.UriBasedServiceInfo;
import org.springframework.cloud.service.common.RelationalServiceInfo;

public class EncryptedCredentialsServiceInfo extends RelationalServiceInfo {


	private final String driverClassName;
	private final String jdbcUrl;
	
  // Needed to support structured service definitions such as Cloud Foundry's
//    public EncryptedCredentialsServiceInfo(String id, String driverClassName, String host, int port, String username, String password, String jdbcUrl) {
//    	super(id, RelationalServiceInfo.JDBC_PREFIX, host, port, username, password, null);
//    	this.driverClassName = driverClassName;
//    	this.jdbcUrl = jdbcUrl;
//    }


	public EncryptedCredentialsServiceInfo(String id, String uriString, String jdbcUrlDatabaseType) {
		super(id, uriString, jdbcUrlDatabaseType);
		this.driverClassName = null;
    	this.jdbcUrl = null;
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
}
