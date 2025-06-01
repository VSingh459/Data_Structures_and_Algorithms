package Priority_Queue;
import java.util.ArrayList;

public class PriQueue<T> {
	
	private ArrayList<Element<T>> heap;
	
	public PriQueue()
	{
		heap = new ArrayList<>();
	}
	
	public void insert(T value,int pri)
	{
		Element<T> e = new Element<>(value,pri);
		heap.add(e);
		
		int cIndex = heap.size()-1;
		int pIndex = (cIndex-1)/2;
		
		while (cIndex > 0)
		{
			if (heap.get(cIndex).priority < heap.get(pIndex).priority)
			{
				Element<T> temp = heap.get(cIndex);
				heap.set(cIndex,heap.get(pIndex));
				heap.set(pIndex, temp);
				cIndex = pIndex;
				pIndex = (cIndex-1)/2;
			}
			else
			{
				return;
			}
			
			
		}
		
		
	}
	
	public T removeMin() throws PQException
	{
		
		if(isEmpty()){
			throw new PQException();
		}
		
		int temp = heap.get(0).priority;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int pIndex = 0;
		int minIndex = 0;
		int left = 1;
		int right = 2;
		
		while (left < heap.size())
		{
			if (heap.get(left).priority < heap.get(minIndex).priority)
			{
				minIndex = left;
			}
			if (right < heap.size() && heap.get(right).priority < heap.get(minIndex).priority)
			{
				minIndex = right;
			}
			if (minIndex == pIndex)
			{
				break;
			}
			else
			{
				Element<T> temp1 = heap.get(pIndex);
				heap.set(pIndex, heap.get(minIndex));
				heap.set(minIndex, temp1);
				pIndex = minIndex;
				left = pIndex*2+1;
				right = pIndex*2+2;
				
			}
		}
		
		
		return heap.get(0).value;
		
	}
	
	public T getMin() throws PQException
	{
		if (isEmpty())
		{
			throw new PQException();
		}
		
		return heap.get(0).value;
	}
	
	public boolean isEmpty()
	{
		if (size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int size()
	{
		return heap.size();
	}
	
	public void print() throws PQException
	{
		if(isEmpty()){
			// Throw an exception
			throw new PQException();
		}
		for (int i=0;i<heap.size();i++)
		{
			System.out.print(heap.get(i).priority+" ");
		}
		System.out.println();
	}
	

}
