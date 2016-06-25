
public class AssignNewArray {

	public static void main(String[] args) {

		int[] myNumbers = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			myNumbers[i] = (2 * i) + 2;
		}

		for(int num: myNumbers)
		{
			System.out.println(num);
		}
		
	}

}
