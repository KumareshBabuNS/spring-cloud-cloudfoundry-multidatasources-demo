package io.pivotal.pcfs.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class SpringApplicationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstanceHappyPath() {
		assertNotNull(SpringApplication.getInstance());
	}

	@Test
	public void testGetInventoryDatasourceHappyPath() {
		assertNotNull(SpringApplication.getInstance().getInventoryDatasource());
	}

	@Test
	public void testGetProductDatasourceHappyPath() {
		assertNotNull(SpringApplication.getInstance().getProductDatasource());
	}

}
