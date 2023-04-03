import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main{

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> l = new ArrayList<>();

		// get data
		for (int i = 0; i < N; i++){
			l.add(br.readLine());
		}

		// find answer
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; i++){
			String tmp = l.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(tmp);
			sb.reverse();
			tmp = sb.toString();
			if (l.contains(tmp)){
				answer.append(tmp.length()+" ");
				answer.append(tmp.substring(tmp.length() / 2, tmp.length() / 2 + 1));
				break;
			}
		}

		// print answer and end program
		System.out.print(answer);
		br.close();
		return;
	}
}