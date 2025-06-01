package Tasks;
import java.util.LinkedList;
import java.util.Queue;

public class Use_Stack2Q {

	public static void main(String[] args) {
		
		StackUsing2Q s =  new StackUsing2Q();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
 
        System.out.println("current size: " + s.size());

	}

}
