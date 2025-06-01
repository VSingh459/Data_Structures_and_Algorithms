package tries_HuffmanCoding;
import java.util.ArrayList;

public class TrieUse {

	public static void main(String[] args) {
		
		Trie obj = new Trie();
		
		
		ArrayList<String> v = new ArrayList<String>();
		v.add("DO");
		v.add("DONT");
		v.add("NO");
		v.add("NOT");
		v.add("NOTE");
		v.add("NOTES");
		v.add("DEN");
		
		
		//boolean ans = obj.patternMatch(v, s);
		//boolean ans = obj.isPalindromePair(v);
		//System.out.println(ans);
		
		obj.autoComplete(v,"NO");
		
		
		

	}

}
