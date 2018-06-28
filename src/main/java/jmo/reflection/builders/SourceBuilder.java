package jmo.reflection.builders;

import static jmo.reflection.builders.SourceBuilderUtils.getTemplate;

import jmo.reflection.core.JClass;

public class SourceBuilder {
	public static final String PACKAGE = "{{package}}";
	public static final String TEMPLATE = getTemplate();


	final JClass<?> cls;

	public SourceBuilder() {
		this(null);
	}
	public SourceBuilder(JClass<?> cls) {
		this.cls = cls;
	}

	public String build() {
		return null;
	}

	@Override
	public String toString() {
		return build();
	}

}
