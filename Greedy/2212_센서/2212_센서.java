import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main{

    // set static variables

    public static void main(String[] args) throws IOException{

        // set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        Integer[] sensor = new Integer[N];
        for (int i = 0; i < N; i++){
            sensor[i] = Integer.parseInt(tmp[i]);
        }
        int answer = 0;

        // exception handling: N <= K
        if (N <= K){
            System.out.println("0");
            br.close();
            return;
        }

        // sort sensor data
        Comparator<Integer> asc = new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        };
        Arrays.sort(sensor, asc);

        // get distance data
        Integer[] dis = new Integer[N-1];
        for (int i = 0; i < N - 1; i++){
            dis[i] = Math.abs(sensor[i] - sensor[i + 1]);
        }
        Comparator<Integer> des = new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        };
        Arrays.sort(dis, des);

        // find answer
        for (int i = K - 1; i < N - 1; i++){
            answer += dis[i];
        }

        // print answer and end program
        System.out.print(answer);
        br.close();
        return;
    }
}