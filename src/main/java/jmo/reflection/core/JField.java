package jmo.reflection.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;

public interface JField {
	void setAccessible(boolean flag);
	Class<?> getDeclaringClass();
	String getName();
	boolean isAccessible();
	int getModifiers();
	boolean isEnumConstant();
	boolean isSynthetic();
	Class<?> getType();
	boolean isAnnotationPresent(Class<? extends Annotation> a);
	Type getGenericType();
	Annotation[] getAnnotations();
	<T extends Annotation> T getDeclaredAnnotation(Class<T> a);
	<T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> a);
	String toGenericString();
	Object get(Object obj);
	boolean getBoolean(Object obj);
	byte getByte(Object obj);
	char getChar(Object obj);
	short getShort(Object obj);
	int getInt(Object obj);
	long getLong(Object obj);
	float getFloat(Object obj);
	double getDouble(Object obj);
	void set(Object obj, Object value);
	void setBoolean(Object obj, boolean z);
	void setByte(Object obj, byte b);
	void setChar(Object obj, char c);
	void setShort(Object obj, short s);
	void setInt(Object obj, int i);
	void setLong(Object obj, long l);
	void setFloat(Object obj, float fl);
	void setDouble(Object obj, double d);
	<T extends Annotation> T getAnnotation(Class<T> a);
	<T extends Annotation> T[] getAnnotationsByType(Class<T> a);
	Annotation[] getDeclaredAnnotations();
	AnnotatedType getAnnotatedType();
}
