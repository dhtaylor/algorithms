
public class NestedIfStatement {

	public static void main(String[] args) {
		int number = 14;
		
		if (number > 10)
		{
			if (number % 2 == 0)
			{
				System.out.println("Number is > 10 and divisible by 2");
			}
			else
			{
				System.out.println("Number is greater than 10");
			}
		}
	}
}
