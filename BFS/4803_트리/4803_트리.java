import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  // set static variables
  static List<Integer>[] adjList;
  static int n, m;
  static boolean[] visited;
  public static void main(String args[]) throws IOException  {
    // set variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int a, b, trees, caseNum = 0;;
    String s;

    // do testcases
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    while (!(n==0 && m==0)){
      // set variables
      adjList = new List[n+1];
      for (int i = 1; i <= n; i++) adjList[i] = new LinkedList<>();
      trees = 0;
      visited = new boolean[n+1];
      caseNum++;

      // get map
      for (int i = 0; i < m; i++){
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        adjList[a].add(b);
        adjList[b].add(a);
      }

      // find trees
      for (int i = 1; i <= n; i++){
        if (!visited[i]) {
          trees += bfs(i);
        }  
      }

      // store answer
      if (trees == 0) s = "Case "+caseNum+": No trees.";
      else if (trees == 1) s = "Case "+caseNum+": There is one tree.";
      else s = "Case "+caseNum+": A forest of "+trees+" trees.";
      sb.append(s).append('\n');

      // get next testcase
      st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // bfs function for finding tree
  private static int bfs(int v){
    Queue<Integer> q = new LinkedList<>();
    int nodeNum = 0, edgeNum = 0, tmp;
    q.add(v);
    visited[v] = true;

    while(!q.isEmpty()){
      tmp = q.poll();
      nodeNum++;

      for (Integer i: adjList[tmp]){
        edgeNum++;
        if (!visited[i]){
          visited[i] = true;
          q.add(i);
        }
      }
    }
    return (edgeNum/2)+1 == nodeNum? 1: 0;
  }
}