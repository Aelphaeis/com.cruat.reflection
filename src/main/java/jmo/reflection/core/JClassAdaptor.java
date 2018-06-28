package jmo.reflection.core;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Objects;

import jmo.reflection.exceptions.ReflectionRuntimeException;

public class JClassAdaptor<T> implements JClass<T> {

	final Class<T> cls;

	public JClassAdaptor(Class<T> cls) {
		Objects.requireNonNull(cls);
		this.cls = cls;
	}

	public String toGenericString() {
		return cls.toGenericString();
	}

	public T newInstance() {
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public boolean isInstance(Object obj) {
		return cls.isInstance(obj);
	}

	public boolean isAssignableFrom(Class<?> cls) {
		return cls.isAssignableFrom(cls);
	}

	public boolean isInterface() {
		return cls.isInterface();
	}

	public boolean isArray() {
		return cls.isArray();
	}

	public boolean isPrimitive() {
		return cls.isPrimitive();
	}

	public boolean isAnnotation() {
		return cls.isAnnotation();
	}

	public boolean isSynthetic() {
		return cls.isSynthetic();
	}

	public String getName() {
		return cls.getName();
	}

	public ClassLoader getClassLoader() {
		return cls.getClassLoader();
	}

	public TypeVariable<Class<T>>[] getTypeParameters() {
		return cls.getTypeParameters();
	}

	public Class<? super T> getSuperclass() {
		return cls.getSuperclass();
	}

	public Type getGenericSuperclass() {
		return cls.getGenericSuperclass();
	}

	public Package getPackage() {
		return cls.getPackage();
	}

	public Class<?>[] getInterfaces() {
		return cls.getInterfaces();
	}

	public Type[] getGenericInterfaces() {
		return cls.getGenericInterfaces();
	}

	public Class<?> getComponentType() {
		return cls.getComponentType();
	}

	public int getModifiers() {
		return cls.getModifiers();
	}

	public Object[] getSigners() {
		return cls.getSigners();
	}

	public Method getEnclosingMethod() {
		return cls.getEnclosingMethod();
	}

	public Constructor<?> getEnclosingConstructor() {
		return cls.getEnclosingConstructor();
	}

	public Class<?> getDeclaringClass() {
		return cls.getDeclaringClass();
	}

	public Class<?> getEnclosingClass() {
		return cls.getEnclosingClass();
	}

	public String getSimpleName() {
		return cls.getSimpleName();
	}

	public String getTypeName() {
		return cls.getTypeName();
	}

	public String getCanonicalName() {
		return cls.getCanonicalName();
	}

	public boolean isAnonymousClass() {
		return cls.isAnonymousClass();
	}

	public boolean isLocalClass() {
		return cls.isLocalClass();
	}

	public boolean isMemberClass() {
		return cls.isMemberClass();
	}

	public Class<?>[] getClasses() {
		return cls.getClasses();
	}

	public Field[] getFields() {
		return cls.getFields();
	}

	public Method[] getMethods() {
		return cls.getMethods();
	}

	public Constructor<?>[] getConstructors() {
		return cls.getConstructors();
	}

	public Field getField(String name) {
		try {
			return cls.getField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public Method getMethod(String name, Class<?>... parameterTypes) {
		try {
			return cls.getMethod(name, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public Constructor<T> getConstructor(Class<?>... parameterTypes) {
		try {
			return cls.getConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public Class<?>[] getDeclaredClasses() {
		return cls.getDeclaredClasses();
	}

	public Field[] getDeclaredFields() {
		return cls.getDeclaredFields();
	}

	public Method[] getDeclaredMethods() {
		return cls.getDeclaredMethods();
	}

	public Constructor<?>[] getDeclaredConstructors() {
		return cls.getDeclaredConstructors();
	}

	public Field getDeclaredField(String name) {
		try {
			return cls.getDeclaredField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public Method getDeclaredMethod(String name, Class<?>... parameterTypes) {
		try {
			return cls.getDeclaredMethod(name, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) {
		try {
			return cls.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectionRuntimeException(e);
		}
	}

	public InputStream getResourceAsStream(String name) {
		return cls.getResourceAsStream(name);
	}

	public URL getResource(String name) {
		return cls.getResource(name);
	}

	public ProtectionDomain getProtectionDomain() {
		return cls.getProtectionDomain();
	}

	public boolean desiredAssertionStatus() {
		return cls.desiredAssertionStatus();
	}

	public boolean isEnum() {
		return cls.isEnum();
	}

	public T[] getEnumConstants() {
		return cls.getEnumConstants();
	}

	public T cast(Object obj) {
		return cls.cast(obj);
	}

	public <U> Class<? extends U> asSubclass(Class<U> clazz) {
		return cls.asSubclass(clazz);
	}

	public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
		return cls.getAnnotation(annotationClass);
	}

	public boolean isAnnotationPresent(
			Class<? extends Annotation> annotationClass) {
		return cls.isAnnotationPresent(annotationClass);
	}

	public <A extends Annotation> A[] getAnnotationsByType(Class<A> a) {
		return cls.getAnnotationsByType(a);
	}

	public Annotation[] getAnnotations() {
		return cls.getAnnotations();
	}

	public <A extends Annotation> A getDeclaredAnnotation(Class<A> a) {
		return cls.getDeclaredAnnotation(a);
	}

	public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> a) {
		return cls.getDeclaredAnnotationsByType(a);
	}

	public Annotation[] getDeclaredAnnotations() {
		return cls.getDeclaredAnnotations();
	}

	public AnnotatedType getAnnotatedSuperclass() {
		return cls.getAnnotatedSuperclass();
	}

	public AnnotatedType[] getAnnotatedInterfaces() {
		return cls.getAnnotatedInterfaces();
	}
}
