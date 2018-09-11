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
		
		private Palindrome palindrome = new Palindrome();
		
		public GroupedPalindromeTest(String str, boolean isPalindrome, int shortageChars) {
			this.str = str;
			this.isPalindrome = isPalindrome;
			this.shortageChars = shortageChars;
		}

		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][]{
				{"Madam", true, 0}, 
				{"Malayalam", true, 0},
				{"Mala", false, 1}, 
				{"Malay", false, 4}, 
				{"Arabar", false, 1},
				{"Medleidem", false, 8}
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
			System.out.println("For : " + str + ", shortage CHar : " + shortageChars);
			Assert.assertEquals(this.shortageChars, shortageChars);
		}
	}
}
