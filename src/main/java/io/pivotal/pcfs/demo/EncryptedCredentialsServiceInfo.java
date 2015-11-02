package io.pivotal.pcfs.demo;

import org.springframework.cloud.service.UriBasedServiceInfo;
import org.springframework.cloud.service.common.RelationalServiceInfo;

public class EncryptedCredentialsServiceInfo extends UriBasedServiceInfo {


	private final String driverClassName;
	private final String jdbcUrl;
	
    public EncryptedCredentialsServiceInfo(String id, String driverClassName, String host, int port, String username, String password, String jdbcUrl) {
    	super(id, RelationalServiceInfo.JDBC_PREFIX, host, port, username, password, null);
    	this.driverClassName = driverClassName;
    	this.jdbcUrl = jdbcUrl;
    }

	
	public String getDriverClassName() {
		return driverClassName;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
}
