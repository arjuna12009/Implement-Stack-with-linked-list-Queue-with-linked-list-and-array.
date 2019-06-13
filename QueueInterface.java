package queue;

public interface QueueInterface<T> {
	
	public void enqueue(T value) throws QueueOverflowException;
	public T dequeue() throws QueueUnderflowException;
	boolean isfull();
	boolean isempty();
	int size();

}
