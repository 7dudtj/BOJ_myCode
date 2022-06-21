import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    boolean a = false, b = false, c = false;
    StringBuilder sb = new StringBuilder();

    // search
    for (int i = 0; i < S.length(); i++){
      if (S.substring(i,i+1).equals("A")) a = true;
      if (S.substring(i,i+1).equals("B")) b = true;
      if (S.substring(i,i+1).equals("C")) c = true;
    }

    // make answer
    if (a == true){
      for (int i = 0; i < S.length(); i++){
        if (S.substring(i,i+1).equals("B") || S.substring(i,i+1).equals("C") || 
        S.substring(i,i+1).equals("D") || S.substring(i,i+1).equals("F")){
          sb.append("A");
        }else sb.append(S.substring(i,i+1));
      }
    }else if (a == false && b == true){
      for (int i = 0; i < S.length(); i++){
        if (S.substring(i,i+1).equals("C") || 
        S.substring(i,i+1).equals("D") || S.substring(i,i+1).equals("F")){
          sb.append("B");
        }else sb.append(S.substring(i,i+1));
      }
    }else if (a == false && b == false && c == true){
      for (int i = 0; i < S.length(); i++){
        if (S.substring(i,i+1).equals("D") || S.substring(i,i+1).equals("F")){
          sb.append("C");
        }else sb.append(S.substring(i,i+1));
      }
    }else{
      for (int i = 0; i < S.length(); i++){
        sb.append("A");
      }
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }
}