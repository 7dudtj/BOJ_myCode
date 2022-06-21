import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;

// KruskalMST
public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int m, n;
    int x, y, z;
    int total, min, save;
    List<Edge>[] adjList;
    KruskalMST kmst;

    // do process
    while (true){
      // get m & n
      st = new StringTokenizer(br.readLine(), " ");
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      if (m == 0 && n == 0) break; // end program

      // reset components
      adjList = new List[m];
      for (int i = 0; i < m; i++) adjList[i] = new LinkedList<>();
      total = min = save = 0;

      // get Edges and make adjList
      for (int i = 0; i < n; i++){
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        adjList[x].add(new Edge(x, y, z));
        total += z;
      }

      // reset and do KruskalMST
      kmst = new KruskalMST(adjList, n);
      kmst.mst();

      // get and print answer
      for (Edge e: kmst.tree) min += e.weight;
      save = total - min;
      System.out.println(save);
    }

    // end program
    br.close();
    return;
  }
}

// Edge class
class Edge{
  int vertex, adjvertex;
  int weight;
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
    if (iroot == jroot) return;
    if (a[iroot].getRank() > a[jroot].getRank())
      a[jroot].setParent(iroot);
    else if (a[iroot].getRank() < a[jroot].getRank())
      a[iroot].setParent(jroot);
    else{
      a[jroot].setParent(iroot);
      int t = a[iroot].getRank() + 1;
      a[iroot].setRank(t);
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
    uf = new UnionFind(a);
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
        pq.add(e);
      }
    }
    int count = 0;
    while (!pq.isEmpty() && count < N-1){
      Edge e = pq.poll();
      int u = e.vertex;
      int v = e.adjvertex;
      if (!uf.isConnected(u, v)){
        uf.union(u, v);
        tree[count++] = e;
      }
    }
    return tree;
  }
  // 최소신장트리 보기
  public void showTree(){
    for (Edge e: tree) System.out.print(e.weight+" ");
  }
}

