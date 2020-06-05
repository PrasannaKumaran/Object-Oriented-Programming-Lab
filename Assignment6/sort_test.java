import java.util.*;
class sort<T extends Comparable<T>>
{
   	private T array[];
   	public sort(T array[])
	{
		this.array = array;
	}
	public void sort_array()
	{
		for(int i = 0 ; i<array.length; i++)
		{
			for(int j= i + 1; j<array.length;j++)
			{	if(array[i].compareTo(array[j])>0)
				{
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		display_sorted_array();
	}
	public void display_sorted_array()
	{
		System.out.println("Sorted array : ");
		for(int i= 0 ; i< array.length; i++)
			System.out.print(array[i] + "  ");
	}
	public void display_array()
	{
		System.out.println("Input Array : " );
		for(int i= 0 ; i< array.length; i++)
			System.out.print(array[i] + "  ");
		System.out.println();
	}
}
class sort_test
{
	public static void main(String args[])
	{
		int n;
		Scanner det = new Scanner(System.in);
		System.out.println("Enter size of array");
		n = det.nextInt();
		Integer arr[] = new Integer[n];
		System.out.println("Enter the array elements");
		int data;
		for (int i=0;i<n;i++)
			arr[i] = det.nextInt();
		sort<Integer> s = new sort<Integer>(arr);
		s.display_array();
		s.sort_array();
	}
}
