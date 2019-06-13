package stack;
import support.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import queue.QueueUnderflowException;

public class StackLinkedList<T> implements StackInterface<T>{
	
	protected Node<T> top;
	
	public StackLinkedList()					//constructor
	{
		top = null;
	}
	
	public boolean isempty()					//method checks for an empty stack
	{
		return(top == null);
	}
	
	public boolean isfull()						//method checks for a full stack which always returns false as stacks with linked list
	{								//are never full.
		return false;
	}
	
	public void push(T value)					//method to push/add information on top of a stack
	{
		Node<T> newnode = new Node<T>(value);
		newnode.setlink(top);
		top = newnode;
	}
	
	public void pop()						//method to pop/remove information from the top of the stack
	{
		if(isempty())						//check for empty stack and if true, give an exception
			throw new StackUnderflowException("pop attempted on an empty stack");
		else
			top = top.getlink();				//delete the top element.
		
	}
	
	public T peek()							//method to peek/look at the top element of the stack
	{
		if(isempty())						//check for an empty stack and if true give an exception
			throw new StackUnderflowException("peek attempted on an empty stack");
		else
			return top.getinfo();				//return the top element.
	}
	
	public void print()						//method to print all the elements in the stack
	{
		Node<T> t = top;					//creating a temporary node
		if(isempty())						//check for an empty stack and if true give an exception
			throw new QueueUnderflowException("Queue is empty");
		else
		{
			System.out.println("\nEmployee Queue contains: \n");
			while(t!=null)
			{
				System.out.println(t.getinfo());
				t = t.getlink();
			}
		}
	}
	
	public static void main(String[] args)
	{
		StackLinkedList<String> m = new StackLinkedList<String>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name: ");		//prompt the user for the file name
		String filename = input.nextLine();			//can also just put 'emp.txt' here for the assignment instead of 'input.nextlin()'
		input.close();
		File fobj = new File(filename);				//object of the file
		try{
			Scanner s = new Scanner(fobj);			//reading the file
			while(s.hasNextLine())				//iterate through the file
			{	
				m.push(s.nextLine());			//adding the elements of the file to the stack
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		m.print();						//printing the output
		System.out.println("\nemployee at the top of the stack: " + m.peek());
		m.pop();
		System.out.println("employeed at the top of the stack after a pop: " + m.peek());
		
	}

}
