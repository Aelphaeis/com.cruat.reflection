package jmo.reflection.pojos;

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

public interface JClass<T> {
	public String toGenericString();
	public T newInstance();
	public boolean isInstance(Object obj);
	public boolean isAssignableFrom(Class<?> cls);
	public boolean isInterface();
	public boolean isArray();
	public boolean isAnnotation();
	public boolean isSynthetic();
	public String getName();
	public ClassLoader getClassLoader();
	public TypeVariable<Class<T>>[] getTypeParameters();
	public Class<? super T> getSuperclass();
	public Type getGenericSuperclass();
	public Package getPackage();
	public Class<?>[] getInterfaces();
	public Type[] getGenericInterfaces();
	public Class<?> getComponentType();
	public int getModifiers();
	public Object[] getSigners();
	public Method getEnclosingMethod();
	public Constructor<?> getEnclosingConstructor();
	public Class<?> getDeclaringClass();
	public Class<?> getEnclosingClass();
	public String getSimpleName();
	public String getTypeName();
	public String getCanonicalName();
	public boolean isAnonymousClass();
	public boolean isLocalClass();
	public boolean isMemberClass();
	public Class<?>[] getClasses();
	public Field[] getFields();
	public Method[] getMethods();
	public Constructor<?>[] getConstructors();
	public Field getField(String name);
	public Method getMethod(String name, Class<?>... parameterTypes);
	public Constructor<T> getConstructor(Class<?>... parameterTypes);
	public Class<?>[] getDeclaredClasses();
	public Field[] getDeclaredFields();
	public Method[] getDeclaredMethods();
	public Constructor<?>[] getDeclaredConstructors();
	public Field getDeclaredField(String name);
	public Method getDeclaredMethod(String name, Class<?>... parameterTypes);
	public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes);
	public InputStream getResourceAsStream(String name);
	public URL getResource(String name);
	public ProtectionDomain getProtectionDomain();
	public boolean desiredAssertionStatus();
	public boolean isEnum();
	public T[] getEnumConstants();
	public T cast(Object obj);
	public <U> Class<? extends U> asSubclass(Class<U> clazz);
	public <A extends Annotation> A getAnnotation(Class<A> annotationClass);
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);
	public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass);
	public Annotation[] getAnnotations();
	public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass);
	public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass);
	public Annotation[] getDeclaredAnnotations();
	public AnnotatedType getAnnotatedSuperclass();
	public AnnotatedType[] getAnnotatedInterfaces();
}
