package jmo.reflection.builders;

import static org.junit.Assert.*;

import org.junit.Test;

public class SourceBuilderTest {

	@Test
	public void test() {
		SourceBuilder sb = new SourceBuilder();
		System.out.println(sb.build());
	}

}
