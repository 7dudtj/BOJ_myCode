/*
이분 탐색 / Binary Search
*/
public class Main{
  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    int target = 3;

    doBinarySearch(target, arr);
  }

  public static void doBinarySearch(int target, int[] arr){
    int left = 0;
    int right = arr.length - 1;

    while (right >= left){
      int mid = (left + right) / 2;

      if (target == arr[mid]){
        System.out.println(target+" is found at index "+mid);}
      if (target < arr[mid]){
        right = mid - 1;}
      else {
        left = mid + 1;} 
    }
  }
}
