package com.training.tictactoe;

import java.util.*;

public class TicTacToeGame {
	char[] board;
	char playerLetter;
	char computerLetter;
	boolean[] isFree;

	// constructor
	public TicTacToeGame() {
		board = new char[10];
		isFree = new boolean[10];
	}

	// fill the board with empty space
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		for (int i = 0; i < isFree.length; i++) {
			isFree[i] = true;
		}
	}

	// Heads or Tails
	public void firstTurn(Scanner sc) {
		System.out.println("Enter Head or Tail :");
		String str = sc.next();
		String toss = Math.random() < 0.5 ? "Head" : "Tail";
		if (str.equalsIgnoreCase(toss)) {
			System.out.println("User Goes First !");
			allowPlayer(sc);
		} else {
			System.out.println("Computer Goes First !");
			computerLetter = 'X';
			playerLetter = 'O';
		}
	}

	// player choice input
	private void allowPlayer(Scanner sc) {
		System.out.println("Input Your Choice X or O");
		char c = sc.next().toUpperCase().charAt(0);
		if (c != 'O' && c != 'X')
			allowPlayer(sc);
		playerLetter = c;
		computerLetter = playerLetter == 'X' ? 'O' : 'X';
	}

	// Print Board
	private void printBoard() {
		for (int i = 1; i < board.length; i++) {
			if (i % 3 == 1 || i % 3 == 2)
				System.out.print(board[i] + "  | ");
			if (i % 3 == 0) {
				System.out.println(board[i]);
				if (i != board.length - 1)
					System.out.println("-------------");
			}
		}
	}

	// Overload printBoard
	private void printBoard(char[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (i % 3 == 1 || i % 3 == 2)
				System.out.print(arr[i] + "  | ");
			if (i % 3 == 0) {
				System.out.println(arr[i]);
				if (i != arr.length - 1)
					System.out.println("-------------");
			}
		}
	}

	// playerMove
	private void makePlayerMove(Scanner sc) {
		System.out.println("Enter a Position player want to move(1 to 9) : ");
		int position = sc.nextInt();
		if (position < 0 || position > 9) {
			System.out.println("Enter a valid position :");
			makePlayerMove(sc);
		} else if (isFree[position]) {
			System.out.println("The position is free to move :");
			board[position] = playerLetter;
			isFree[position] = false;
			printBoard(board);
		} else {
			System.out.println("The position is occupied :");
			makePlayerMove(sc);
		}

	}
	// computerMove
	private void makeComputerMove(Scanner sc) {
		int position = (int)Math.floor(Math.random()*100)%9+1;
		if (position < 0 || position > 9) {
			System.out.println("Enter a valid position :");
			makeComputerMove(sc);
		} else if (isFree[position]) {
			System.out.println("The position is free to move :");
			board[position] = computerLetter;
			isFree[position] = false;
			printBoard(board);
		} else {
			System.out.println("The position is occupied :");
			makeComputerMove(sc);
		}

	}
	//Winning Condition
	private boolean isWin(char ch) {
		boolean b=false;
	if(board[1]==board[2] &&board[2]==board[3]&&board[1]==ch)
		return true;
	if(board[4]==board[5] &&board[5]==board[6]&&board[4]==ch)
		return true;
	if(board[7]==board[8] &&board[8]==board[9]&&board[7]==ch)
		return true;
	if(board[1]==board[4] &&board[4]==board[7]&&board[1]==ch)
		return true;
	if(board[2]==board[5] &&board[5]==board[8]&&board[2]==ch)
		return true;
	if(board[3]==board[6] &&board[6]==board[9]&&board[3]==ch)
		return true;
	if(board[1]==board[5] &&board[5]==board[9]&&board[1]==ch)
		return true;
	if(board[3]==board[5] &&board[5]==board[7]&&board[3]==ch)
		return true;
	return false;
	}

	// main
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game :");
		Scanner sc = new Scanner(System.in);
		TicTacToeGame TTTG = new TicTacToeGame();
		TTTG.fillBoard();
		TTTG.firstTurn(sc);
		TTTG.makePlayerMove(sc);
		TTTG.makeComputerMove(sc);
		TTTG.makePlayerMove(sc);
		TTTG.makeComputerMove(sc);
		TTTG.makePlayerMove(sc);
		TTTG.makeComputerMove(sc);
		System.out.println(TTTG.isWin(TTTG.playerLetter));
		sc.close();
	}
}
