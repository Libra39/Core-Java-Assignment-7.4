/**
 * Write a program that finds all anagram sets from a list of words. 
 * Anagrams are those words in which there are same characters jumbled. For example -> GOD -DOG ARE ANAGRAMS. 
 * Both words have same characters but in jumbled order.
 * 
 * Input: listen, pot, part, opt, trap, silent, top, this, hello, hits, what, shit 
 * -------
 * Output: { listen,silent} { part, trap } { pot, opt, top }{ this, hits, shit }
 * 
 * All the comments in the program will be placed on the Right-Hand-Side.
 * @author Sahil Khurana <sahilkhurana369@gmail.com>
 */
package Assignment_7;
import java.util.*;
public class Anagrams {																				 // Anagrams class declared
	final static int ALPHABET_SIZE = 26;								                             // we are only dealing with keys with chars 'a' to 'z'
	    class TrieNode{																				 // TrieNode class declared
	        ArrayList<Integer> anagramIndices;														 // Array list initiated
	        TrieNode[] children;																	 // Array declared
	 TrieNode(){																					 // TrieNode() method created
	     children = new TrieNode[ALPHABET_SIZE];													 // new object created
	     this.anagramIndices = new ArrayList();  }													 // This keyword is used to distinguish between class variables and instance variables
	    }																							 // TrieNode class closed
	    TrieNode root;																				 // value declared
	    Anagrams(){																					 //  Anagrams() constructor created
	        this.root = new TrieNode();}															 // This keyword is used to distinguish between class variables and instance variables	
	    private int getIndex(char ch) {																 // private variable declared
	        return ch - 'a';}																		 // return value set
	    @SuppressWarnings("unchecked")
		public void insertIntoTrie(String key, int index, HashMap anagramNodes) {					 // parameterized method insertIntoTrie() declared 
	        if (key == null) return;																 // null keys are not allowed
	         key = key.toLowerCase(); 																 // converted to lower case	
	        TrieNode currentNode = this.root;														 // This keyword is used to distinguish between class variables and instance variables	
	        int charIndex = 0;																		 // integer charIndex declared and initiated with value 0 	
	        while (charIndex < key.length()){														 // while loop to length of the string
	            int childIndex = getIndex(key.charAt(charIndex));									 // convert integer to character
	            if (childIndex < 0 || childIndex >= ALPHABET_SIZE){									 // if loop to check ALPHABET_SIZE	
	                System.out.println("Invalid Key");												 // print statement	
	                return;}																		 // return value if condition is true	
	           if (currentNode.children[childIndex] == null){										 // if loop to check currentNode
	                currentNode.children[childIndex] = new TrieNode();}								 // new object created	
	            currentNode = currentNode.children[childIndex];										 // array value assigned to currentNode
	            charIndex  += 1;}																	 // charIndex value incremented 
	         	if (charIndex == key.length()) {													 // if loop to check the length of the key
	            currentNode.anagramIndices.add(index);								
	            anagramNodes.put(currentNode, currentNode.anagramIndices);}							 
	        return;																					 // return value if condition is true
	    }																							 // parameterized method insertIntoTrie() closed
	    public void printGroupedAnagrams(String[] sequence){										 // parameterized method printGroupedAnagrams() declared
	        HashMap<TrieNode, ArrayList<Integer>> anagramNodes = new HashMap();						 // hashMap initiated
	        for (int i = 0;  i < sequence.length; i++){												 // for loop 		
	            char[] charSequence = sequence[i].toCharArray(); 
	            Arrays.sort(charSequence);															 // sort the array
	            insertIntoTrie(new String(charSequence), i, anagramNodes);}
	        Iterator<ArrayList<Integer>> mapItr = anagramNodes.values().iterator();					 // array list declared
	        while (mapItr.hasNext()){																 // while loop to Anagram List  	
	        	System.out.print("{");
	        	ArrayList<Integer> currentAnagramList = mapItr.next();
	            for (int j = 0; j < currentAnagramList.size(); j++)  {								 // for loop to check Anagram Sequence 
	                int indexIntoSequence = currentAnagramList.get(j);
	            System.out.print(" " + sequence[indexIntoSequence]);}								// print statement
	            System.out.println(" }");}															// print statement
	    } 																							// parameterized method printGroupedAnagrams() closed
	    public static void main(String[] args){														// main method started
	    Anagrams anagram = new Anagrams();															// new object created
	    String[] sequence = {"listen", "pot", "part", "opt", "trap", "silent", "top", "this", "hello", "hits", "what", "shit"};  // String Array declared
	    System.out.println("\nInput Anagram List of Words       := {\"listen\", \"pot\", \"part\", \"opt\", \"trap\", \"silent\", \"top\", \"this\", \"hello\", \"hits\", \"what\", \"shit\"}"); // print statement
	    System.out.println("\nAnagram Sets from a list of Words : =");								// print statement		
	    anagram.printGroupedAnagrams(sequence); 													// printGroupedAnagrams() method called
	   }																							// main method closed
}																									// Anagrams class closed
