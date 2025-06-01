package hashmaps;
import java.util.ArrayList;

public class MapUse {
	
	

	public static void main(String[] args) {
		
		HMap<String,Integer> m = new HMap<>();
		for (int i=0;i<20;i++)
		{
			m.insert("abc"+i,i+1);
			System.out.println(m.loadFactor());
			
		}
		
		m.removeKey("abc3");
		m.removeKey("abc7");
		for (int i=0;i<20;i++)
		{
			System.out.println("abc"+i+":"+m.getValue("abc"+i));
		}

	}

}
