package hashmaps;
import java.util.*;

public class Inter {
	
	public static void printInter(int[] arr1,int[] arr2)
	{
		if(arr1.length==0 || arr2.length==0)
            return ;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<arr1.length;i++)
            {  
            	if(map.containsKey(arr1[i]))
                map.put(arr1[i],map.get(arr1[i])+1);
             else
                 map.put(arr1[i],1);
            }
            
            for(int i=0;i<arr2.length;i++)
            {
                if(map.containsKey(arr2[i])){
                    if(map.get(arr2[i])!=0){
                
                    System.out.println(arr2[i]);
                    map.put(arr2[i],map.get(arr2[i])-1);
                    }
                }
                else
                    continue;


            }



        }
		
	

	public static void main(String[] args) {
		
		int[] a = {2,6,8,5,4,3};
		int[] b = {2,3,4,7};
		
		printInter(a,b);

	}

}
