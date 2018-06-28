package jmo.reflection.core;

public enum SourceTemplates {
	PACKAGE("package %s;\n\n"),
	IMPORT("import %s;\n"),
	CLASS_MODIFIER("%s "),
	TYPE("%s {\n%s\n}"),
	FIELD_MODIFER("%s "),
	VARIABLE("%s %s;\n");
	
	String srcTemplate;
	
	SourceTemplates() {
	}
	
	SourceTemplates(String template) {
		setSrcTemplate(template);
	}
	
	public String format(Object... args) {
		return String.format(srcTemplate, args);
	}

	public String getSrcTemplate() {
		return srcTemplate;
	}

	private void setSrcTemplate(String srcTemplate) {
		this.srcTemplate = srcTemplate;
	}
}
