
public class CoreJava2 {

	public static void main(String[] args) {

		// ---------------If Else Loop--------------------------
		// Find values from the arrays which are multiple of 2
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17 };

		for (int i = 0; i < arr2.length; i++)
		{
			if (arr2[i] % 2 == 0) 
			{

				System.out.println(arr2[i]);
				//break;
			}
			else 
			{
				System.out.println(arr2[i] +" is not multiple of 2");
			}
		}
	}
}
