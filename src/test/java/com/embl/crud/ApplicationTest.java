package com.embl.crud;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

	String[] applicationArguments;

	@Before
	public void setup() {
		applicationArguments = new String[] {};
	}

	@Test
	public void testMain() {
		Application.main(applicationArguments);
	}

}
