package io.pivotal.pcfs.demo;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.dbcp2.BasicDataSource;

public class EncryptedCredentialsBasicDataSource extends BasicDataSource {

	private final Base64 base64 = new Base64();
	
	private String decode(String password) {
		System.out.println("Decoding password: " + password);
		
		if(password == null){
			return password;
		}
		
        byte[] decodedBytes = base64.decode(password.getBytes());
    	String decodedPassword = new String(decodedBytes);   
        return decodedPassword;
    }

	@Override
	public void setPassword(String password) {
		super.setPassword(decode(password));
	}
	
	
	
}
