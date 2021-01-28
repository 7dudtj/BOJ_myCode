import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N;
    long answer = 0;

    // get N
    N = Integer.parseInt(br.readLine());

    // do process
    for(int i = 1; i<=N; i++) {
    		if(i<10)
    			answer++;
    		else if(i>=10 && i<100)
    			answer += 2;
    		else if(i>=100 && i<1000)
    			answer += 3;
    		else if(i>=1000 && i<10000)
    			answer += 4;
    		else if(i>=10000 && i<100000)
    			answer += 5;
    		else if(i>=100000 && i<1000000)
    			answer += 6;
    		else if(i>=1000000 && i<10000000)
    			answer += 7;
    		else if(i>=10000000 && i < 100000000)
    			answer += 8;
        else answer += 9;
    	}

    // print answer and end program
    System.out.print(answer);
    br.close();
    return;
  }
}
