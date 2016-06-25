
public class GreatestOfThree {

	public static void main(String[] args) {
		int number = getGreatestOfThreeNumbers(1,3,5);
		
		System.out.println(number);
	}

	public static int getGreatestOfThreeNumbers(int p, int q, int r)
	{
		int greatest = (p > q) ? p : q;
		return (r > greatest) ? r : greatest;
	}

}
