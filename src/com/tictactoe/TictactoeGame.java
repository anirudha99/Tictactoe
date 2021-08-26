package com.tictactoe;

public class TictactoeGame {
	
	char[] board = new char[10];

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe game");
		TictactoeGame tictactoe = new TictactoeGame();
		tictactoe.createBoard();
	}
	
	public void createBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

}
