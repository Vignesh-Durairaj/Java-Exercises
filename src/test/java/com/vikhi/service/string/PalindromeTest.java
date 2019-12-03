package com.vikhi.service.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vikhi.exercise.string.Palindrome;

@RunWith(Enclosed.class)
public class PalindromeTest {

	private static Palindrome palindrome = new Palindrome();
	
	@RunWith(Parameterized.class)
	public static class GroupedPalindromeTest {
		
		private String str;
		private boolean isPalindrome;
		private int shortageChars;
		private int insertableChars;
		
		public GroupedPalindromeTest(String str, boolean isPalindrome, int shortageChars, int insertableChars) {
			this.str = str;
			this.isPalindrome = isPalindrome;
			this.shortageChars = shortageChars;
			this.insertableChars = insertableChars;
		}

		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][]{
				{"Madam", true, 0, 0}, 
				{"Malayalam", true, 0, 0},
				{"Mala", false, 1, 1},
				{"alam", false, 3, 1}, 
				{"Malay", false, 4, 2}, 
				{"Arabar", false, 1, 1},
				{"Medleidem", false, 8, 2},
				{"abieba", false, 5, 1}, 
				{"acidedc", false, 6, 2}, 
				{"aci dedc", false, 7, 2},
				{"Vignesh", false, 6, 0}, 
			});
		}
		
		@Test
		public void testIsPalindrome() {
			boolean isPalindrome = palindrome.isPalindrome(str);
			assertEquals(this.isPalindrome, isPalindrome);
		}
		
		@Test
		public void testCharsShortForPalindrome() {
			int shortageChars = palindrome.getCharsForPalindrome(str);
			assertEquals(this.shortageChars, shortageChars);
		}
		
		@Test
		public void testInsertableCharacters() {
			int shortageChars = palindrome.getCharsForInsert(str);
			assertEquals(this.shortageChars, shortageChars);
			assertNotNull(Integer.valueOf(insertableChars));
		}
		
		@Test
		public void testPalindromicSubString() {
			assertEquals(1, palindrome.getPalindromicSubStrings(5, "Malayalam").size());
		}
	}
	
	public static class InvalidScenarios {
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForEmptyStringInput() {
			palindrome.isPalindrome("");
			fail("An exception has to be thrown, but wasn't");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForNullStringInput() {
			palindrome.isPalindrome(null);
			fail("An exception has to be thrown, but wasn't");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForEmptyStringInputWhileGettingChars() {
			palindrome.getCharsForPalindrome ("");
			fail("An exception has to be thrown, but wasn't");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForNullStringInputWhileGettingChars() {
			palindrome.getCharsForPalindrome (null);
			fail("An exception has to be thrown, but wasn't");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForEmptyStringInputWhileGettingCharsForInsert() {
			palindrome.getCharsForInsert ("");
			fail("An exception has to be thrown, but wasn't");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void expectExceptionForNullStringInputWhileGettingCharsForInsert() {
			palindrome.getCharsForInsert (null);
			fail("An exception has to be thrown, but wasn't");
		}
	}
}
