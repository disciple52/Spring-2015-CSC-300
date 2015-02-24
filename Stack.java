
public class Stack {
	private Node head;
	private Node tail;
	private int count;
	public Stack()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	public void push(int payload)
	{
		Node n = new Node(payload);
		if(head == null) //empty list make head point to it
		{
			this.head = n; //n's value is a pointer (a memory address) that points to a node
			this.tail = n;
		}
		else //otherwise make the new node point to the nextnode
		{
			this.head.setPreviousNode(n);
			n.setNextNode(head);
			this.head = n;
			this.count++;
		}
	}
	public int pop() throws Exception
	{
		if (head == null || this.count == 0)
		{
			throw new Exception("Cannot remove from Empty Stack");
		}
		else
		{
			Node curr = head;
			curr.getNextNode().setPreviousNode(null);
			head = curr.getNextNode();
			curr.setNextNode(null);
			this.count--;
			return curr.getPayload();
		}
	}
	public void peek()
	{
		System.out.println(head.getPayload()); 
	}
}
