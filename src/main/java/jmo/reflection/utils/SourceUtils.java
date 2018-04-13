package jmo.reflection.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import jmo.reflection.pojos.SourceTemplates;

public class SourceUtils {
	public static final Package PRIMATIVE_PKG = double.class.getPackage();
	public static final Package LANG_PKG = String.class.getPackage();
	
	public static String buildSource(Class<?> type) {
		StringBuilder builder = new StringBuilder();
		builder.append(buildPackage(type));
		builder.append(buildImports(type));
		builder.append(buildTopTypeModifiers(type));
		builder.append(buildTypeContent(type));
		return builder.toString();
	}
	
	static String buildPackage(Class<?> type) {
		return SourceTemplates.PACKAGE.format(type.getPackage().getName());
	}
	
	static String buildImports(Class<?> type) {
		Method[] methods = type.getMethods();
		Set<Class<?>> imports = new LinkedHashSet<>();
		for(Method m  : methods) {
			imports.add(m.getReturnType());
			imports.addAll(Arrays.asList(m.getParameterTypes()));
		}
		for(Field f : type.getFields()) {
			imports.add(f.getType());
		}
		StringBuilder builder = new StringBuilder();
		imports.remove(null);
		for(Class<?> importClass : imports) {
			Package pac = importClass.getPackage();
			if(pac == null || LANG_PKG.equals(pac)) {
				continue;
			}
			String importName = importClass.getName();
			builder.append(SourceTemplates.IMPORT.format(importName));
		}
		builder.append('\n');
		return builder.toString();
	}
	
	static String buildTopTypeModifiers(Class<?> type) {
		int mods = type.getModifiers();
		StringBuilder builder = new StringBuilder();
		if(Modifier.isPublic(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("public"));
		}
		else if (Modifier.isProtected(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("protected"));
		}
		
		if(Modifier.isAbstract(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("abstract"));
		}
		else if(Modifier.isFinal(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("final"));
		}
		
		if(Modifier.isStrict(mods)) {
			builder.append(SourceTemplates.CLASS_MODIFIER.format("strictfp"));
		}
		builder.append(buildType(type));
		return builder.toString();
	}
	
	static String buildTypeContent(Class<?> type) {
		StringBuilder content = new StringBuilder();
		return SourceTemplates.TYPE.format(type.getSimpleName(), content);
	}
	
	static String buildType(Class<?> type) {
		if(type.isEnum()) {
			return SourceTemplates.CLASS_MODIFIER.format("enum");
		}
		else if(type.isInterface()) {
			return SourceTemplates.CLASS_MODIFIER.format("interface");
		}
		else if(type.isAnnotation()){
			return SourceTemplates.CLASS_MODIFIER.format("@interface");
		}
		else {
			return SourceTemplates.CLASS_MODIFIER.format("class");
		}
	}
	
	
	
	private SourceUtils() {
		//utility class
	}
}
