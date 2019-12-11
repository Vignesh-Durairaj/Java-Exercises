package com.vikhi.service.string;

import static org.junit.Assert.assertEquals;

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
		assertEquals("TheStealthWarrior", converter.convertToPascalCase("the-stealth-warrior"));
		assertEquals("TheStealthWarrior", converter.convertToPascalCase("The_stealth_warrior"));
	}
	
	@Test
	public void testConvertToKebabString() {
		assertEquals("the-stealth-warrior", converter.convertToKebabCase("TheStealthWarrior"));
		assertEquals("the-stealth-warrior", converter.convertToKebabCase("theStealthWarrior"));
	}
	
	@Test
	public void testConvertToSnakeString() {
		assertEquals("the_stealth_warrior", converter.convertToCamelCase("TheStealthWarrior"));
		assertEquals("the_stealth_warrior", converter.convertToCamelCase("theStealthWarrior"));
	}
	
}
