package com.training;

public class TicTacToeGame {
	char[] board;
	public TicTacToeGame() {
		board=new char[10];
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		TicTacToeGame tttg=new TicTacToeGame();
	}
}
