package queue;

public class QueueUnderflowException extends RuntimeException{
	
	public QueueUnderflowException()
	{
		super();
	}
	
	public QueueUnderflowException(String m)
	{
		super(m);
	}

}
