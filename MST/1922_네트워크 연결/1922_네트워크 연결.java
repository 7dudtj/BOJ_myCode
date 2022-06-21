import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

// Kruskal MST
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M, a, b, c;
    Edge[] tree;
    int answer = 0;

    // get N and M
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    // set map
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++) adjList[i] = new LinkedList<>();

    // get Edges
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      if (a != b){
        Edge e = new Edge(a-1, b-1, c);
        adjList[a-1].add(e);
      }
    }

    // set Kruskal
    KruskalMST kmst = new KruskalMST(adjList, M);
    tree = kmst.mst();

    // make answer
    for (Edge e: tree){
      answer += e.weight;
    }

    // print answer and end progrma
    System.out.println(answer);
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int vertex, adjvertex; // 간선의 양끝 정점들
  int weight; // 간선의 가중치
  public Edge(int u, int v, int wt){
    vertex = u;
    adjvertex = v;
    weight = wt;
  }
}

// Node class
class Node{
  int parent;
  int rank;
  public Node(int newParent, int newRank){
    parent = newParent;
    rank = newRank;
  }
  public int getParent(){return parent;}
  public int getRank(){return rank;}
  public void setParent(int newParent){parent = newParent;}
  public void setRank(int newRank){rank = newRank;}
}

// UnionFind class
class UnionFind{
  protected Node[] a;
  // 생성자
  public UnionFind(Node[] iarray){
    a = iarray;
  }
  // i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다.
  // 경로압축
  protected int find(int i){
    if (i != a[i].getParent())
      a[i].setParent(find(a[i].getParent()));
    return a[i].getParent();  
  }
  // Union 연산
  public void union(int i, int j){
    int iroot = find(i);
    int jroot = find(j);
    if (iroot == jroot) return; // 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴
    // rank가 높은 루트노드가 승자가 된다.
    if (a[iroot].getRank() > a[jroot].getRank())
      a[jroot].setParent(iroot); // iroot가 승자
    else if (a[iroot].getRank() < a[jroot].getRank())
      a[iroot].setParent(jroot); // jroot가 승자
    else{
      a[jroot].setParent(iroot); // 둘 중에 하나 임의로 승자
      int t = a[iroot].getRank() + 1;
      a[iroot].setRank(t); // iroot의 rank 1 증가
    }
  }
  // 간선의 양쪽 끝 정점들이 동일한 집합에 속해 있는지 검사
  public boolean isConnected(int i, int j){
    return find(i) == find(j);
  }
}

// KruskalMST class
class KruskalMST{
  int N, M; // 그래프 정점, 간선의 수
  List<Edge>[] graph;
  UnionFind uf; // Union-Find 연산을 사용하기 위해
  Edge[] tree;
  // weight를 기준으로 우선순위큐를 사용하기 위해
  static class Weight_Comparison implements Comparator<Edge>{
    public int compare(Edge e, Edge f){
      if (e.weight > f.weight)  
        return 1;
      else if (e.weight < f.weight)
        return -1;
      return 0;  
    }
  }
  public KruskalMST(List<Edge>[] adjList, int numOfEdges){
    N = adjList.length;
    M = numOfEdges;
    graph = adjList;
    Node[] a = new Node[N];
    for (int i = 0; i < N; i++) a[i] = new Node(i, 1);
    uf = new UnionFind(a); // Union-Find 연산을 사용하기 위해
    tree = new Edge[N-1];
  }
  // Kruskal 알고리즘
  public Edge[] mst(){
    // 우선순위큐를 weight 기준으로 구성하기 위해
    // 자바 라이브러리의 우선순위큐 사용
    Weight_Comparison BY_WEIGHT = new Weight_Comparison();
    // 우선순위큐의 크기로 M(간선의 수)을 지정, BY_WEIGHT는 line 27의 Comparator
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(M, BY_WEIGHT);
    for (int i = 0; i < N; i++){
      for (Edge e: graph[i]){
        pq.add(e); // edgeArray의 간선 객체를 pq에 삽입
      }
    }
    int count = 0;
    while (!pq.isEmpty() && count < N-1){
      Edge e = pq.poll(); // 최소 가중치를 가진 간선을 pq에서 제거하여 가져옴
      int u = e.vertex; // 가져온 간선의 한 쪽 정점
      int v = e.adjvertex; // 가져온 간선의 다른 한 쪽 정점
      if (!uf.isConnected(u, v)){ // u와 v가 각각 다른 집합에 속해 있으면
        uf.union(u, v); // u가 속한 집합과 v가 속한 집합의 합집합 수행
        tree[count++] = e; // e를 MST의 간선으로서 tree에 추가
      }
    }
    return tree;
  }
}
