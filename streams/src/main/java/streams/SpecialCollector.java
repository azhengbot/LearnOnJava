// streams/streams.SpecialCollector.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package streams;
import java.util.*;

public class SpecialCollector {
  public static void
  main(String[] args) throws Exception {
    ArrayList<String> words =
      FileToWords.stream("streams/Cheese.dat")
        .collect(ArrayList::new,
                 ArrayList::add,
                 ArrayList::addAll);
    words.stream()
      .filter(s -> s.equals("cheese"))
      .forEach(System.out::println);
  }
}
/* Output:
cheese
cheese
*/
