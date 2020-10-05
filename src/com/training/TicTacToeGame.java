package com.training;

public class TicTacToeGame {
	char[] board;
	public TicTacToeGame() {
		board=new char[10];
	}
	public void fillBoard() {
		for(int i=0;i<board.length;i++)
		{
			board[i]=' ';
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		TicTacToeGame tttg=new TicTacToeGame();
		tttg.fillBoard();
	}
}
