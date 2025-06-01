package Priority_Queue;
import java.util.ArrayList;

public class Max_PQ {
	
private ArrayList<Integer> heap;
	
	public Max_PQ()
	{
		heap = new ArrayList<>();
	}
	
	public boolean isEmpty()
	{
		if (heap.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getMax() throws PQException
	{
		if (isEmpty())
		{
			throw new PQException();
		}
		return heap.get(0);
	}
	
	public int getSize()
	{
		return heap.size();
	}
	
	public void insert(int elem)
	{
		heap.add(elem);
		int cIndex = heap.size()-1;
		int pIndex = (cIndex-1)/2;
		
		while (cIndex > 0)
		{
			if (heap.get(cIndex) > heap.get(pIndex))
			{
				int temp = heap.get(cIndex);
				heap.set(cIndex, heap.get(pIndex));
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
	
	public int removeMax() throws PQException
	{
		if (isEmpty())
		{
			throw new PQException();
		}
		
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int pIndex = 0;
		int minIndex = 0;
		int left = 1;
		int right = 2;
		
		while (left < heap.size())
		{
			if (heap.get(left) > heap.get(minIndex))
			{
				minIndex = left;
			}
			if (right < heap.size() && heap.get(right) > heap.get(minIndex))
			{
				minIndex = right;
			}
			
			if (minIndex == pIndex)
			{
				break;
			}
			else
			{
				int temp1 = heap.get(pIndex);
				heap.set(pIndex, heap.get(minIndex));
				heap.set(minIndex, temp1);
				pIndex = minIndex;
				left = pIndex*2+1;
				right = pIndex*2+2;
			}
		}
		
		return temp;
		
	}
	
	public void print()
	{
		for (int i=0;i<heap.size();i++)
		{
			System.out.print(heap.get(i)+" ");
		}
		System.out.println();
	}
	
	

}
