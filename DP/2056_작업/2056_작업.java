import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] cost = new int[N];
    List<Integer>[] work = new List[N];
    for (int i = 0; i < N; i++) work[i] = new LinkedList<>();
    int[] answer;

    // get cost&work data
    for (int i = 0; i < N; i++){
      int n;
      st = new StringTokenizer(br.readLine(), " ");
      // get cost
      cost[i] = Integer.parseInt(st.nextToken());
      // get wort map
      n = Integer.parseInt(st.nextToken());
      for (int j = 0; j < n; j++){
        work[i].add(Integer.parseInt(st.nextToken()) - 1);
      }
    }

    // do topological Sort
    TopologicalSort ts = new TopologicalSort(work, cost);
    answer = ts.findAnswer();

    // print answer and end program
    Arrays.sort(answer);
    System.out.println(answer[N-1]);
    br.close();
    return;
  }
}

// Topological Sort class
class TopologicalSort{
  // class variables
  int N;
  int[] time;
  List<Integer>[] adjList;
  int[] answer;

  // constructor
  public TopologicalSort(List<Integer>[] work, int[] cost){
    N = work.length;
    adjList = work;
    time = cost;
    answer = new int[N];
  }

  // find answer
  public int[] findAnswer(){
    for (int i = 0; i < N; i++){
      if (answer[i] == 0){
        answer[i] = tsort(i);
      }
    }
    return answer;
  }

  // topological Sort
  public int tsort(int i){
    int max = Integer.MIN_VALUE;
    for (int v: adjList[i]){
      int tmp;
      if (answer[v] != 0) tmp = answer[v];
      else answer[v] = tmp = tsort(v);
      if (tmp > max) max = tmp;
    }
    if (max == Integer.MIN_VALUE) return time[i];
    else return max + time[i];
  }
}
