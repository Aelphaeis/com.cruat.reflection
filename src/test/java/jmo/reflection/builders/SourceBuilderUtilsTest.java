package jmo.reflection.builders;

import static jmo.reflection.builders.SourceBuilderUtils.buildModifiers;
import static jmo.reflection.builders.SourceBuilderUtils.buildConstruct;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import jmo.reflection.core.JClass;

@RunWith(MockitoJUnitRunner.class)
public class SourceBuilderUtilsTest {

	@Mock
	JClass<Object> type;

	@Before
	public void setup() {

	}

	@Test
	public void buildClassModifiers_public_public() {
		when(type.getModifiers()).thenReturn(1);
		assertEquals("public ", buildModifiers(type));
	}
	@Test
	public void buildClassModifiers_protected_protected() {
		when(type.getModifiers()).thenReturn(4);
		assertEquals("protected ", buildModifiers(type));
	}

	@Test
	public void buildClassModifiers_abstract_abstract() {
		when(type.getModifiers()).thenReturn(1024);
		assertEquals("abstract ", buildModifiers(type));
	}

	@Test
	public void buildClassModifiers_final_final() {
		when(type.getModifiers()).thenReturn(16);
		assertEquals("final ", buildModifiers(type));
	}

	@Test
	public void buildClassModifiers_strictfp_strictfp() {
		when(type.getModifiers()).thenReturn(2048);
		assertEquals("strictfp ", buildModifiers(type));
	}

	@Test
	public void buildConstruct_nothing_blank() {
		assertEquals("", buildModifiers(type));
	}

	@Test
	public void buildConstruct_enum_enum() {
		when(type.isEnum()).thenReturn(true);
		assertEquals("enum ", buildConstruct(type));
	}

	@Test
	public void buildConstruct_interface_interface() {
		when(type.isInterface()).thenReturn(true);
		assertEquals("interface ", buildConstruct(type));
	}
	@Test
	public void buildConstruct_annotation_annotation() {
		when(type.isAnnotation()).thenReturn(true);
		assertEquals("@interface ", buildConstruct(type));
	}

	@Test
	public void buildConstruct_default_class() {
		assertEquals("class ", buildConstruct(type));
	}
}
