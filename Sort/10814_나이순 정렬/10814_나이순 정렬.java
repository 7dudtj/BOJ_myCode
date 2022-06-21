import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Person[] p = new Person[N];

    // get data
    for (int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      p[i] = new Person(age, name);
    }

    // sort data
    Arrays.sort(p, new Comparator<Person>(){
      // sort by age
      @Override
      public int compare(Person p1, Person p2){
        return p1.age - p2.age;
      }
    });

    // set StringBuilder
    StringBuilder sb = new StringBuilder();

    // make StringBuilder
    for (int i = 0; i < N; i++){
      // 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString()이 출력됨
      sb.append(p[i]);
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  public static class Person{
    // data
    int age;
    String name;

    // constructor
    public Person(int age, String name){
      this.age = age;
      this.name = name;
    }

    @Override
    public String toString(){
      return age + " " + name + '\n';
    }
  }
}
