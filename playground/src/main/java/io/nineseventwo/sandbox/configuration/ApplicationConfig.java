package io.nineseventwo.sandbox.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
public class ApplicationConfig {
	@Bean
	public CommandLineRunner commandLineRunner(@Value("${application.message.template}") String messageTemplate,
											   @Value("${application.message.profile}") String profile) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println(String.format(messageTemplate, profile));
			}
		};
	}
}
