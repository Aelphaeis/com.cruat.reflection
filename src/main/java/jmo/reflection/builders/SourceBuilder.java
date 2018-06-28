package jmo.reflection.builders;

import static jmo.reflection.builders.SourceBuilderUtils.*;

import java.util.Objects;

import jmo.reflection.core.JClass;

public class SourceBuilder {
	public static final String PACKAGE = "{{package}}";
	public static final String IMPORTS = "{{imports}}";
	public static final String C_ANNOTATION = "{{c-annotation}}";
	public static final String C_MODIFIERS = "{{c-modifiers}}";
	public static final String CONSTRUCT = "{{construct}}";
	public static final String C_NAME = "{{c-name}}";
	public static final String S_FIELDS = "{{s-fields}}";
	public static final String S_METHODS = "{{s-methods}}";
	public static final String I_FIELDS = "{{i-fields}}";
	public static final String CTORS = "{{ctors}}";
	public static final String METHODS = "{{methods}}";
	public static final String TEMPLATE = getTemplate();

	final JClass<?> cls;

	public SourceBuilder(JClass<?> cls) {
		Objects.requireNonNull(cls);
		this.cls = cls;
	}

	public String build() {
		StringBuilder builder = new StringBuilder();
		builder.append(buildPackage(cls));
		builder.append(buildImports(cls));
		builder.append(buildClassModifiers(cls));
		builder.append(buildConstruct(cls));
		builder.append(buildName(cls));
		return builder.toString();
	}
	
	

	@Override
	public String toString() {
		return build();
	}

}
