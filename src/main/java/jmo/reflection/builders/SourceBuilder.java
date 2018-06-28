package jmo.reflection.builders;

import static jmo.reflection.builders.SourceBuilderUtils.*;

import java.util.Objects;

import jmo.reflection.core.JClass;

public class SourceBuilder {

	final JClass<?> cls;

	public SourceBuilder(JClass<?> cls) {
		Objects.requireNonNull(cls);
		this.cls = cls;
	}

	public String build() {
		StringBuilder builder = new StringBuilder();
		builder.append(buildPackage(cls));
		builder.append(buildImports(cls));
		builder.append(buildModifiers(cls));
		builder.append(buildConstruct(cls));
		builder.append(buildName(cls));
		return builder.toString();
	}

	@Override
	public String toString() {
		return build();
	}

}
