package queue;
import support.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QueueLinkedList<T> implements QueueInterface<T>{
	
	protected Node<T> front;
	protected Node<T> rear;
	protected int num = 0;
	
	public QueueLinkedList()
	{
		front = null; rear = null;
	}
	
	public boolean isfull()
	{
		return false;
	}
	
	public boolean isempty()
	{
		return (num == 0);
	}
	
	public void enqueue(T value)
	{
		Node<T> newnode = new Node<T>(value);
		if(rear == null)
			front = newnode;
		else
			rear.setlink(newnode);
		rear = newnode;
		num++;
	}
	
	public T dequeue()
	{
		T element;
		element = front.getinfo();
		front = front.getlink();
		if(front == null)
			rear = null;
		num--;
		return element;
		
	}
	
	public void print()
	{
		Node<T> t = front;
		if(isempty())
			throw new QueueUnderflowException("Queue is empty");
		else
		{
			System.out.println("\nEmployee Queue contains: ");
			while(t!=null)
			{
				System.out.println(t.getinfo());
				t = t.getlink();
			}
		}
	}
	
	public int size()
	{
		return num;
	}

	public static void main(String[] args) {
		
		QueueLinkedList<String> m = new QueueLinkedList<String>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String filename = input.nextLine();
		input.close();
		File fobj = new File(filename);
		try
		{
			Scanner e = new Scanner(fobj);
			while(e.hasNextLine())
			{
				m.enqueue(e.nextLine());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		m.print();
		System.out.println("Front element removed: " + m.dequeue());
		

	}

}
