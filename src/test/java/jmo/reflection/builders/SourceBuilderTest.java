package jmo.reflection.builders;

import org.junit.Test;

import jmo.reflection.core.JClass;
import jmo.reflection.core.JClassDecorator;

public class SourceBuilderTest {

	@Test
	public void test() {
		JClass<SourceBuilder> cls = new JClassDecorator<>(SourceBuilder.class);
		System.out.println(new SourceBuilder(cls));
	}
	@Test(expected = NullPointerException.class)
	public void ctor_null_NPE() {
		new SourceBuilder(null);
	}

}
