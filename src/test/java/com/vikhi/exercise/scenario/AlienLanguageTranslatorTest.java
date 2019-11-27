package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vikhi.exercise.interfaces.LanguageTranslator;
import com.vikhi.exercise.scenario.AlienLanguageTranslator;


@RunWith(Parameterized.class)
public class AlienLanguageTranslatorTest {

	private LanguageTranslator alt = new AlienLanguageTranslator();
	private String inputStr;
	
	public AlienLanguageTranslatorTest(String inputStr) {
		super();
		this.inputStr = inputStr;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] {
			{"1234567"}, 
			{"Vignesh"}, 
			{"Durairaj"},
			{"Software Engineering"}, 
			{""}, 
			{" "}, 
			{"!@#$%^(*&^12325abcdxyzABCDXYZ"},
			{"abcdefghijklmnopqrstuvwxyz"}, 
			{"ABCDEFGHTIJKLMNOPQRSTUVWXYZ"}
		});
	}
	
	@Test
	public void testAlienTranslation() {
		String translatedText = alt.fromDefaultLanguage(inputStr);
		String decodedText = alt.toDefaultLanguage(translatedText);
		assertEquals(inputStr, decodedText);
	}
	
}