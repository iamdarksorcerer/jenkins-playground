package io.nineseventwo.sandbox.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ConditionalOnResource(resources = "version.properties")
@Configuration
@ImportResource("version.properties")
public class VersionConfiguration {
	
	@Bean
	public String info(@Value("${info.template}") String infoTemplate,
					   @Value("${application.version}") String version,
					   @Value("${application.revision}") String revision,
					   @Value("${commit.time}") String commitTime,
					   @Value("${build.time}") String buildTime) {
		
		System.out.println(String.format(infoTemplate, version, revision, commitTime, buildTime));
		
		return "XIII 4 LIFE!!!";
	}
	
}
