package five;

import java.util.Stack;

/**
 * Model a data structure that performs the stack operations push and pop as well as an operation min that returns the
 * minimum element in the stack. Each operation takes  O(1)  time.
 */
public class MinimumStack {

    /**
     *  Store  two  stacks,  one  of  which  contains  all  of  the  items  in  the  stack  and  one  of  which  is  a  stack  of  minima. 
     */
    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();

    /**  
     * To  push  an  element,  push  it  on to  the  first  stack.  
     * Check  whether  it  is  smaller  than  the  top  item  on  the  second  stack;  if so,  push  it  on to  the  second  stack. 
     */
    public void push(int nr) {
        stackOne.push(nr);
        if (stackTwo.empty() || nr < stackTwo.peek()) {
            stackTwo.push(nr);
        }
    }

    /**
     *  To  pop  an  item,  pop  it  from  the  first  stack. If  it  is  the  top  element  of  the  second  stack,  pop  it  from  the  second  stack.
      */
    public void pop() {
        if (stackOne.empty()) return;
        int nr = stackOne.pop();
        if (nr == stackTwo.peek()) {
            stackTwo.pop();
        }
    }

    /**  
     * To  find  the  minimum  element,  simply  return  the  element  on  the  top  of  the  second  stack.
     */
    public int min() {
        if (stackTwo.empty()) return Integer.MIN_VALUE;
        return stackTwo.peek();
    }

}
