package othello;

public class Player {
	
	private String name;
	private char symbol;
	
	public Player(String name,char symb)
	{
		setName(name);
		setSymbol(symb);
	}
	
	public void setName(String name)
	{
		if (!name.isEmpty())
		{
			this.name = name;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setSymbol(char symb)
	{
		if (symb != '\0')
		{
			this.symbol = symb;
		}
	}
	
	public char getSymbol() {
		return this.symbol;
	}

}
