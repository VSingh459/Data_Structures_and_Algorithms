package othello;
import java.util.Scanner;

import oops_4.Board;
import oops_4.Player;

public class Othello_Umpire {
	
	private Player player1, player2;
	private Board board;
	private int numPlayers;
	
	
	public void startGame() {
		
		Scanner s = new Scanner(System.in);
		// Take Players Input
		numPlayers++;
		player1 = takePlayerInput(numPlayers);
		numPlayers++;
		player2 = takePlayerInput(numPlayers);
		while (player1.getSymbol() == player2.getSymbol())
		{
			System.out.println("Player 2 symbol already taken.Please enter another symbol");
			player2.setSymbol(s.next().charAt(0));
		}
		// Create the Board
		board = new Board(player1.getSymbol(),player2.getSymbol());
		// Play the Game
		boolean player1Turn = true;
		int status = board.INCOMPLETE;
		while(status == board.INCOMPLETE || status == board.INVALIDMOVE) {
			if (player1Turn)
			{
				System.out.println("Player-1 "+player1.getName()+"'s turn");
				System.out.println("Enter X Coordinate: ");
				int x = s.nextInt();
				System.out.println("Enter Y Coordinate: ");
				int y = s.nextInt();
				
				 status = board.move(player1.getSymbol(),x,y);
				if (status == Board.INVALIDMOVE)
				{
					System.out.println("Invalid Move !!! Please make a valid move ");
					continue;
				}
				
			}
			else
			{
				System.out.println("Player-2 "+player2.getName()+"'s turn");
				System.out.println("Enter X Coordinate: ");
				int x = s.nextInt();
				System.out.println("Enter Y Coordinate: ");
				int y = s.nextInt();
				
				 status = board.move(player2.getSymbol(),x,y);
				if (status == board.INVALIDMOVE)
				{
					System.out.println("Invalid Move !!! Please make a valid move ");
					continue;
				}
			}
			player1Turn = !player1Turn;
			board.print();
		}
		
		if (status == board.PLAYER1WINS)
		{
			System.out.println("Player 1 - "+player1.getName()+" wins!!!");
		}
		else if (status == board.PLAYER2WINS)
		{
			System.out.println("Player 2 - "+player2.getName()+" wins!!!");
		}
		else
		{
			System.out.println("Draw");
		}
	}
	
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player "+num+" name: ");
		String name = s.nextLine();
		//System.out.println("Enter Player "+num+"symbol: " );
		char symbol;
		if (num==1)
		{
		   symbol = 'B';
			
		}
		else
		{
			 symbol = 'W';
		}
		Player p = new Player(name,symbol);
		return p;
	}

	public static void main(String[] args) {
		
		Othello_Umpire  oT = new Othello_Umpire();
		oT.startGame();

	}

}
