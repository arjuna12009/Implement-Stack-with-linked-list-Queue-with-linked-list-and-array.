package stack;


public interface StackInterface<T> {
	
	void push(T value) throws StackOverflowException;
	void pop() throws StackUnderflowException;
	T peek() throws StackUnderflowException;
	boolean isempty();
	boolean isfull();
	
}
