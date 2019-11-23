package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.exercise.scenario.ChessPawnRice;

public class ChessPawnRiceTest {

	private ChessPawnRice cpr;
	
	@Before
	public void init() {
		cpr = new ChessPawnRice();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForNullInput() {
		cpr.getGrainsCollected(null);
		fail("Exception should be thrown for NULL inut !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVaryingWidthBoard() {
		int[][] chessBoard = {{1}, {2}, {3, 4}, {}};
		cpr.getGrainsCollected(chessBoard);
		fail("Exception should be thrown for varying width input array !");
	}
	
	@Test
	public void testEmptyArrayInput() {
		int grainsCollected = cpr.getGrainsCollected(new int[][]{{}});
		assertEquals(0, grainsCollected);
	}
	
	@Test
	public void testSingleRowBoard() {
		int[][] chessBoard = {
				{1, 2, 3, 4, 1}
		};
		
		int grainsCollected = cpr.getGrainsCollected(chessBoard);
		assertEquals(11, grainsCollected);
	}
	
	@Test
	public void testSingleColumnBoard() {
		int[][] chessBoard = {
				{1}, 
				{2}, 
				{3},
				{1}
		};
		
		int grainsCollected = cpr.getGrainsCollected(chessBoard);
		assertEquals(7, grainsCollected);
	}
	
	@Test
	public void testNormalChessBoard() {
		int[][] chessBoard = {
				{1, 3, 7, 9, 3}, 
				{2, 9, 3, 9, 1}, 
				{3, 0, 1, 3, 5},
				{1, 9, 1, 4, 1}
		};
		
		int grainsCollected = cpr.getGrainsCollected(chessBoard);
		assertEquals(38, grainsCollected);
	}
}
