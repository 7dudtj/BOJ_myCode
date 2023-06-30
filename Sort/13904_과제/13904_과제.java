import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        // Set needed variables
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Work> workList = new PriorityQueue<>();
        PriorityQueue<Integer> doList = new PriorityQueue<>();
        String[] tmp = null;
        int answer = 0;

        // Get work list
        for (int i = 0; i < N; i++){
            tmp = br.readLine().split(" ");
            workList.add(new Work(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }
        br.close();

        // Do greedy work
        for (int i = 0; i < N; i++){
            Work target = workList.poll();
            if (doList.size() < target.dday){
                doList.add(target.reward);
            }else if (doList.size() >= target.dday){
                if (doList.peek() < target.reward){
                    doList.poll();
                    doList.add(target.reward);
                }
            }
        }

        // Calculate answer
        while (!doList.isEmpty()){
            answer += doList.poll();
        }

        // Print answer and end program
        System.out.print(answer);
        return;
    }
}

// Work class
class Work implements Comparable<Work>{
    // Work variables
    int dday;
    int reward;
    
    // Work constructor
    public Work(int d, int r){
        dday = d;
        reward = r;
    }

    // Order guideline
    @Override
    public int compareTo(Work w){
        if (dday == w.dday){
            return w.reward - reward;
        }else return dday - w.dday;
    }
}