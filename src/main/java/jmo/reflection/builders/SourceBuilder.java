package jmo.reflection.builders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jmo.reflection.pojos.JClass;
import jmo.reflection.pojos.SourceTemplates;

public class SourceBuilder {
	private static final String TEMP_LOC = "src/main/resources/template.txt";
	private static String getTemplate() {
		try {
			return new String(Files.readAllBytes(Paths.get(TEMP_LOC)));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	final JClass<?> cls;
	String source;

	public SourceBuilder() {
		this(null);
	}
	public SourceBuilder(JClass<?> cls) {
		this.cls = cls;
	}

	public String build() {
		source = getTemplate();
		return source;
	}

	String buildConstruct(JClass<?> type) {
		if (type.isEnum()) {
			return SourceTemplates.CLASS_MODIFIER.format("enum");
		} else if (type.isInterface()) {
			return SourceTemplates.CLASS_MODIFIER.format("interface");
		} else if (type.isAnnotation()) {
			return SourceTemplates.CLASS_MODIFIER.format("@interface");
		} else {
			return SourceTemplates.CLASS_MODIFIER.format("class");
		}
	}

	@Override
	public String toString() {
		return build();
	}
}
