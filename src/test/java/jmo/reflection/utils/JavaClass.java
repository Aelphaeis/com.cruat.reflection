package jmo.reflection.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaClass {
	private static final Package JAVA_LANG_PKG = String.class.getPackage();
	
	Set<Class<?>> imports;
	String name;
	String pkg;
	Map<String, Class<?>> fields;

	boolean isPublic;
	boolean isAbstract;
	boolean isFinal;
	
	public JavaClass() {
		imports = new LinkedHashSet<>();
		fields = new HashMap<>();
	}


	public String toSource(){
		StringBuilder builder = new StringBuilder();
		
		//Package declaration
		builder.append("package ");
		builder.append(getPkg());
		builder.append(";\n\n");

		for(Class<?> cls : getFields().values()) {
			getImports().add(cls);
		}
		
		getImports().remove(null);
		
		for(Class<?> cls : getImports()) {
			Package pac = cls.getPackage();
			if(pac == null || JAVA_LANG_PKG.equals(pac)) {
				continue;
			}
			builder.append("import ");
			builder.append(cls.getName());
			builder.append(";\n");
		}
		
		builder.append("\n");
		List<String> modifiers = new ArrayList<>();
		if(isPublic) {
			modifiers.add("public");
		}
		if(isAbstract) {
			modifiers.add("abstract");
		}
		if(isFinal) {
			modifiers.add("final");
		}
		
		modifiers.add("class");
		modifiers.add(name);
		builder.append(modifiers.stream().collect(Collectors.joining(" ")));
		builder.append(" {\n");
		for(Entry<String, Class<?>> entry : getFields().entrySet()) {
			String key = entry.getKey();
			Class<?> value = entry.getValue();
			
			builder.append("\t");
			builder.append(value.getSimpleName());
			builder.append(' ');
			builder.append(key);
			builder.append(";\n");
		}
		
		builder.append("}");
		return builder.toString();
	}

	public Set<Class<?>> getImports() {
		return imports;
	}


	public void setImports(Set<Class<?>> packageImports) {
		this.imports = packageImports;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPkg() {
		return pkg;
	}


	public void setPkg(String pkg) {
		this.pkg = pkg;
	}


	public Map<String, Class<?>> getFields() {
		return fields;
	}


	public void setFields(Map<String, Class<?>> fields) {
		this.fields = fields;
	}


	public boolean isPublic() {
		return isPublic;
	}


	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}


	public boolean isAbstract() {
		return isAbstract;
	}


	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}


	public boolean isFinal() {
		return isFinal;
	}


	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}


}
