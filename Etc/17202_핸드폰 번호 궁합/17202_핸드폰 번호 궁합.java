import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// set needed components
		Scanner read = new Scanner(System.in);
		String A, B;
		String firstStage = "";
		String shuttle = "", inputanswer = "", outputanswer = "";
		int i, sum, len;
		
		// get user input
		A = read.nextLine();
		B = read.nextLine();
		read.close();
		
		// get first stage
		for (i = 0; i < 8; i++) {
			firstStage += A.substring(i, i + 1) + 
					B.substring(i, i + 1);
		}
		inputanswer = firstStage;
		len = inputanswer.length();
		
		// do processing
		while (len != 2) {
			outputanswer = "";
			for (i = 0; i < len - 1; i++) {
				sum = 0;
				sum = Integer.parseInt(inputanswer.substring(i, i + 1)) + 
						Integer.parseInt(inputanswer.substring(i + 1, i+ 2));
				if (sum >= 10) sum %= 10;
				
				shuttle = Integer.toString(sum);
				
				outputanswer += shuttle;
			}
			
			len = outputanswer.length();
			inputanswer = outputanswer;
		}
		
		System.out.println(outputanswer);
	}
}
