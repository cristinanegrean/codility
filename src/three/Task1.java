package three;

import java.util.Arrays;

public class Task1 {

   public static void main(String[] args) {
       final String s = " ADBCFABGUJ ";	        	  
	   String[] replace = {"AB", "BCF"};
	   Solution solve = new Solution(s);
	  
	   
	   Arrays.asList(replace).stream()
	   		.forEach(sb -> solve.solution(ts -> ts.replaceAll(sb, "")));
	  
	   System.out.print(solve.result);
	   
   }
   

}