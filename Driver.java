
public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		
		LinkedList ll = new LinkedList();
		/*try
		{
			System.out.println(ll.removeAtIndex(3));
		//	System.out.println(ll.removeEnd());
		//	System.out.println(ll.removeFront());
		}
		catch(Exception e)
		{
			System.out.println("Failed to remove");
		}
		*/
		ll.addFront(2);
		ll.addFront(3);
		ll.addEnd(9);
		ll.addFront(6);
		ll.addFront(7);
		ll.addEnd(19);
		ll.addAtIndex(88, 3);
		ll.display();
		ll.displayInReverse();
		/*try
		{
		//	System.out.println(ll.removeAtIndex(3));
		//	System.out.println(ll.removeEnd());
		//	System.out.println(ll.removeFront());
		}
		catch(Exception e)
		{
			System.out.println("Failed to remove");
		}
		ll.display();
		/*ll.addEnd(3);
		ll.addEnd(7);
		ll.addFront(99);
		ll.addEnd(4);
		ll.addEnd(1);
		ll.addAtIndex(10, 3);
		ll.display();
		/*System.out.println("Total Nodes Count: " + ll.count()); //quiz2
		System.out.println("Int at index 1 = " + ll.get(1));
		for(int i = 0; i < ll.count(); i++)
		{
			System.out.println(ll.get(i));
		}*/
		
		/*//EXCEPTION EXAMPLE
		String s = "5";
		try
		{
		System.out.println(Integer.parseInt(s) + 1);
		}
		catch(Exception e)
		{
			s = "5";
			System.out.println(Integer.parseInt(s) + 1);
		}
		finally //always happens
		{
			System.out.println("WOOT");
		}
		System.out.println("I am still alive");
		*/
		
	}
}
