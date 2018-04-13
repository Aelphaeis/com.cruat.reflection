package jmo.reflection.utils;

import org.junit.Test;

public class SourceUtilsTest {

	@Test
	public void test() {
		System.out.println(SourceUtils.buildSource(JavaClass.class));
	}

}
