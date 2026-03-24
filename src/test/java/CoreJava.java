
public class CoreJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int myNum = 7;
		String name = "Ram";
		char letter = 'A';
		Boolean myCard = true;
		double decimal = 5.5;

		System.out.println(myNum);

		// ---------------ARRAYS----------------

		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 4;
		arr[2] = 3;
		arr[3] = 7;
		arr[4] = 9;
		System.out.println(arr[4]);

		int[] arr2={1,4,3,7,9};
		
		System.out.println(arr2 [2]);
		System.out.println("Starting Array learining");
		//--------------for loop-------------------
		for (int i=0; i<arr.length; i++) {
		
		System.out.println(i);
		}
		
		
		String[] names= {"Ram", "Venkatrao", "Marshivane"};
		
		for (int i= 0; i<names.length; i++) {
			
			System.out.println(names[i]);
		}
		
		//--------Enhanced For loop---------------
		
		for (String s: names) {
			System.out.println(s);
		}
	}

}
