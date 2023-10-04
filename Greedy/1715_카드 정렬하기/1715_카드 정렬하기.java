import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1 - i2;
            }
        });
        long answer = 0;

        // Get cards
        for (int i = 0; i < N; i++){
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }
        br.close();

        // Calculate answer
        while (pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            answer += (first + second);
            pq.add(first + second);
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }
}