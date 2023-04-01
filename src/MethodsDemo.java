
public class MethodsDemo {

	public static void main(String[] args) {	
		MethodsDemo d1 = new MethodsDemo();
		d1.Getdata();
		MethodDemo1 d2 = new MethodDemo1();
	    System.out.println(d2.Userdata());
	    Employeedata();
	}
	public void Getdata() {
		System.out.println("Calling Getdata() method");	
	}
	//static keyword, we can directly access method->s no need to create to create object
	public static void Employeedata() {
		System.out.println("Calling Employeedata() method");
	}
}
