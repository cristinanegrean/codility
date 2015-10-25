package two;

import two.Solution;


public class Task1 {

   public static void main(String[] args) {
      int[] A = {8, 24, 3, 20, 1, 17};    
      int[] B = {8, 1, 3, 20, 17, 20, 17};
      
      Solution solve = new Solution();
      
      System.out.format("\n The minimum distance between two distinct elements of array A is: %s ", 
    		  solve.solution(A));
      System.out.format("\n The minimum distance between two distinct elements of array B is: %s ", 
    		  solve.solution(B));
   }
}