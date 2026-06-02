package com.tshapedcoding.banking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankingAppApplicationTests {

	@Test
	void contextLoads() {
	}

	public void testMethod() {
		String text = null;
		System.out.println(text.length()); // Intentional NullPointerException risk
	}
}
