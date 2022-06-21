import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
  // set needed variables
  static int[] parents;
  static ArrayList<Integer>[] childs;
  static int answer = 0;

  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, node, root = 0, delete;
    
    // get N
    N  = Integer.parseInt(br.readLine());

    // make tree
    parents = new int[N];
    childs = new ArrayList[N];
    for (int i = 0; i < N; i++) childs[i] = new ArrayList<Integer>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++){
      node = Integer.parseInt(st.nextToken());
      // find root
      if (node == -1){
        parents[i] = i;
        root = i;
      }
      // not root
      else{
        parents[i] = node;
        childs[node].add(i);
      }
    }

    // get delete node
    delete = Integer.parseInt(br.readLine());

    // delete process
    // if delete node is root
    if (delete == root) {
      System.out.println(0);
      br.close();
      return;
    }
    // delete node is not root
    int delparent = parents[delete];
    for (int i = 0; i < childs[delparent].size(); i++){
      if (childs[delparent].get(i) == delete){
        childs[delparent].remove(i);
        break;
      }
    }

    // find leaf node
    findLeaf(root);

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }

  public static void findLeaf(int root){
    // leaf node 탐색
    if (childs[root].size() == 0){
      answer++;
      return;
    }
    // 자식에 대해서도 수행
    for (int i = 0; i < childs[root].size(); i++){
      findLeaf(childs[root].get(i));
    }
  }
}
