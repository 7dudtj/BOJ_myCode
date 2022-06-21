import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  // set static variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long answer = 0;
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int m, v;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    // get jewel data
    Jewel[] j = new Jewel[N];
    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      m = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      j[i] = new Jewel(m, v);
    }

    // get bag data
    int[] bag = new int[K];
    for (int i = 0; i < K; i++){
      bag[i] = Integer.parseInt(br.readLine());
    }

    // sort data
    Arrays.sort(j, new Comparator<Jewel>(){
      // mass: asc, value: des
      @Override
      public int compare(Jewel j1, Jewel j2){
        if (j1.mass == j2.mass){
          return j2.value - j1.value;
        } else return j1.mass - j2.mass;
      }
    });
    // capacity: asc
    Arrays.sort(bag);

    // do main process
    int point = 0;
    // search all bags
    for (int i = 0, a = 0; i < K; i++){
      // push jewels to priority queue
      while (a < N && j[a].mass <= bag[i]){
        pq.add(j[a++].value);
      }

      if (!pq.isEmpty()) answer += pq.poll();
    }

    // print answer and end program
    System.out.println(answer);
    br.close();
    return;
  }
}

class Jewel{
  int mass;
  int value;
  public Jewel(int m, int v){
    mass = m;
    value = v;
  }
}