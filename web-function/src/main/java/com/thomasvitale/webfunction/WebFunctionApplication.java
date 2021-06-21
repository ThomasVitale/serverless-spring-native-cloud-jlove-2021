package com.thomasvitale.webfunction;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebFunctionApplication {

	private static final Logger log = LoggerFactory.getLogger(WebFunctionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebFunctionApplication.class, args);
	}

	@Bean
	Function<String,String> uppercase() {
		return instrument -> {
			log.info("Converting {} to uppercase...", instrument);
			return instrument.toUpperCase();
		};
	}

	@Bean
	Function<Flux<String>, Flux<String>> sentence() {
		return flux -> flux.map(instrument -> {
			log.info("Building sentence for skill...");
			return "I play the " + instrument;
		});
	}

	@Bean
	Function<Instrument,String> uppercaseInstrument() {
		return instrument -> {
			log.info("Converting {} to uppercase...", instrument.getName());
			return instrument.getName().toUpperCase();
		};
	}

	@Bean
	Function<Flux<String>, Flux<Skill>> sentenceSkill() {
		return flux -> flux.map(instrument -> {
			log.info("Building sentence for skill...");
			return new Skill("I play the " + instrument);
		});
	}

}

@Data @NoArgsConstructor @AllArgsConstructor
class Instrument {
	private String name;
}

@Data @NoArgsConstructor @AllArgsConstructor
class Skill {
	private String message;
}