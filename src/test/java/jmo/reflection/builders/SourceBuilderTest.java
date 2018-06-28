package jmo.reflection.builders;

import org.junit.Test;

public class SourceBuilderTest {

	@Test(expected = NullPointerException.class)
	public void ctor_null_NPE() {
		new SourceBuilder(null);
	}

}
