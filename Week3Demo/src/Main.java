
public class Main {

	public static void main(String[] args) 
	{
		/*
		ArrayList AList = new ArrayList();
		
		AList.add(54);
		AList.add(3);
		AList.add(11);
		AList.add(5);
		AList.add(77);
		AList.add(100);
		AList.add(56);
		AList.add(23);
		AList.add(43);
		AList.add(19);
		AList.add(32);
		AList.add(14);
		AList.add(67);
		AList.add(65);
		AList.add(87);
		AList.add(98);
		
		//System.out.println("The number is " + AList.getValue(9));
		
		for(int i = 0; i<AList.getSize();i++)
		{
			System.out.println(AList.getValue(i));
		}
		
		System.out.println("------------------");
		
		AList.removeAtIndex(5);
		for(int i = 0; i<AList.getSize();i++)
		{
			System.out.println(AList.getValue(i));
		}
		*/
		
		LinkedList LL= new LinkedList();
		
		LL.Add(5);
		LL.Add(25);
		LL.Add(3);
		LL.Add(66);
		LL.Add(67);
		LL.Add(98);
		LL.Add(56);
		LL.Add(45);
		
		LL.DisplayList();
		
		LL.removeValue(5);
		System.out.println("------------------");
		
		LL.DisplayList();

	}

}
