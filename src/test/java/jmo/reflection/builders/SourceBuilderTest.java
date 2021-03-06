package jmo.reflection.builders;

import org.junit.Test;

import jmo.reflection.core.JClass;
import jmo.reflection.core.JClassAdaptor;

public class SourceBuilderTest {

	@Test
	public void test() {
		JClass<SourceBuilder> cls = new JClassAdaptor<>(SourceBuilder.class);
		System.out.println(SourceBuilderUtils.buildInstanceFields(cls));
	}
	@Test(expected = NullPointerException.class)
	public void ctor_null_NPE() {
		new SourceBuilder(null);
	}

}
