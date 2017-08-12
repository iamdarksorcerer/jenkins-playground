package io.nineseventwo.sandbox.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
public class AppVersion {
	private String version;
	private String buildTime;
	private String commitId;
	private String commitTime;
	private String commitDirty;
}
