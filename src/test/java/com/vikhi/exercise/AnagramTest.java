package com.vikhi.exercise;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vikhi.main.GeneralMain;

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
			Assert.assertEquals(isAnagram, AnagramUtils.isAnagram(strOne, strTwo));
		}
		
		@Test
		public void testAnagramUsingArrays() {
			Assert.assertEquals(isAnagram, AnagramUtils.isAnagramUsingArrays(strOne, strTwo));
		}
	}

	public static class RandomTestCases {
		
		@Test
		public void testInvalidInputs() {
			Assert.assertTrue(!AnagramUtils.isAnagramUsingArrays(null, "Test"));
			Assert.assertTrue(!AnagramUtils.isAnagramUsingArrays("Test", null));
			
		}
		
		@Test
		public void testAnagramGenerator() {
			WordAnagram anagram = new WordAnagram();
			String str = "AABCY";
			
			Assert.assertNotNull(anagram.getFilteredCombinations(str));
		}
		
		@Test
		public void testGenericMain() {
			GeneralMain.main(null);
		}
	}
}

