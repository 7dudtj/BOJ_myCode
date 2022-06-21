import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    if (input.equals("N") || input.equals("n")) System.out.print("Naver D2");
    else System.out.print("Naver Whale");
    br.close();
    return;
  }
}