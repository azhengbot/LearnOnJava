package streams;// streams/streams.Bubbles.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.stream.*;

public class Bubbles {
  public static void main(String[] args) {
    Stream.generate(Bubble::bubbler)
      .limit(5)
      .forEach(System.out::println);
  }
}
/* Output:
streams.Bubble(0)
streams.Bubble(1)
streams.Bubble(2)
streams.Bubble(3)
streams.Bubble(4)
*/
