import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

public class Main {
  // set needed variables
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int input;
    Entry[] a = new Entry[N+1];
    BHeap bh = new BHeap(a, 0);

    // do process
    for (int i = 0; i < N; i++){
      input = Integer.parseInt(br.readLine());

      // if input is 0
      if (input == 0){
        if (bh.size() == 0) System.out.println(0);
        else System.out.println(bh.deleteMin().getKey());
      }
      // if input is not 0
      else{
        bh.insert(input);
      }
    }

    // end program
    br.close();
    return;
  }
}

// Entry class
class Entry {
  private int ky;
  // 생성자
  public Entry(int newKey){
    ky = newKey;
  }
  // get 메소드와 set 메소드들
  public int getKey(){return ky;}
  public void setKey(int newKey){ky = newKey;}
}

// Binary_Min_Heap class
class BHeap {
  private Entry[] a; // a[0]은 사용 안함
  private int N; // 힙의 크기, 즉, 힙에 있는 항목 수
  // 생성자
  public BHeap(Entry[] harray, int initialSize){
    a = harray;
    N = initialSize;
  }
  public int size(){return N;} // 힙의 크기 리턴
  // 키 비교
  private boolean greater(int i, int j){
    if (Math.abs(a[j].getKey()) == Math.abs(a[i].getKey())){
      return Integer.valueOf(a[j].getKey()).compareTo(Integer.valueOf(a[i].getKey())) < 0;
    }

    return Integer.valueOf(Math.abs(a[j].getKey())).compareTo(Integer.valueOf(Math.abs(a[i].getKey()))) < 0;
  }
  // a[i]와 a[j]를 교환
  private void swap(int i, int j){
    Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
  // 초기 힙 만들기
  public void createHeap(){
    for (int i = N/2; i > 0; i--){
      downheap(i);
    }
  }
  private void downheap(int i){ // i는 현재 노드의 인덱스
    while (2*i <= N){ // i의 왼쪽 자식노드가 힙에 있으면
      int k = 2*i; // k는 왼쪽 자식노드의 인덱스
      if (k < N && greater(k, k+1)) k++; // k가 승자의 인덱스가됨
      if (!greater(i,k)) break; // 현재 노드가 자식 승자와 같거나 작으면 루프를 중단하고
      swap(i, k); // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
      i = k; // 자식 승자가 현재 노드가 되어 다시 반복하기 위해
    }
  }
  // 새로운 항목 삽입
  public void insert(int newKey){
    Entry temp = new Entry(newKey); // Entry 생성
    a[++N] = temp; // 새로운 키(항목)를 배열 마지막 항목 다음에 저장
    upheap(N); // 위로 올라가며 힙속성 회복시키기 위해
  }
  private void upheap(int j){ // j는 현재 노드의 인덱스
    while (j > 1 && greater(j/2, j)){ // 현재 노드가 루트가 아니고 동시에 부모가 크면
      swap(j/2, j); // 부모와 현재 노드 교환
      j = j/2; // 부모가 현재 노드가 되어 다시 반복하기 위해
    }    
  }
  // 최솟값 삭제
  public Entry deleteMin(){
    Entry min = a[1]; // a[1]의 최솟값을 min으로 지정하여 리턴
    swap(1, N--); // 힙의 마지막 항목과 교환하고 힙 크기 1 감소
    a[N+1] = null; // 마지막 항목을 null로 처리
    downheap(1); // 힙속성을 회복시키기 위해
    return min;
  }
}
