package one;
import java.util.Arrays;

class Solution {
	private static int EMPTY_TREE_AMPLITUDE = 0;
	private static int amplitude = EMPTY_TREE_AMPLITUDE;
	/** don't remember exactly what the maximum number of nodes in the tree, but change here if higher, lower according specs. */
	private static int SIZE = 100;
	private static int INITIAL_LENGTH = 0;
	
    public static int solution(Tree T) {
        // write your code in Java SE 8
       if (T == null) return EMPTY_TREE_AMPLITUDE;
       
       int[] nodes = new int[SIZE] ;
   
       // initialize nodes with INT MIN VALUE to be able to filter out in IntStream min(), suppose nodes value is allowed to be int value 0
       // but not int value min
       for (int i = 0; i < SIZE; i++) {
    	   nodes[i] = Integer.MIN_VALUE;
       }
       printAllPathsToLeaf(T, nodes, INITIAL_LENGTH);
       
       return amplitude;
    }
    
    // Prints all paths to leaf  
    public static void printAllPathsToLeaf(Tree node, int[] path, int len) {  
        if (node == null)   
            return;  
     
        // storing data in array  
        path[len] = node.x;  
        len++;
     
        if(node.l == null && node.r == null) {  // leaf node is reached  
        	System.out.println();
        	Arrays.stream(path).filter(n -> n != Integer.MIN_VALUE).forEach(n -> System.out.print(n + " ")); //print out path node values
        	int pathAmplitude = Arrays.stream(path).max().getAsInt() - Arrays.stream(path).filter(n -> n != Integer.MIN_VALUE).min().getAsInt();
        	if (pathAmplitude > amplitude) {
        		amplitude = pathAmplitude;
        	}
        	
        	//Arrays.stream(path).max().ifPresent(max -> System.out.format("\n max: %s ", max));
        	//Arrays.stream(path).filter(n -> n > 0).min().ifPresent(min -> System.out.format("\n min: %s \n", min));
        	
            return;  
        }  
     
        printAllPathsToLeaf(node.l, path, len);  
        printAllPathsToLeaf(node.r, path, len);  
    }  
   
}
