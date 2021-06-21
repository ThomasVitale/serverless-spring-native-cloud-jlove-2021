package com.thomasvitale.webfunction;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
@TestPropertySource(properties = "spring.cloud.function.definition=uppercaseInstrument|sentenceSkill")
class WebFunctionApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void testFunctionDefinitionApi() {
		Skill expectedSkill = new Skill("I play the PIANO");
		webClient.post()
				.bodyValue(new Instrument("piano"))
				.exchange()
				.expectBodyList(Skill.class)
				.contains(expectedSkill);
	}

}
