import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[N+1];
		for (int i = 2; i <= N; i++) prime[i] = true;
		int[] value = new int[N+1];
		for (int i = 2; i <= N; i++) value[i] = i;
		long[] dp = new long[N+1];

		// find prime numbers
		for (int i = 2; i*i <= N; i++){
			for (int j = i*i; j <= N; j += i){
				prime[j] = false;
				if (value[j] == j){
					value[j] = i;
				}
			}
		}

		// do dp
		dp[2] = 2;
		for (int i = 3; i <= N; i++){

			// i == prime number
			if (prime[i]){
				dp[i] = dp[i-1] + i;
			}
			// i != prime number
			else{
				dp[i] = dp[i-1] + value[i];
			}
		}

		// print answer and end program
		System.out.print(dp[N]);
		br.close();
		return;
	}
}