package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class AnagramTest {
	
	@RunWith(Parameterized.class)
	public static class AnagramUtilsTest {

		private String strOne;
		private String strTwo;
		private boolean isAnagram;
		
		public AnagramUtilsTest(String strOne, String strTwo, boolean isAnagram) {
			super();
			this.strOne = strOne;
			this.strTwo = strTwo;
			this.isAnagram = isAnagram;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{"Vignesh", "Vignesh", true}, 
				{"", "", true}, 
				{"Test", "test", true}, 
				{"brine", "Eribn", true}, 
				{"Vignesh", "vignash", false}, 
				{"test", "Tesst", false}, 
				{"New", "wen", true}
			});
		}
		
		@Test
		public void testClassicAnagram() {
			assertEquals(isAnagram, AnagramUtils.isAnagram(strOne, strTwo));
		}
		
		@Test
		public void testAnagramUsingArrays() {
			assertEquals(isAnagram, AnagramUtils.isAnagramUsingArrays(strOne, strTwo));
		}
	}

	public static class RandomTestCases {
		
		@Test
		public void testInvalidInputs() {
			assertFalse(AnagramUtils.isAnagramUsingArrays(null, "Test"));
			assertFalse(AnagramUtils.isAnagramUsingArrays("Test", null));
			
		}
		
		@Test
		public void testAnagramGenerator() {
			WordAnagram anagram = new WordAnagram();
			String str = "AABCY";
			
			assertNotNull(anagram.getFilteredCombinations(str));
		}
		
	}
}

