import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    boolean[] truth = new boolean[N+1];
    int answer = 0;
    
    // get info about knowing truth
    st = new StringTokenizer(br.readLine(), " ");
    int T = Integer.parseInt(st.nextToken());
    int[] truthList = new int[T];
    for (int i = 0; i < T; i++) truthList[i] = Integer.parseInt(st.nextToken());
    for (int i = 0; i < T; i++) truth[truthList[i]] = true;

    // get party
    List<Integer>[] adjList = new List[M];
    for (int i = 0; i < M; i++) adjList[i] = new LinkedList<>();
    int j;
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      j = Integer.parseInt(st.nextToken());
      for (int k = 0; k < j; k++){
        adjList[i].add(Integer.parseInt(st.nextToken()));
      }
    }

    // if no one knows truth
    if (T == 0){
      System.out.println(M);
      br.close();
      return;
    }

    // check party
    boolean know;
    for (int k = 0; k < M; k++){
      for (int i = 0; i < M; i++){
        know = false;
        for (Integer a: adjList[i]){
          if (truth[a]) {
            know = true;
            break;
          }
        }
        if (know){
          for (Integer a: adjList[i]){
            truth[a] = true;
          }
        }
      }
    }

    // check if we can tell lie
    for (int i = 0; i < M; i++){
      boolean lie = true;
      for (Integer a: adjList[i]){
        if (truth[a]){
          lie = false;
          break;
        }
      }
      if (lie) answer++;
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}