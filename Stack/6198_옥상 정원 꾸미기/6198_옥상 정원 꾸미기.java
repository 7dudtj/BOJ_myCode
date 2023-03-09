import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		Stack<Integer> s = new Stack<>();
		
		// check value
		for (int i = 0; i < N; i++){
			int bd = Integer.parseInt(br.readLine());
			while (!s.isEmpty() && s.peek() <= bd) s.pop();
			s.push(bd);
			answer += s.size() - 1;
		}

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}
}