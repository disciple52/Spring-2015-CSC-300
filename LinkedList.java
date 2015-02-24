public class LinkedList 
{
	private Node head;
	private Node tail;
	private int count;
	
	
	//upgrade our LinkedList such that there is a pointer called
	//tail that points to the end of the list and each node knows
	//about the previous node. So you need to update all the 
	//add methods, all the remove methods, and finally re-write 
	//displayInReverse to take advantage of our new double-linked list.
	
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public void displayInReverse()
	{		
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.tail;
			while(currNode.getPreviousNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getPreviousNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
		/*
		//start at tail and work backwards via previousNode
		Node currNode = this.tail;
		for(int i=this.count-1; i >= 0; i--)
		{
			System.out.print(currNode.getPayload() + "->");
			currNode = currNode.getPreviousNode();
		}
		System.out.print("Null");
		*/
		/*//inefficient way
		for(int i = this.count-1; i >= 0; i--)
		{
			System.out.print(this.get(i) + "->");
		}
		System.out.println("null");
		//BEST WAY
		/*LinkedList temp = new LinkedList(); 
		for(int i = 0; i < this.count; i++)
		{
			temp.addFront(this.get(i));
		}
		temp.display();
		*/
	}
	
	public int get(int index)
	{
		int count = this.count(); //could be more efficient if we used a running total
		if(index >= count || index < 0)
		{
			System.err.println("Illegal index");
			return -1; // must return type int
		}
		else //index is a legal place in the list
		{
			Node curr = head; //we need a second pointer because we can't move head
			for(int i =0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload(); //payload is an int inside of the Node object
		}
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
	}
	/*//QUIZ 3
	void printOdds()
	{
		Node currNode = head;
		while(currNode != null)
		{
			if(currNode.getPayload() % 2 == 1)
			{
				System.out.println(currNode.getPayload());
			}
			currNode = currNode.getNextNode();
		}
	}
	*/
	
	public int count() 
	{
		return count;
		/*if(head == null) //QUIZ 2
		{
			return 0;
		}
		else
		{
			int sum = 1;
			Node curr = head;
			while (curr.getNextNode() != null)
			{
				sum++;
				curr = curr.getNextNode();
			}
			return sum;
		}*/
	}
	
	public void addAtIndex(int payload, int index)
	{
		if(index <= 0)
		{
			this.addFront(payload);
		}
		else if(index >= this.count)
		{
			this.addEnd(payload);
		}
		else
		{
			Node n = new Node(payload);
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			n.setNextNode(curr);
			n.setPreviousNode(curr.getPreviousNode());
			curr.setPreviousNode(n);
			n.getPreviousNode().setNextNode(n);
			this.count++;
		}
	}
	
	public void addFront(int payload) //hw1
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
		}
		this.count++;
	}
	
	public void addEnd(int payload)
	{		
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
			this.tail = n;
		}
		else
		{
			this.tail.setNextNode(n);
			n.setPreviousNode(this.tail);
			this.tail = n;			
		}
		this.count++;
	}
	
	public int removeFront() throws Exception
	{
		if (head == null)
		{
			throw new Exception("Can Not Remove Front: Empty List");
		}
		else if(this.count ==1)
		{
			int payloadToReturn = this.head.getPayload();
			this.head = null;
			this.tail = null;
			this.count--;
			return payloadToReturn;
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
	public int removeEnd() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		else if(this.count == 1)
		{
			return this.removeFront();
		}
		else
		{
			Node curr = tail;
			tail = curr.getPreviousNode();
			curr.setPreviousNode(null);
			tail.setNextNode(null);
			this.count--;
			return curr.getPayload();
		}
	}
	public int removeAtIndex(int index) throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove At Index: Empty List");
		}
		else if(index < 0 || index > this.count-1)
		{
			throw new Exception("Can Not Remove At Index: Index Out of Bounds : " + index);
		}
		else
		{
			//so we have something to remove
			if(index == 0)
			{
				return this.removeFront();
			}
			else if(index == this.count-1)
			{
				return this.removeEnd();
			}
			else
			{
				Node currNode = head;
				for(int i = 0; i < index; i++)
				{
					currNode = currNode.getNextNode();
				}
				currNode.getPreviousNode().setNextNode(currNode.getNextNode());
				currNode.getNextNode().setPreviousNode(currNode.getPreviousNode());
				currNode.setNextNode(null);
				currNode.setPreviousNode(null);
				this.count--;
				return currNode.getPayload();
			}
		}
	}
}