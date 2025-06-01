package tasks;
import java.util.Scanner;
import java.util.Stack;

public class Redundant_Brackets {
	
	
	
	public static boolean isOpening(char c)
	{
		if (c=='(')
			return true;
		else if (c=='[')
			return true;
		else if (c=='{')
			return true;
		else
		{
			return false;
		}
	}
	
	public static boolean isClosing(char c)
	{
		if (c==')')
			return true;
		else if (c=='}')
			return true;
		else if (c==']')
			return true;
		else
			return false;
	}
	
	public static boolean isOperator(char c)
	{
		if (c=='+')
			return true;
		else if (c=='-')
			return true;
		else if (c=='*')
			return true;
		else if (c=='/')
			return true;
		else if (c=='%')
			return true;
		else
			return false;
	}
	
	
	public static boolean isRedundant(String expression)
	{
		boolean ans=false;
		Stack<Character> s = new Stack<>();
		
		for (int i=0;i<expression.length();i++)
		{
			char curr = expression.charAt(i);
			if (isOpening(curr) || isOperator(curr))
			{
				s.push(curr);
			}
			else if (isClosing(curr))
			{
				if (isOpening(s.peek()))
				{
					ans = true;
				}
				while (isOperator(s.peek()))
				{
					s.pop();
				}
				
				s.pop();
			}	
		}
		
		return ans;
		
	}
	
	
	

	public static void main(String[] args) {
		
Stack<Character> stack = new Stack<>();
		
		String s= "((a+b))";
		
		boolean ans = isRedundant(s);
		System.out.println();
		System.out.println(ans);

	}

}
