import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N];
    StringBuilder sb = new StringBuilder();
    BucketSort bs = new BucketSort();
    
    // get list
    for (int i = 0; i < N; i++){
      list[i] = Integer.parseInt(br.readLine());
    }

    // Merge Sort: O(N)
    bs.sort(list, 10001);

    // print answer and end program
    for (int i = 0; i < N; i++){
      sb.append(list[i]).append('\n');
    }
    System.out.println(sb);
    br.close();
    return;  
  }
}

class BucketSort{
  public void sort(int[] a, int R){
    int[] bucket = new int[R];
    for (int i = 0; i < R; i++) bucket[i] = 0; // 초기화
    for (int i = 0; i < a.length; i++) bucket[a[i]]++; // 1단계: 빈도수 계산
    // 2단계: 순차적으로 버킷의 인덱스를 배열 a에 저장
    int j = 0; // j는 다음 저장될 배열 a 원소의 인덱스
    for (int i = 0; i < R; i++){
      while ((bucket[i]--) != 0) // 버킷 i에 저장된 빈도수가 0이 될 때까지
        a[j++] = i; // 버킷 인덱스 i를 저장
    }
  }
}
