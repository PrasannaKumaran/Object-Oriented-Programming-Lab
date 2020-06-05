import java.util.*;
class stack<T>
{
	private T st[];
	private int top;
	private int capacity;
	stack(T st[],int size)
	{
		this.st = st;
		top = -1;
		capacity = size;
	}
	void push(T item)
	{
		if(isFull())
		  System.out.println("Stack is Full");
		else
		  st[++top] = item;
	}
	T pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			return st[top+1];
		}
		else
			return st[top--];
		}
	boolean isEmpty()
	{
		return top == -1;
	}
	boolean isFull()
	{
		return top == capacity -1;
	}
}
class stack_test
{
	public static void main(String args[])
	{
		int n;
		Scanner det = new Scanner(System.in);
		System.out.println("Enter the size of the stack");
		n = det.nextInt();
		Integer ar[] = new Integer[n];
 		stack<Integer> s = new stack<Integer>(ar,n);
 		System.out.println("Stack Empty ? :" + s.isEmpty()+ "\n");
 		System.out.println("Enter the elements");
 		int data;
 		for(int i = 0 ; i < 5; i++)
 		{	
 			data = det.nextInt();
 			s.push(data);
 		}
 		System.out.println("Stack Empty now? : " + s.isEmpty()+ "\n");
 		System.out.println("Stack Full ? : " + s.isFull() + "\n");
 		for(int i=5;i<n; i++)
 		{	
 			data = det.nextInt();
 			s.push(data);
 		}
 		System.out.println("Stack Full? " + s.isFull()+ "\n");
 		System.out.println("Popping the elements now");
 		for(int i=0;i<n;i++)
 		{
 			System.out.println(s.pop() + "  ");
 		}
 		System.out.println("Stack Empty ? " + s.isEmpty()+ "\n");
 		
 	}
 }
 		
		
