import java.util.ArrayList;

public class ArrayListPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("Ram");
		a.add("Venkatrao");
		a.add("Marshivane");
		a.add(2, "Last name");
		a.add(4, "Selenium");
		System.out.println(a);
		a.remove(3);
		System.out.println(a);
		System.out.println(a.getFirst());
		System.out.println(a.getLast());
		System.out.println(a.get(2));

		// Printing values in the array list

		for (int i = 0; i < a.size(); i++) 
		{
			System.out.println(a.get(i));
		}

		System.out.println("**************");
		
		// ---------------------Enhanced For loop-----------------------
		for (String val : a) 
		{
			System.out.println(val);
		}

		//Check if the arraylist contains an Item
		
		System.out.println(a.contains("Selenium"));
		System.out.println(a.contains("Selenium java"));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
