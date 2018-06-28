package jmo.reflection.builders;

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
	public void buildConstruct_enum_enum() {
		when(type.isEnum()).thenReturn(true);
		assertEquals("enum ", SourceBuilderUtils.buildConstruct(type));
	}
	@Test
	public void buildConstruct_interface_interface() {
		when(type.isInterface()).thenReturn(true);
		assertEquals("interface ", SourceBuilderUtils.buildConstruct(type));
	}
	@Test
	public void buildConstruct_annotation_annotation() {
		when(type.isAnnotation()).thenReturn(true);
		assertEquals("@interface ", SourceBuilderUtils.buildConstruct(type));
	}

	@Test
	public void buildConstruct_default_class() {
		assertEquals("class ", SourceBuilderUtils.buildConstruct(type));
	}
}
