package lectures;

public class This_Keyword_123 {
	
	int age;
	String name;
	
	public This_Keyword_123(int age,String n)
	{
		this.age = age;	
		name = n;
		System.out.println(this);
	}

	public static void main(String[] args) {
		
		This_Keyword_123 s1 = new This_Keyword_123(28,"Jay");
		
		System.out.println(s1);
		

	}

}
