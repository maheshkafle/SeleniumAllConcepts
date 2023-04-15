import java.util.ArrayList;

public class CoreJavaBrushUp {

	public static void main(String[] args) {

		int myNum=5;
		String website = "Mahesh Kafle academy";
		char letter = 'c';
		double dec = 5.99;
		float pointValue = 4.6f;
		boolean myCard = true;
		System.out.println("This is my card" + myCard);
		System.out.println(website);
		System.out.println(letter);
		System.out.println(dec);
		//Integer Arrays
		int[] arr1 = new int[5];
	    arr1[0] = 1;
	    arr1[1] = 2;
	    arr1[2] = 3;
	    arr1[3] = 4;
	    arr1[4] = 5;
	    int[] arr2 = {10,11,12,13,14,15};
	    System.out.println("------------------------------");
	    System.out.println("arr1[0] : " + arr1[0]);
	    System.out.println("arr2[3] : " + arr2[3]);

	    //Object Array -> Array that stores different data type
	    Object[] obj = new Object[3];
	    obj[0] = "Mahesh";
	    obj[1] = 26;
	    obj[2] = "Lisec";

	    System.out.println("------------------------------");
	    for(Object ob1 :obj) {
	    	System.out.println(ob1);
	    }
	    // for loop
	    System.out.println("------------------------------");
	    for(int i=0; i< arr2.length; i++) {
	    	System.out.println("arr2["+i+"]: " + arr2[i]);
	    }
	    //while loop
	    System.out.println("------------------------------");
	    int j=0;
	    while(j<arr1.length)
	    {
	    	System.out.println("arr1["+j+"]: "+ arr1[j]);
	    	j++;
	    }
	    //array of string
	    System.out.println("------------------------------");
	    String[] str = {"Mahesh","Kafle", "Academy"};
	    for (int k=0; k<str.length; k++) {
	    	System.out.println(str[k]);
	    }

	    //Enhanced For loop
	    System.out.println("------------------------------");
	    String[] str1 = {"Dhanewa","Gatthaghar", "Discovery Garden"};
	    for(String s: str1) {
	    	System.out.println(s);
	    }
	    System.out.println("------------------------------");
	    int[] i2 = {1, 5, 9, 13};
	    for(int i1 : i2) {
	    	System.out.println(i1);
	    }
	    //Using conditional statement inside Loop
	    int[] i3 = {1,3, 5, 6, 8, 11, 12, 16, 122};
	    System.out.println("------------------------------");
	    for(int i4: i3) {
	    	if(i4 % 2 ==0) {
	    		System.out.println("Even number ->"+ i4);
	    	}
	    	else {
	    		System.out.println("Odd number ->"+ i4);
	    	}
	    }
	    System.out.println("------------------------------");
	    //Arraylist -> size of arraylist is dynamic / no need to provide fixed size/ useful for dynamically growing data
	    ArrayList<String> a = new ArrayList<>();
	    a.add("Sakcham");
	    a.add("Kafle");
	    a.add("Orange Excavator");
	    a.add("Balkumari school");
	    a.remove(1);
	    System.out.println(a.get(2));
	    System.out.println("------------------------------");
	    for (int s5=0; s5<a.size(); s5++) {
	    	System.out.println(a.get(s5));
	    }
	    System.out.println("------------------------------");
	    for(String s1: a) {
	    	System.out.println(s1);
	    }
	    //To check item is present in ArrayList
	    System.out.println("------------------------------");
	    System.out.println("Is sakcham present in ArrayList "+a.contains("Sakcham"));

	    //String

	    //String can be created in 2 ways
	    //In Java String is an object(not data type) which consists of sequence of chars
	    //1. String literal -> Here since content of s2 and s3 is same so s3 also points to same memory allocated for s2 i.e only one object is created
	    String s2 = "Mahesh Kafle course";
	    String s3 = "Mahesh Kafle course";

	    //2. new-> Even if the content is same, new object will be created
	    String s4 = "Hi";
	    String s5 = "Hi";

	    System.out.println("------------------------------");
	    //Print s2 string in reverse order
	    System.out.println("Is sakcham present in ArrayList "+a.contains("Sakcham"));
	    for(int d=s2.length()-1; d>=0; d--) {
	    	System.out.println(s2.charAt(d));
	    }
	}

}
