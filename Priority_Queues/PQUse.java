package Priority_Queue;
import java.util.ArrayList;

public class PQUse {

	public static void main(String[] args) throws PQException {
		
		PriQueue<String> pq = new PriQueue<>();
		
		pq.insert("A", 1);
		pq.insert("B", 2);
		pq.insert("C", 3);
		pq.insert("D", 4);
		pq.insert("E", 5);
		pq.insert("F", 6);
		pq.insert("G", 7);
		
		pq.print();
		
		String s = pq.removeMin();
		String ss = pq.removeMin();
		
		pq.print();
		
		
		
		
		

	}

}
