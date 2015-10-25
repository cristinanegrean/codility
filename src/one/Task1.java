package one;
import java.util.Arrays;


public class Task1 {

   public static void main(String[] args) {
       String tmpStr = "   we   test    coders     ";	        
	   String[] words = tmpStr.split("\\s+");
	   StringBuilder result = new StringBuilder();
	        
	   Arrays.asList(words).forEach(s -> result.append(" ").append(new StringBuilder(s).reverse().toString()));
	        
	   System.out.print(result.toString().trim());
	   
   }
}