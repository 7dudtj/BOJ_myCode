\import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stone = new int[N];

		// get stones
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++){
			stone[i] = Integer.parseInt(st.nextToken());
		}

		// count answer
		int max = 0;
		int min = 0;
		int count = 0;

		for (int i = 0; i < N; i++){
			if (stone[i] == 1) count++;
			else count--;
			if (count > max) max = count;
			if (count < min) min = count;
		}
		int answer = Math.abs(max - min);

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}
}