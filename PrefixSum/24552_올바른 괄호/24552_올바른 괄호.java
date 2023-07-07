import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine(); br.close();
    String s;
    int l=0, r=0, ll=0, rr=0;

    // exception handling
    if (input.substring(0,1).equals(")") || 
    input.substring(input.length()-1).equals("(")){
      System.out.print(1);
      return;
    }

    // coutn left and right
    for (int i = 0; i < input.length(); i++){
      s = input.substring(i, i+1);
      if (s.equals("(")) l++;
      else r++;
    }

    // search from left to right
    if (l > r){
      for (int i = 0; i < input.length(); i++){
        s = input.substring(i, i+1);
        if (s.equals("(")) ll++;
        else rr++;
        if (ll == rr){
          ll = 0;
          rr = 0;
        }
      }
      System.out.print(ll);
    }
    // search from right to left
    else {
      for (int i = input.length()-1; i >= 0; i--){
        s = input.substring(i, i+1);
        if (s.equals("(")) ll++;
        else rr++;
        if (ll == rr){
          ll = 0;
          rr = 0;
        }
      }
      System.out.print(rr);
    }
    return;
  }
}