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
	
	//TODO constructors
	//TODO methods

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
		LinkedHashSet<Field> fields = new LinkedHashSet<>();
		fields.addAll(Arrays.asList(type.getFields()));
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

		for (Field field : fields) {
			JField jfield = new JFieldAdaptor(field);
			builder.append(buildInstanceField(jfield));
			builder.append("\n");
		}

		return builder.toString();
	}
	public static String buildInstanceField(JField f) {
		//TODO Annotations for fields
		StringBuilder builder = new StringBuilder(buildModifiers(f));
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
