package queue;

public class QueueOverflowException extends RuntimeException{
	
	public QueueOverflowException()
	{
		super();
	}
	
	public QueueOverflowException(String m)
	{
		super(m);
	}

}
