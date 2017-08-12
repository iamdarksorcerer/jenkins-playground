package io.nineseventwo.sandbox.configuration;

import io.nineseventwo.sandbox.dto.AppVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConditionalOnResource(resources = "version.properties")
@Configuration
@PropertySource("version.properties")
@Slf4j
public class VersionConfig {
	
	@Bean
	public AppVersion appVersion(@Value("${application.version}") String version,
								 @Value("${application.build.time}") String buildTime,
								 @Value("${application.commit.id}") String commitId,
								 @Value("${application.commit.time}") String commitTime,
								 @Value("${application.commit.dirty}") String commitDirty) {
		final AppVersion appVersion = AppVersion.builder()
				.version(version)
				.buildTime(buildTime)
				.commitId(commitId)
				.commitTime(commitTime)
				.commitDirty(commitDirty)
				.build();
	
		log.info(appVersion.toString());
		
		return appVersion;
	}
	
}
