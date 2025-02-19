
public class LinkedList 
{
	private class Node
	{
		public int data;
		public Node tail;
		
		Node(int input)
		{
			data=input;
			tail = null;
		}
	}
	
	Node Head = null;
	Node Current=null;
	
	public boolean isEmpty()
	{
		if(Head==null)
			return true;
		
		return false;
	}
	
	public void Add(int input)
	{
		Node temp = new Node(input);
		
		if(Head==null)
		{
			Head=temp;
			return;
		}
		
		Current=Head;
		while(Current.tail!=null)
			Current=Current.tail;
		
		Current.tail = temp;
	}
	
	public void DisplayList()
	{
		if(isEmpty())
		{
			System.out.println("List is Empty!");
		}
		
		Current=Head;
		do
		{
			System.out.println(Current.data);
			Current=Current.tail;
		}while(Current!=null);
		
	}
	
	public boolean FindValue(int input)
	{
		if(isEmpty())
			return false;
		
		Current=Head;
		boolean found=false;
		while(found ==false && Current!=null)
		{
			if(Current.data == input)
				found=true;
			else
				Current=Current.tail;
		}
		
		return found;
	}
	
	
	public void removeValue(int input)
	{
		if(!FindValue(input))//Value not in list
		{
			return;
		}
		else if(Current.tail!=null)
		{
			Current.data = Current.tail.data;
			Current.tail=Current.tail.tail;
		}
		else//Current is last Node
		{
			Node tempPos=Head;
			
			while(tempPos.tail!=Current)
				tempPos=tempPos.tail;
			
			tempPos.tail=null;
		}
		
	
		
		
		
		
		
		
	}
	

}
