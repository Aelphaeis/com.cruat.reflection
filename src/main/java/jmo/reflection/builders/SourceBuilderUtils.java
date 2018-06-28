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
import jmo.reflection.core.JField;
import jmo.reflection.core.JFieldAdaptor;
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

	public static String buildConstruct(JClass<?> type) {
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

	public static String buildModifiers(JClass<?> type) {
		return buildModifiers(type.getModifiers());
	}

	private static String buildModifiers(int mods) {
		String result = Modifier.toString(mods);
		return result.equals("") ? result : result + " ";
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

	public static String buildInstanceFields(JClass<?> type) {
		StringBuilder builder = new StringBuilder();
		for (Field field : type.getDeclaredFields()) {
			JField jfield = new JFieldAdaptor(field);
			builder.append(buildInstanceField(jfield));
			builder.append("\n");
		}

		for (Field field : type.getFields()) {
			JField jfield = new JFieldAdaptor(field);
			builder.append(buildInstanceField(jfield));
			builder.append("\n");
		}
		return builder.toString();
	}
	public static String buildInstanceField(JField f) {
		StringBuilder builder = new StringBuilder(f.getModifiers());
		builder.append(f.getType().getSimpleName());
		builder.append(' ');
		builder.append(f.getName());
		builder.append(';');
		return builder.toString();
	}

	public static String buildModifiers(JField type) {
		return buildModifiers(type.getModifiers());
	}

	public static String buildPackage(JClass<?> type) {
		return SourceTemplates.PACKAGE.format(type.getPackage().getName());
	}

	public static String buildName(JClass<?> type) {
		return type.getSimpleName();
	}

	private SourceBuilderUtils() {
		// utility
	}
}
