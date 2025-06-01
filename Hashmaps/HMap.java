package hashmaps;
import java.util.ArrayList;

public class HMap<K,V> {
	
	ArrayList<MapNode<K,V>> bucket;
	int count;
	int numBucket;
	
	public HMap()
	{
		bucket = new ArrayList<>();
		numBucket = 20;
		for (int i=0;i<numBucket;i++)
		{
			bucket.add(null);
		}
		
	}
	
	private int getBucketIndex(K key)
	{
		int hc = key.hashCode();
		int index = hc % numBucket;
		return index;
	}
	
	private void reHash()
	{
		ArrayList<MapNode<K,V>> temp = bucket;
		bucket = new ArrayList<>();
		for (int i=0;i<2*numBucket;i++)
		{
			bucket.add(null);
		}
		count = 0;
		numBucket = 2*numBucket;
		for (int i=0;i<temp.size();i++)
		{
			MapNode<K,V> head = temp.get(i);
			while (head != null)
			{
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
		}
		
	}
	
	public double loadFactor()
	{
		return (1.0*count)/numBucket;
		
	}
	
	public void insert(K key, V value)
	{
		int buckIndex = getBucketIndex(key);
		MapNode<K,V> head = bucket.get(buckIndex);
		while (head != null)
		{
			if (head.key.equals(key))
			{
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		head = bucket.get(buckIndex);
		MapNode<K,V> newNode = new MapNode<>(key,value);
		newNode.next = head;
		bucket.set(buckIndex, newNode);
		count++;
		double loadFactor = (1.0*count)/numBucket;
		if (loadFactor > 0.7)
		{
			reHash();
		}
	}
	
	public int size()
	{
		return count;
	}
	
	public V getValue(K key)
	{
		int buckIndex = getBucketIndex(key);
		MapNode<K,V> head = bucket.get(buckIndex);
		while (head != null)
		{
			if (head.key.equals(key))
			{
				return head.value;
			}
			head = head.next;
		}
		
		return null;
	}
	
	
	public V removeKey(K key)
	{
		int buckIndex = getBucketIndex(key);
		MapNode<K,V> head = bucket.get(buckIndex);
		MapNode<K,V> prev = null;
		while (head != null)
		{
			if (head.key.equals(key))
			{
				if (prev != null)
				{
					prev.next = head.next;
				}
				else
				{
					bucket.set(buckIndex, head.next);
				}
				count--;
				return head.value;
				
			}
			
			prev = head;
			head = head.next;
		}
		
		return null;
		
	}
	
	

	

}
