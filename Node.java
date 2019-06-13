package support;

public class Node<T> {
	
	protected T info;
	protected Node<T> link;
	public Node(T info)
	{
		this.info = info;
		link = null;
	}
	
	public T getinfo() 
	{
		return info;
	}
	public void setinfo(T info)
	{
		this.info = info;
	}
	public Node<T> getlink()
	{
		return link;
	}
	public void setlink(Node<T> link)
	{
		this.link = link;
	}

}
