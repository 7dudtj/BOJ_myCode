import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A, B;
    List<Integer>[] subject = new List[N];
    for (int i = 0; i < N; i++) subject[i] = new LinkedList<>();
    int[] answer = new int[N];
    StringBuilder sb = new StringBuilder();

    // get subject map
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      subject[B-1].add(A-1);
    }

    // do topological sort
    TopologicalSort ts = new TopologicalSort(subject);
    answer = ts.getAnswer();

    // print answer
    for (int i = 0; i < N; i++){
      sb.append(answer[i]).append(" ");
    }
    System.out.print(sb);

    // end program
    br.close();
    return;
  }
}

// TopologicalSort class
class TopologicalSort{
  // set class variables
  int N;
  List<Integer>[] adjList;
  int[] answer;

  // constructor
  public TopologicalSort(List<Integer>[] graph){
    N = graph.length;
    adjList = graph;
    answer = new int[N];
  }

  // get answer
  public int[] getAnswer(){
    for (int i = 0; i < N; i++){
      if (answer[i] == 0)
        answer[i] = tsort(i);
    }
    return answer;
  }

  // topological sort with dp
  public int tsort(int i){
    int max = Integer.MIN_VALUE;
    for (int v: adjList[i]){
      int tmp;
      if (answer[v] != 0) tmp = answer[v];
      else answer[v] = tmp = tsort(v);
      if (tmp > max) max = tmp;
    }
    if (max == Integer.MIN_VALUE) return 1;
    else return max + 1;
  }
}
