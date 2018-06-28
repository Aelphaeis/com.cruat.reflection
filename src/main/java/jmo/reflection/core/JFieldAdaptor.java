package jmo.reflection.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;

import jmo.reflection.exceptions.ReflectionRuntimeException;

public class JFieldAdaptor implements JField {
	Field field;

	public JFieldAdaptor(Field field) {
		Objects.requireNonNull(field);
		this.field = field;
	}

	public void setAccessible(boolean flag) {
		field.setAccessible(flag);
	}

	public Class<?> getDeclaringClass() {
		return field.getDeclaringClass();
	}

	public String getName() {
		return field.getName();
	}

	public boolean isAccessible() {
		return field.isAccessible();
	}

	public int getModifiers() {
		return field.getModifiers();
	}

	public boolean isEnumConstant() {
		return field.isEnumConstant();
	}

	public boolean isSynthetic() {
		return field.isSynthetic();
	}

	public Class<?> getType() {
		return field.getType();
	}

	public boolean isAnnotationPresent(Class<? extends Annotation> a) {
		return field.isAnnotationPresent(a);
	}

	public Type getGenericType() {
		return field.getGenericType();
	}

	public Annotation[] getAnnotations() {
		return field.getAnnotations();
	}

	public <T extends Annotation> T getDeclaredAnnotation(Class<T> a) {
		return field.getDeclaredAnnotation(a);
	}

	public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> a) {
		return field.getDeclaredAnnotationsByType(a);
	}

	public String toGenericString() {
		return field.toGenericString();
	}

	public Object get(Object obj) {
		try {
			return field.get(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public boolean getBoolean(Object obj) {
		try {
			return field.getBoolean(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public byte getByte(Object obj) {
		try {
			return field.getByte(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public char getChar(Object obj) {
		try {
			return field.getChar(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public short getShort(Object obj) {
		try {
			return field.getShort(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public int getInt(Object obj) {
		try {
			return field.getInt(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public long getLong(Object obj) {
		try {
			return field.getLong(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public float getFloat(Object obj) {
		try {
			return field.getFloat(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public double getDouble(Object obj) {
		try {
			return field.getDouble(obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void set(Object obj, Object value) {
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setBoolean(Object obj, boolean z) {
		try {
			field.setBoolean(obj, z);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setByte(Object obj, byte b) {
		try {
			field.setByte(obj, b);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setChar(Object obj, char c) {
		try {
			field.setChar(obj, c);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setShort(Object obj, short s) {
		try {
			field.setShort(obj, s);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setInt(Object obj, int i) {
		try {
			field.setInt(obj, i);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setLong(Object obj, long l) {
		try {
			field.setLong(obj, l);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setFloat(Object obj, float f) {
		try {
			field.setFloat(obj, f);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public void setDouble(Object obj, double d) {
		try {
			field.setDouble(obj, d);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public <T extends Annotation> T getAnnotation(Class<T> a) {
		return field.getAnnotation(a);
	}

	public <T extends Annotation> T[] getAnnotationsByType(Class<T> a) {
		return field.getAnnotationsByType(a);
	}

	public Annotation[] getDeclaredAnnotations() {
		return field.getDeclaredAnnotations();
	}

	public AnnotatedType getAnnotatedType() {
		return field.getAnnotatedType();
	}
}
