package tasks;
import java.util.Scanner;
import java.util.Stack;


public class Balanced_Parentheses {
	
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
	
	public static boolean isMatching(char a,char b)
	{
		if (a=='(' && b==')')
		{
			return true;
		}
		else if (a=='{' && b=='}')
		{
			return true;
		}
		else if (a=='[' && b== ']')
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public static boolean isBalanced(String expression)
	{
		Stack<Character> s = new Stack<>();
		
		for (int i=0;i<expression.length();i++)
		{
			char curr = expression.charAt(i);
			if (isOpening(curr))
			{
				s.push(curr);
			}
			else
			{
				if (s.isEmpty())
				{
					return false;
				}
				else if (!isMatching(s.peek(),curr))
				{
					return false;
				}
				else
				{
					s.pop();
				}
			}	
		}
		
		return s.isEmpty();
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Character> stack = new Stack<>();
		
		String s= "(()))";
		
		boolean ans = isBalanced(s);
		System.out.println();
		System.out.println(ans);

	}

}
