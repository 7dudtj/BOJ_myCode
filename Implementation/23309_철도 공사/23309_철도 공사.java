import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] plist = new int[1000001];
    int[] nlist = new int[1000001];

    // get stations
    int prev, here, next, first, last;
    // N == 1
    if (N == 1){
      here = Integer.parseInt(br.readLine());
      plist[here] = here;
      nlist[here] = here;
    }
    // N == 2
    else if (N == 2){
      st = new StringTokenizer(br.readLine(), " ");
      prev = Integer.parseInt(st.nextToken());
      here = Integer.parseInt(st.nextToken());
      plist[prev] = here;
      nlist[prev] = here;
      plist[here] = prev;
      nlist[here] = prev;
    }
    // N >= 3
    else{
      st = new StringTokenizer(br.readLine(), " ");
      prev = Integer.parseInt(st.nextToken());
      here = Integer.parseInt(st.nextToken());
      first = prev;
      nlist[first] = here;
      for (int i = 0; i < N-2; i++){
        // find last station
        if (i == N-3){
          last = Integer.parseInt(st.nextToken());
          plist[here] = prev;
          nlist[here] = last;
          plist[last] = here;
          nlist[last] = first;
          plist[first] = last;
        }
        // else
        else{
          next = Integer.parseInt(st.nextToken());
          plist[here] = prev;
          nlist[here] = next;
          prev = here;
          here = next;
        }
      }
    }

    // do commands
    String code;
    int a, b, before, after, bb, aa;
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      code = st.nextToken();
      a = Integer.parseInt(st.nextToken());
      // BN
      if (code.equals("BN")){
        b = Integer.parseInt(st.nextToken());
        after = nlist[a];
        sb.append(after).append('\n');
        nlist[a] = b;
        plist[after] = b;
        plist[b] = a;
        nlist[b] = after;
      }
      // BP
      else if (code.equals("BP")){
        b = Integer.parseInt(st.nextToken());
        before = plist[a];
        sb.append(before).append('\n');
        plist[a] = b;
        nlist[before] = b;
        plist[b] = before;
        nlist[b] = a;
      }
      // CN
      else if (code.equals("CN")){
        after = nlist[a];
        aa = nlist[after];
        sb.append(after).append('\n');
        nlist[a] = aa;
        plist[aa] = a;
        plist[after] = 0;
        nlist[after] = 0;
      }
      // CP
      else{
        before = plist[a];
        bb = plist[before];
        sb.append(before).append('\n');
        plist[a] = bb;
        nlist[bb] = a;
        plist[before] = 0;
        nlist[before] = 0;
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}