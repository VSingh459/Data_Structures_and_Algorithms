package othello;

public class Board {
	
	private char board[][];
	private int boardSize = 8;
	private char p1Symbol, p2Symbol;
	private int count;
	private static final char EMPTY = ' ';
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALIDMOVE = 5;
	
	public Board(char p1Symbol, char p2Symbol)
	{
		board = new char[boardSize][boardSize];
		for (int i=0;i<boardSize;i++)
		{
			for (int j=0;j<boardSize;j++)
			{
				board[i][j] = EMPTY;
			}
		}
		
		board[3][3] = 'W';
		board[3][4] = 'B';
		board[4][3] = 'B';
		board[4][4] = 'W';
		
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
	
	public void print()
	{
		System.out.println("-----------------");
		for (int i=0;i<boardSize;i++)
		{
			for (int j=0;j<boardSize;j++)
			{
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("------------------");
	}
	
	public boolean move(char symbol,int x,int y)
	{
		  int[] xDir={-1,-1,0,1,1,1,0,-1};
	        int[] yDir={0,1,1,1,0,-1,-1,-1};

			  if(x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] != 0){
	        return false;
	        }
	        boolean movePossible = false;
	        for(int i = 0; i < xDir.length; i++){
	    int xStep = xDir[i];
	    int yStep = yDir[i];
	int currentX = x + xStep;
	int currentY = y + yStep;
	int count = 0; // count of opponent's pieces encountered
	while(currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8){
	// Empty cell
	if(board[currentX][currentY] == 0){
	break;
	}else if(board[currentX][currentY] != symbol){
	currentX += xStep;
	currentY += yStep;
	count++;
	}else{
	// conversion is possible
	if(count > 0){
	movePossible = true;
	int convertX = currentX - xStep;
	int convertY = currentY - yStep;
	while(convertX != x || convertY != y){
	board[convertX][convertY] = symbol;
	convertX = convertX - xStep;
	convertY = convertY - yStep;
	}
	}
	break;
	}
	}
	}
	if(movePossible){
	board[x][y] =symbol;
	}
	return movePossible;
		
	}

}
