package stack;
import support.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import queue.QueueUnderflowException;

public class StackLinkedList<T> implements StackInterface<T>{
	
	protected Node<T> top;
	
	public StackLinkedList()
	{
		top = null;
	}
	
	public boolean isempty()
	{
		return(top == null);
	}
	
	public boolean isfull()
	{
		return false;
	}
	
	public void push(T value)
	{
		Node<T> newnode = new Node<T>(value);
		newnode.setlink(top);
		top = newnode;
	}
	
	public void pop()
	{
		if(isempty())
			throw new StackUnderflowException("pop attempted on an empty stack");
		else
			top = top.getlink();
		
	}
	
	public T peek()
	{
		if(isempty())
			throw new StackUnderflowException("peek attempted on an empty stack");
		else
			return top.getinfo();
	}
	
	public void print()
	{
		Node<T> t = top;
		if(isempty())
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
		System.out.println("Enter the file name: ");
		String filename = input.nextLine();
		input.close();
		File fobj = new File(filename);
		try{
			Scanner s = new Scanner(fobj);
			while(s.hasNextLine())
			{	
				m.push(s.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		m.print();
		System.out.println("\nemployee at the top of the stack: " + m.peek());
		m.pop();
		System.out.println("employeed at the top of the stack after a pop: " + m.peek());
	}

}
