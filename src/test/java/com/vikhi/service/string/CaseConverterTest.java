package com.vikhi.service.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.exercise.string.CaseConverter;

public class CaseConverterTest {

	private CaseConverter converter;
	
	@Before
	public void init() {
		converter = new CaseConverter();
	}
	
	@Test
	public void testConvertToCamelCase() {
		assertEquals("theStealthWarrior", converter.convertToCamelCase("the-stealth-warrior"));
		assertEquals("theStealthWarrior", converter.convertToCamelCase("The_stealth_warrior"));
	}
	
	
	@Test
	public void testConvertToPascalString() {
		
	}
	
	@Test
	public void testConvertToKebabString() {
		
	}
	
	@Test
	public void testConvertToSnakeString() {
		
	}
	
}
