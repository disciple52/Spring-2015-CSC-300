
public class Stack {
	private Node head;
	private int count;
	public Stack()
	{
		this.head = null;

		this.count = 0;
	}
	public void push(int payload)
	{
		Node n = new Node(payload);
		if(head == null) //empty list make head point to it
		{
			this.head = n; 
		}
		else //otherwise make the new node point to the nextnode
		{
			n.setNextNode(head);
			this.head = n;
		}
		this.count++;
	}
	public int pop() throws Exception
	{
		if (head == null || this.count == 0)
		{
			throw new Exception("Cannot remove from Empty stack");
		}
		else
		{
			Node currNode = head;
			head = head.getNextNode();
			currNode.setNextNode(null);
			this.count--;
			return currNode.getPayload();
		}
	}
	public void peek()
	{
		if(head == null || this.count == 0)
		{
			System.out.println("Empty stack");
		}
		else
		{
			System.out.println(head.getPayload());
		}
	}
}
