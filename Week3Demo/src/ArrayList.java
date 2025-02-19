
public class ArrayList 
{
	private int  MaxCapacity=20;
	private int []list = new int[MaxCapacity];
	private int Size;
	
	public  ArrayList()
	{
		Size=0;
	}
	
	public int getSize()
	{
		return Size;
	}
	
	public void add(int input)
	{
		if(Size>=MaxCapacity)
		{
			System.out.println(
					"!!Error: Array is Full!!");
			return;
		}
		
		list[Size++]=input;
	}
	
	public int getValue(int index)
	{
		if(index>=Size || index <0)
		{
			System.out.println(
					"!!Error: Index out of bounds!!");
			return -9999999;
		}
		return list[index];
	}
	
	public void removeAtIndex(int index)
	{
		if(index>=Size || index <0)
		{
			System.out.println(
					"!!Error: Index out of bounds!!");
			return;
		}
		
		
		
		for(int i = index; i<Size-1; i++)
		{
			list[i]=list[i+1];
		}
		Size--;
		
		
	}
	
	
}
