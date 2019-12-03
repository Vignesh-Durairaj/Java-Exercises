package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vikhi.exercise.interfaces.LanguageTranslator;

@RunWith(Enclosed.class)
public class AlienLanguageTranslatorTest {
	
	@RunWith(Parameterized.class)
	public static class AlienLanguageTranslatorParameterizedTest {

		private LanguageTranslator alt = new AlienLanguageTranslator();
		private String inputStr;
		
		public AlienLanguageTranslatorParameterizedTest(String inputStr) {
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
	
	public static class AlienLanguageTranslatorComponentLevelTest {
		private AlienLanguageTranslator alt = new AlienLanguageTranslator();
		
		@Test
		public void testTranslatedFromDefaultLanguage() {
			assertTrue('D' == alt.getTransformedCharacter('A', true));
			assertTrue('E' == alt.getTransformedCharacter('B', true));
			assertTrue('B' == alt.getTransformedCharacter('Y', true));
			assertTrue('C' == alt.getTransformedCharacter('Z', true));
			
			assertTrue('d' == alt.getTransformedCharacter('a', true));
			assertTrue('e' == alt.getTransformedCharacter('b', true));
			assertTrue('b' == alt.getTransformedCharacter('y', true));
			assertTrue('c' == alt.getTransformedCharacter('z', true));
			
			assertTrue(' ' == alt.getTransformedCharacter(' ', true));
			assertTrue('!' == alt.getTransformedCharacter('!', true));
			assertTrue('[' == alt.getTransformedCharacter('[', true));
		}
		
		@Test
		public void testTranslatedToDefaultLanguage() {
			assertTrue('x' == alt.getTransformedCharacter('a', false));
			assertTrue('y' == alt.getTransformedCharacter('b', false));
			assertTrue('v' == alt.getTransformedCharacter('y', false));
			assertTrue('w' == alt.getTransformedCharacter('z', false));
			
			assertTrue(' ' == alt.getTransformedCharacter(' ', false));
			assertTrue('!' == alt.getTransformedCharacter('!', false));
			assertTrue('[' == alt.getTransformedCharacter('[', false));
			
			assertTrue('X' == alt.getTransformedCharacter('A', false));
			assertTrue('Y' == alt.getTransformedCharacter('B', false));
			assertTrue('V' == alt.getTransformedCharacter('Y', false));
			assertTrue('W' == alt.getTransformedCharacter('Z', false));
			
			
		}
	}
}


