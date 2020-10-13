package com.training.tictactoe;

import java.util.*;

public class TicTacToeGame {
	char[] board;
	char playerLetter;
	char computerLetter;
	boolean[] isFree;
	boolean isPlayerTurn;

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
			isPlayerTurn = true;
		} else {
			System.out.println("Computer Goes First !");
			computerLetter = 'X';
			playerLetter = 'O';
			isPlayerTurn = false;
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
			System.out.println("Player Move : ");
			printBoard(board);
			isPlayerTurn = false;
		} else {
			System.out.println("The position is occupied :");
			makePlayerMove(sc);
		}

	}

	// computerMove
	private boolean isWinningMove(int position, char pos) {
		if (position < 0 || position > 9) {
			System.out.println("Enter a valid position :");
			return false;
		} else if (isFree[position]) {
			char c = board[position];
			board[position] = pos;
			boolean b = isWin(pos);
			board[position] = c;
			return b;
		} else {
			return false;
		}

	}

	// Blocking Player By computer
	private void makeSmartComputerMove() {
		boolean b;
		int winningPos = 0;
		for (int i = 1; i < board.length; i++) {
			b = isWinningMove(i, computerLetter);
			if (b) {
				winningPos = i;
				break;
			}
		}
		if (winningPos == 0) {
			for (int i = 1; i < board.length; i++) {
				b = isWinningMove(i, playerLetter);
				if (b) {
					winningPos = i;
					break;
				}
			}
		}
		if (winningPos == 0) {
			winningPos = getPosForWin();
			if (winningPos == 0)
				winningPos = (int) (Math.floor(Math.random() * 100) % 9 + 1);
		}
		if (winningPos < 0 || winningPos > 9) {
			System.out.println("Enter a valid position :");
			makeSmartComputerMove();
		} else if (isFree[winningPos]) {
			board[winningPos] = computerLetter;
			isFree[winningPos] = false;
			System.out.println("Computer Move :");
			printBoard(board);
			isPlayerTurn = true;
		} else {
			makeSmartComputerMove();
		}

	}

	private int getPosForWin() {
		int[] a = { 1, 3, 7, 9 };
		int[] b = { 2, 4, 6, 8 };
		for (int i : a) {
			if (isFree[i])
				return i;
		}
		if (isFree[5]) {
			return 5;
		} else {
			for (int i : b) {
				if (isFree[i])
					return i;
			}
		}
		return 0;
	}

	// Winning Condition
	private boolean isWin(char ch) {
		if (board[1] == board[2] && board[2] == board[3] && board[1] == ch)
			return true;
		if (board[4] == board[5] && board[5] == board[6] && board[4] == ch)
			return true;
		if (board[7] == board[8] && board[8] == board[9] && board[7] == ch)
			return true;
		if (board[1] == board[4] && board[4] == board[7] && board[1] == ch)
			return true;
		if (board[2] == board[5] && board[5] == board[8] && board[2] == ch)
			return true;
		if (board[3] == board[6] && board[6] == board[9] && board[3] == ch)
			return true;
		if (board[1] == board[5] && board[5] == board[9] && board[1] == ch)
			return true;
		if (board[3] == board[5] && board[5] == board[7] && board[3] == ch)
			return true;
		return false;
	}

	// main
	public static void main(String[] args) {
		while (true) {
			System.out.println("Welcome to Tic Tac Toe Game :");
			Scanner sc = new Scanner(System.in);
			TicTacToeGame TTTG = new TicTacToeGame();
			TTTG.fillBoard();
			TTTG.firstTurn(sc);
			while (true) {
				if (TTTG.isPlayerTurn) {
					TTTG.makePlayerMove(sc);
					if (TTTG.isWin(TTTG.playerLetter)) {
						System.out.println("Player Wins !");
						break;
					}
				} else {
					TTTG.makeSmartComputerMove();
					;
					if (TTTG.isWin(TTTG.computerLetter)) {
						System.out.println("Computer Wins !");
						break;
					}
				}
				int count = 0;
				for (int i = 1; i < 10; i++) {
					if (TTTG.isFree[i] == false)
						count++;
				}
				if (count == 9) {
					System.out.println("Draw");
					break;
				}
			}
			boolean b = playAnotherGame(sc);
			if (!b) {
				sc.close();
				System.out.println("Game Ends !");
				break;
			}
		}
	}

	private static boolean playAnotherGame(Scanner sc) {
		System.out.println("Enter Yes To Play Anothe game : Enter Anything Other Than Yes to Exit : ");
		String str = sc.next();
		if (str.equalsIgnoreCase("YES"))
			return true;
		return false;
	}
}
