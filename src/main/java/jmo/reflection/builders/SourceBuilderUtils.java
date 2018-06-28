package jmo.reflection.builders;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;

import jmo.reflection.core.JClass;
import jmo.reflection.core.SourceTemplates;

final class SourceBuilderUtils {

	private static final String TEMP_LOC = "src/main/resources/template.txt";
	public static String getTemplate() {
		try {
			return new String(Files.readAllBytes(Paths.get(TEMP_LOC)));
		} catch (IOException e) {
			// should never happen.
			throw new IllegalStateException(e);
		}
	}

	public String buildConstruct(JClass<?> type) {
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

	public static String buildClassModifiers(JClass<?> type) {
		int mods = type.getModifiers();
		StringBuilder builder = new StringBuilder();
		if (Modifier.isPublic(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("public"));
		} else if (Modifier.isProtected(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("protected"));
		}

		if (Modifier.isAbstract(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("abstract"));
		} else if (Modifier.isFinal(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("final"));
		}

		if (Modifier.isStrict(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("strictfp"));
		}
		return builder.toString();
	}

	private SourceBuilderUtils() {
		// utility
	}
}
