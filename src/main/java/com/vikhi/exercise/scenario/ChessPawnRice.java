package com.vikhi.exercise.scenario;

public class ChessPawnRice {

	public int getGrainsCollected(int[][] chessBoard) {
		
		if (chessBoard == null) {
			throw new IllegalArgumentException("Chess board should be a valid 2D array");
		}
		
		int boardWidth = chessBoard[0].length; 
		int boardHeight = chessBoard.length;
		for (int i = 1; i < chessBoard.length; i ++) {
			if (chessBoard[i].length != boardWidth) {
				throw new IllegalArgumentException("The board is of varying width");
			}
		}
		
		int[] pawnLocation = {0,0};
		int grainsCollected = 0;
		
		while (pawnLocation[0] < boardHeight && pawnLocation[1] < boardWidth) {
			int rowAggregate = 0; 
			int colAggregate = 0;
			grainsCollected += chessBoard[pawnLocation[0]][pawnLocation[1]];
			
			for (int width = pawnLocation[1]; width < boardWidth; width ++) {
				rowAggregate += chessBoard[pawnLocation[0]][width];
			}
			
			for (int row = pawnLocation[0]; row < boardHeight; row ++) {
				colAggregate += chessBoard[row][pawnLocation[1]];
			}
			
			if (rowAggregate <= colAggregate) {
				pawnLocation[0] = pawnLocation[0] + 1;
			} else {
				pawnLocation[1] = pawnLocation[1] + 1;
			}
		}
				
		return grainsCollected;
	}
}
