package io.nineseventwo.sandbox.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationConfig {
	@Bean
	public CommandLineRunner commandLineRunner(@Value("${application.message.template}") String messageTemplate,
											   @Value("${application.message.profile}") String profile) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.info(messageTemplate, profile);
			}
		};
	}
}
