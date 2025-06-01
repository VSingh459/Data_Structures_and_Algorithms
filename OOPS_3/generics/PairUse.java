package generics;
import java.util.Scanner;

public class PairUse {

	public static void main(String[] args) {
		
		double x = 1.1;
		
		
		
		Three_Variable<Integer,Integer,Integer> TH = new Three_Variable<>(1,2,3);
		
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		PairMixed<Integer, Integer> PInt = new PairMixed<>(a,b);
		
		PairMixed<PairMixed<Integer, Integer>, Integer>  P8 = new PairMixed<>(PInt,c);
		
		System.out.println(P8.getSecond());
		System.out.println(P8.getFirst().getSecond());
		System.out.println(P8.getFirst().getFirst());
		

	}

}
