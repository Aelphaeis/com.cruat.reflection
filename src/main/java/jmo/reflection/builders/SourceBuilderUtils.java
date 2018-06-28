package jmo.reflection.builders;

import java.lang.reflect.Modifier;

import jmo.reflection.core.JClass;
import jmo.reflection.core.SourceTemplates;

final class SourceBuilderUtils {

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
