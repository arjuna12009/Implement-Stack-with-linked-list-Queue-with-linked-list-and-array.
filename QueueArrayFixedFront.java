package queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueueArrayFixedFront<T> implements QueueInterface<T>{
		
		protected final int DEFCAP = 100;
		protected T[] elements;
		protected int num = 0;
		protected int front = 0;
		protected int rear;
		
		public QueueArrayFixedFront()
		{
			elements = (T[]) new Object[DEFCAP];
			rear = DEFCAP-1;
		}
		
		public QueueArrayFixedFront(int maxsize)
		{
			elements = (T[]) new Object[maxsize];
			rear = maxsize-1;
		}

		public boolean isfull()
		{
			return (num==elements.length);
		}
		
		public boolean isempty()
		{
			return (num == 0);
		}
		
		public int size()
		{
			return num;
		}
		
		public void enqueue(T value)
		{
			if(isfull())
				throw new QueueOverflowException("Dequeue attempted on a empty queue");
			else
			{
				rear = (rear+1)%elements.length;
				elements[rear] = value;
				num++;
			}
		}
		
		public T dequeue()
		{
			T element;
			if(isempty())
				throw new QueueUnderflowException("Dequeue attempted on a empty queue");
			else
			{
				element = elements[front];
				elements[front] = null;
				num--;
				return element;
			}
		}
		
		public T peek()
		{
			return elements[front];
		}
	
		
		public void print()
		{
			if(elements[rear]!=null)
			{
				for(int i = front; i <= rear; i++)
					System.out.println(elements[i]);
			}
			else
				System.out.println("Queue is empty");
		}
		
		public static void main(String[] args) {
			
			QueueArrayFixedFront<String> m = new QueueArrayFixedFront<String>();
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
			System.out.println("\n Queue contains: \n");
			m.print();
			System.out.println("\n Front element deleted: " + m.dequeue());
			System.out.println("\n Front element: " + m.peek());
			System.out.println("\n Queue after a dequeue: \n");
			m.print();
			

		}

	

}
