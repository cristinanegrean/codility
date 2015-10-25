package two;
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {	
	/**
	 * A[N]
	 * N is integer in range [2..100,000]
	 * each element of A is an integer within range [0..1,000,000]
	 * @param A non null, non-empty array
	 */
    public int solution(int[] A) {
       // write your code in Java SE 8
       // if there are duplicates, the minimum will be 0
       IntStream numbers = Arrays.stream(A);
       if (numbers.distinct().count() < A.length) {
    	   return 0;
       } else {
    	   int 	firstMin =  Arrays.stream(A).min().getAsInt();
       	   int secondMin = Arrays.stream(A).filter(n -> n != firstMin).min().getAsInt();
    	   return secondMin - firstMin;
       }  	
       
     }
 
}
