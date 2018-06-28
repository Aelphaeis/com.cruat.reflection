package jmo.reflection.builders;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import jmo.reflection.core.JClass;
import jmo.reflection.core.SourceTemplates;

final class SourceBuilderUtils {
	public static final Package PRIMATIVE_PKG = double.class.getPackage();
	public static final Package LANG_PKG = String.class.getPackage();

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

	public static String buildImports(JClass<?> type) {
		Method[] methods = type.getMethods();
		Set<Class<?>> imports = new LinkedHashSet<>();
		for (Method m : methods) {
			imports.add(m.getReturnType());
			imports.addAll(Arrays.asList(m.getParameterTypes()));
		}
		for (Field f : type.getFields()) {
			imports.add(f.getType());
		}
		StringBuilder builder = new StringBuilder();
		imports.remove(null);
		for (Class<?> importClass : imports) {
			Package pac = importClass.getPackage();
			if (pac == null || LANG_PKG.equals(pac)) {
				continue;
			}
			String importName = importClass.getName();
			builder.append(SourceTemplates.IMPORT.format(importName));
		}
		builder.append('\n');
		return builder.toString();
	}
	
	public static String buildPackage(JClass<?> type) {
		return SourceTemplates.PACKAGE.format(type.getPackage().getName());
	}

	private SourceBuilderUtils() {
		// utility
	}
}
