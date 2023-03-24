import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{

	// set static variables

	public static void main(String[] args) throws IOException{

		// set needed variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		Stack<Character> s = new Stack<>();

		// do process for every character at string
		for (int i = 0; i < input.length(); i++){
			
			s.push(input.charAt(i));

			if (s.size() < bomb.length()) continue;

			// check bomb string
			boolean find = true;
			for (int j = 0; j < bomb.length(); j++){

				if (s.get(s.size() - bomb.length() + j) != bomb.charAt(j)){
					find = false;
					break;
				}
			}

			// bomb string
			if (find){
				for (int j = 0; j < bomb.length(); j++){
					s.pop();
				}
			}
		}

		// get answer
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.size(); i++){
			sb.append(s.get(i));
		}

		// print answer and end program
		System.out.print(sb.length() > 0 ? sb : "FRULA");
		br.close();
		return;
	}
}