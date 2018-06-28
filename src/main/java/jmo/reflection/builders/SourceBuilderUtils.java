package jmo.reflection.builders;

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
	private SourceBuilderUtils() {
		// utility
	}
}
