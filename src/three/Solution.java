package three;

import java.util.function.Function;

class Solution {	
	String result;
	
	public Solution(String s) {
		this.result = s;
	}

    public void solution(Function<String, String> func) {
      	result = func.apply(result);
    }
 
}
