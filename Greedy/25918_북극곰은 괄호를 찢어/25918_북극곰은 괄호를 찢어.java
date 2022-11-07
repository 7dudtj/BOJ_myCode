import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

	// set static variables

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		// exception handling
		if (input.length % 2 != 0){
			System.out.print("-1");
			return;
		}

		// calculate
		int status = 0, maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++){
			if (input[i] == '('){
				status += 1;
			}else{
				status -= 1;
			}
			if (maxValue < status) maxValue = status;
			if (minValue > status) minValue = status;
		}

		// check possibility
		if (status != 0){
			System.out.print("-1");
			return;
		}

		// print answer and end program
		System.out.print(Math.max(maxValue, Math.abs(minValue)));
		br.close();
		return;
	}
}