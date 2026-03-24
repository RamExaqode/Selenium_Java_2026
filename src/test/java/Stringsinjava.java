import org.openqa.selenium.devtools.v143.systeminfo.SystemInfo;

public class Stringsinjava {

	public static void main(String[] args) {
		// String is an object in java which represents sequence of characters
		// String Literal
		String s = " Ram";
		String s1 = "Marshivane";

		// Using new keyword
		String s2 = new String(s1);
		System.out.println(s2);
		System.out.println(s1 + s);

		String s3 = " Quality Assurance Engineer: Ram Marshivane ";
		// If we want to split by white space
		 String [] spllitedString =s3.split(" ");
		//String[] spllitedString = s3.split("Engineer");
		System.out.println(spllitedString[0]);
		System.out.println(spllitedString[1]);
		// System.out.println(spllitedString[2]);
		// System.out.println(spllitedString[3]);
		// System.out.println(spllitedString[4]);
		// System.out.println(spllitedString[5]);
		System.out.println(spllitedString[0].trim()); //Trims the trailing and leading space
		
		//To print all the characters present in the string
		for (int i=0; i<s3.length();i++) {
			System.out.println(s3.charAt(i));
		}
		
		
		//Print String in Reverse Order
		for (int i =s3.length()-1; i>=0; i--) {
			System.out.println(s3.charAt(i));
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
