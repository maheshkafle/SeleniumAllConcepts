
public class fibonacci {
	public static void main(String[] args) {

		int n=4, firstTerm=0, secondTerm=1;
		System.out.println("Fibonacci series till "+n +" terms:");

		for (int i=0; i<=n; i++) {
			System.out.println(firstTerm + ", ");

			//compute the next term
			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;

		}

	}
}
