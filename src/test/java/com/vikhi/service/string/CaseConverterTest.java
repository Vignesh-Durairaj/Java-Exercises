package com.vikhi.service.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.vikhi.exercise.string.CaseConverter;

public class CaseConverterTest {

	private static final String MSG_EXCEPTION_EXPECTED = "An Exception is expected and should not execute this line of code";
	private final Logger logger = Logger.getLogger(this.getClass());
	private CaseConverter converter;
	
	@Before
	public void init() {
		converter = new CaseConverter();
	}
	
	@Test
	public void testConvertToCamelCase() {
		assertEquals("theStealthWarrior", converter.convertToCamelCase("the-stealth-warrior"));
		assertEquals("theStealthWarrior", converter.convertToCamelCase("The_stealth_warrior"));
		assertEquals("a", converter.convertToCamelCase("a"));
		assertEquals("", converter.convertToCamelCase(""));
		assertEquals("theStealthWarrior", converter.convertToCamelCase("TheStealthWarrior"));
	}
	
	
	@Test
	public void testConvertToPascalString() {
		assertEquals("TheStealthWarrior", converter.convertToPascalCase("the-stealth-warrior"));
		assertEquals("TheStealthWarrior", converter.convertToPascalCase("The_stealth_warrior"));
		assertEquals("A", converter.convertToPascalCase("a"));
		assertEquals("", converter.convertToPascalCase(""));
		assertEquals("TheStealthWarrior", converter.convertToPascalCase("theStealthWarrior"));
	}
	
	@Test
	public void testConvertToKebabString() {
		assertEquals("the-stealth-warrior", converter.convertToKebabCase("TheStealthWarrior"));
		assertEquals("the-stealth-warrior", converter.convertToKebabCase("theStealthWarrior"));
		assertEquals("the-stealth-warrior", converter.convertToKebabCase("The-stealth-warrior"));
		assertEquals("a", converter.convertToKebabCase("A"));
		assertEquals("", converter.convertToKebabCase(""));
	}
	
	@Test
	public void testConvertToSnakeString() {
		assertEquals("the_stealth_warrior", converter.convertToSnakeCase("TheStealthWarrior"));
		assertEquals("the_stealth_warrior", converter.convertToSnakeCase("theStealthWarrior"));
		assertEquals("the_stealth_warrior", converter.convertToSnakeCase("The_stealth_warrior"));
		assertEquals("a", converter.convertToSnakeCase("A"));
		assertEquals("", converter.convertToSnakeCase(""));
	}
	
	@Test
	public void testConvertToUpperCaseKebabString() {
		assertEquals("THE-STEALTH-WARRIOR", converter.convertToUpperCaseKebabCase("TheStealthWarrior"));
		assertEquals("THE-STEALTH-WARRIOR", converter.convertToUpperCaseKebabCase("theStealthWarrior"));
		assertEquals("THE-STEALTH-WARRIOR", converter.convertToUpperCaseKebabCase("The-stealth-warrior"));
		assertEquals("A", converter.convertToUpperCaseKebabCase("a"));
		assertEquals("", converter.convertToUpperCaseKebabCase(""));
	}
	
	@Test
	public void testConvertToUpperCaseSnakeString() {
		assertEquals("THE_STEALTH_WARRIOR", converter.convertToUpperCaseSnakeCase("TheStealthWarrior"));
		assertEquals("THE_STEALTH_WARRIOR", converter.convertToUpperCaseSnakeCase("theStealthWarrior"));
		assertEquals("THE_STEALTH_WARRIOR", converter.convertToUpperCaseSnakeCase("The_stealth_warrior"));
		assertEquals("A", converter.convertToUpperCaseSnakeCase("a"));
		assertEquals("", converter.convertToUpperCaseSnakeCase(""));
	}
	
	@Test
	public void testConversionOfNullInputs() {
		try {
			assertEquals("the_stealth_warrior", converter.convertToCamelCase(null));
			fail(MSG_EXCEPTION_EXPECTED);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		}
		
		try {
			assertEquals("the_stealth_warrior", converter.convertToPascalCase(null));
			fail(MSG_EXCEPTION_EXPECTED);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		}
		
		try {
			assertEquals("the_stealth_warrior", converter.convertToKebabCase(null));
			fail(MSG_EXCEPTION_EXPECTED);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		}
		
		try {
			assertEquals("the_stealth_warrior", converter.convertToSnakeCase(null));
			fail(MSG_EXCEPTION_EXPECTED);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
}
