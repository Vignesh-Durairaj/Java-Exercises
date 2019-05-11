package com.vikhi.exercise;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class PalindromeTest {

	@RunWith(Parameterized.class)
	public static class GroupedPalindromeTest {
		
		private String str;
		private boolean isPalindrome;
		private int shortageChars;
		private int insertableChars;
		
		private Palindrome palindrome = new Palindrome();
		
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
				{"acidedc", false, 6, 2}
			});
		}
		
		@Test
		public void testIsPalindrome() {
			boolean isPalindrome = palindrome.isPalindrome(str);
			Assert.assertEquals(this.isPalindrome, isPalindrome);
		}
		
		@Test
		public void testCharsShortForPalindrome() {
			int shortageChars = palindrome.getCharsForPalindrome(str);
			Assert.assertEquals(this.shortageChars, shortageChars);
		}
		
		@Test
		public void testInsertableCharacters() {
			int shortageChars = palindrome.getCharsForInsert(str);
			Assert.assertEquals(0, shortageChars);
			Assert.assertNotNull(Integer.valueOf(insertableChars));
		}
		
		@Test
		public void testPalindromicSubString() {
			Assert.assertNull(palindrome.getPalindromicSubStrings(5, "Malayalam"));
		}
	}
}
