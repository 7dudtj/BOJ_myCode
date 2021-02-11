import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Prim MST
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int V, E, A, B, C;
    int[] tree;
    int answer = 0;

    // get V and E
    st = new StringTokenizer(br.readLine(), " ");
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    // set map
    List<Edge>[] adjList = new List[V];
    for (int i = 0; i < V; i++) adjList[i] = new LinkedList<>();

    // get Edges
    for (int i = 0; i < E; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      Edge e1 = new Edge(B-1, C); Edge e2 = new Edge(A-1, C);
      adjList[A-1].add(e1); adjList[B-1].add(e2);
    }

    // set PrimMST
    PrimMST pmst = new PrimMST(adjList);
    tree = pmst.mst(0);

    // get answer
    for (int i = 1; i < V; i++){
      for (Edge e: adjList[i]){
        if (e.adjvertex == tree[i]) answer += e.weight;
      }
    }

    // print answer and end progrma
    System.out.println(answer);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int adjvertex; // 간선의 다른 한쪽의 끝 정점
  int weight; // 간선의 가중치
  public Edge(int v, int wt){
    adjvertex = v;
    weight = wt;
  }
}

// PrimMST class
class PrimMST{
  int N; // 그래프 정점의 수
  List<Edge>[] graph;
  int sum = 0;

  // 생성자
  public PrimMST(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
  }

  // Prim 알고리즘, s는 시작정점
  public int[] mst(int s){
    boolean[] visited = new boolean[N]; // 방문된 정점은 true로
    int[] D = new int[N];
    int[] previous = new int[N]; // 최소신장트리의 간선으로 확정될 때 간선의 다른 쪽 (트리의)꿑점
    for (int i = 0; i < N; i++){ // 초기화
      visited[i] = false;
      previous[i] = -1;
      D[i] = Integer.MAX_VALUE; // D[i]를 최댓값으로 초기화
    }
    previous[s] = 0; // 시작정점의 s의 관련 정보 초기화
    D[s] = 0;

    for (int k = 0; k < N; k++){ // 방문안된 정점들의 D 원소들 중에서 최솟값가진 정점 찾기
      int minVertex = -1;
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < N; j++){
        if ((!visited[j]) && (D[j] < min)){
          min = D[j];
          minVertex = j;
        }
      }
      //System.out.println(minVertex); // for test
      visited[minVertex] = true;
      for (Edge i: graph[minVertex]){ // minVertex에 인접한 각 정점의 D 원소 갱신
        if (!visited[i.adjvertex]){ // 트리에 아직 포함 안된 정점이라면
          int currentDist = D[i.adjvertex];
          int newDist = i.weight;
          if (newDist < currentDist){
            D[i.adjvertex] = newDist; // minVertex와 연결된 정점들의 D 원소 갱신
            previous[i.adjvertex] = minVertex; // 트리 간선 추출을 위해
            sum += i.weight;
          }
        }
      }
    }
    return previous; // 최소신장트리 간선 정보 리턴
  }
}
