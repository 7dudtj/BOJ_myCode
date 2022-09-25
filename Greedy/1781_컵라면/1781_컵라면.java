import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{

        // set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        myQuestion[] qList = new myQuestion[N];
        int d = 0, c = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // asc order
        int answer = 0;

        // get questions
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            qList[i] = new myQuestion(d, c);
        }
        Arrays.sort(qList);

        // get obtained cup ramyeon queue
        for (int i = 0; i < N; i++){

            if (qList[i].deadLine > pq.size()){
                pq.add(qList[i].cupRamyeon);
            }else{
                if (pq.peek() < qList[i].cupRamyeon){
                    pq.poll();
                    pq.add(qList[i].cupRamyeon);
                }
            }
        }

        // find answer
        while (!pq.isEmpty()){
            answer += pq.poll();
        }

        // print answer and end program
        System.out.print(answer);
        br.close();
        return;
    }
}

class myQuestion implements Comparable<myQuestion>{

    // variables
    int deadLine;
    int cupRamyeon;

    // constructor
    public myQuestion(int d, int c){
        deadLine = d;
        cupRamyeon = c;
    }

    // compareTo
    @Override
    public int compareTo(myQuestion q){
        if (this.deadLine == q.deadLine) return q.cupRamyeon - this.cupRamyeon;
        else return this.deadLine - q.deadLine;
    }
}