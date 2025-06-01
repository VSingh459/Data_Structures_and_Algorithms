package Priority_Queue;
import java.util.ArrayList;

public class MaxPQ_Use {

	public static void main(String[] args) throws PQException {
		
		Max_PQ pq = new Max_PQ();
		
		pq.insert(100);
		pq.insert(90);
		pq.insert(80);
		pq.insert(70);
		pq.insert(60);
		pq.insert(50);
		pq.insert(40);
		
		pq.print();
		
		int r = pq.removeMax();
		
		pq.print();
		

	}

}
