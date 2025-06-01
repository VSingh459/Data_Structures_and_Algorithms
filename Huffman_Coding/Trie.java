package tries_HuffmanCoding;
import java.util.ArrayList;

public class Trie {
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode('\0');
	}
	
	private void addHelper(TrieNode root,String word)
	{
		if (word.length() == 0)
		{
			root.isTerminal = true;
			return;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child == null)
		{
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++; // New
			
		}
		
		addHelper(child,word.substring(1));
		
	}
	
	public void add(String word)
	{
		addHelper(root,word);		
		
	}
	
	private boolean searchHelper(TrieNode root,String word)
	{
		if (word.length() == 0)
		{
			if (root.isTerminal == true)
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
		int c = word.charAt(0) - 'A';
		TrieNode child = root.children[c];
		if (child == null)
		{
			return false;
		}
		
	    boolean ans = searchHelper(child,word.substring(1));
		
		return ans;
		
	}
	
	public boolean search(String word)
	{
		return searchHelper(root,word);
	}
	
	private void removeHelper(TrieNode root,String word)
	{
		if (word.length() == 0)
		{
			root.isTerminal = false;
			return;
		}
		
		int childIndex = word.charAt(0) - 'A'; 
		TrieNode child = root.children[childIndex];
		if (child == null)
		{
			return;
		}
		
		removeHelper(child,word.substring(1));
		
		if (!child.isTerminal &&  child.childCount == 0)
		{
			root.children[childIndex] = null;
			root.childCount--;
		}
		
	}
	
	public void remove(String word)
	{
		removeHelper(root,word);
		
	}
	
	public boolean patternMatch(ArrayList<String> vect, String pattern)
	{
		for (int i = 0; i < vect.size(); i++) 
		{
	        String word = vect.get(i); 
	        for (int j = 0; j < word.length(); j++) 
	        {
	            add(word.substring(j));
	            }
	        }
		
		return rSearch(root,pattern);
		
	}
	
	private boolean rSearch(TrieNode root,String pattern){
        if(pattern.length()==0)
            return true;
        int childIndex=pattern.charAt(0)-'A';
        TrieNode child=root.children[childIndex];
        if(child==null)
            return false;
        return rSearch(child,pattern.substring(1));

    }
	
	// --------------  Palindrome Pair Problem --------------------------
	
	
	public boolean isPalindromePair(ArrayList<String> words)
	{
		for (String word: words)
		{
			this.add(reverseWord(word));
		}
		
		return isPalPair(this.root,words);
	}
	
	private static String reverseWord(String word)
	{
		String reverse = "";
		for (int i = word.length() -1;i>=0;i--)
		{
			reverse += word.charAt(i);
		}
		return reverse;
	}
	
	private boolean isPalPair(TrieNode root, ArrayList<String> words)
	{
		if (words == null || words.size() == 0)
		{
			return false;
		}
		
		for (String word: words)
		{
			if (doesPairExistFor(root,word,0))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean doesPairExistFor(TrieNode root, String word, int startIndex)
	{
		if (word == "")
		{
			return true;
		}
		
		if (startIndex == word.length())
		{
			if (root.isTerminal)
			{
				return true;
			}
			return checkRemBranchesInTrie(root,"");
		}
		
		int charIndex = word.charAt(startIndex) - 'A';
		TrieNode correspondingChild = root.children[charIndex];
		
		if (correspondingChild == null)
		{
			if (root.isTerminal)
			{
				return checkWordForPal(word.substring(startIndex));
			}
			return false;
		}
		
		return doesPairExistFor(correspondingChild,word, (startIndex+1));
		
		
	}
	
	private boolean checkRemBranchesInTrie(TrieNode root, String word)
	{
		if (root.isTerminal)
		{
			if (checkWordForPal(word))
			{
				return true;
			}
		}
		
		for (TrieNode childNode : root.children)
		{
			if (childNode == null)
			{
				continue;
			}
			
			String fwd = word + childNode.data;
			if (checkRemBranchesInTrie(childNode, fwd))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	private static boolean checkWordForPal(String word)
	{
		int startIndex = 0;
		int endIndex = word.length() - 1;
		
		while (startIndex < endIndex)
		{
			if (word.charAt(startIndex) != word.charAt(endIndex))
			{
				return false;
			}
			startIndex += 1;
			endIndex -= 1;
		}
		
		return true;
		
	}
	
	//------------------  Auto-Complete ----------------------
	
	public TrieNode findRoot(TrieNode root, String word)
	{
		if (word.length()==0)
		{
			return root;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child==null)
		{
			return null;
		}
		return findRoot(child, word.substring(1));
	}
	
	public  void autoComplete(ArrayList<String> input, String word)
	{
		for (String w: input)
		{
			add(w);
		}
		TrieNode node = findRoot(root,word);
		if (node == null || node.childCount == 0)
		{
			return;
		}
		
		String output = "";
		allRootToLeafPaths(node, output,word);
		
		
	}
	
	private void allRootToLeafPaths(TrieNode node,String output,String word)
	{
		if (node.childCount == 0)
		{
			if (output.length() >0)
			{
				System.out.println(word+output);
			}
			return;
		}
		if (node.isTerminal)
		{
			System.out.println(word+output);
		}
		
		for (int i=0;i<node.children.length;i++)
		{
			if (node.children[i] != null)
			{
				String ans = output+node.children[i].data;
				allRootToLeafPaths(node.children[i],ans,word);
				
			}
		}
	}
	

	
	
	
	

}
