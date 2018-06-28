package jmo.reflection.pojos;

public class JClass<T> {
	Class<T> cls;

	public JClass() {

	}

	public JClass(Class<T> cls) {
		this();
		this.cls = cls;
	}
}
