package one;

public class Task2 {
	
	public static void main(String[] args) {
		Tree t1 = constructTree(9);
		Tree t2 = constructTree(1);
		Tree t3 = constructTree(5);
		Tree t4 = constructTree(4);
		Tree t5 = constructTree(3);
		Tree t6 = constructTree(2);
		Tree t7 = constructTree(6);
		Tree t8 = constructTree(11);
		Tree t9 = constructTree(13);
		Tree t10 = constructTree(1);	
		
		t1.l=t2;
		t1.r=t7;
		t2.l=t3;
		t2.r=t5;
		t3.l=t4;
		t2.r=t5;
		t5.r=t6;
		t7.l=t8;
		t7.r=t9;
		t9.r=t10;  
		
		System.out.format("\n Binary tree amplitude: %s", Solution.solution(t1));
	}
	
	private static Tree constructTree(int value) {
		Tree t = new Tree();
		t.x = value;
		
		return t;
	}

}
