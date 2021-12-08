// streams/streams.StreamOfOptionals.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package streams;
import java.util.*;

public class StreamOfOptionals {
  public static void main(String[] args) {
    Signal.stream()
      .limit(10)
      .forEach(System.out::println);
    System.out.println(" ---");
    Signal.stream()
      .limit(10)
      .filter(Optional::isPresent)
      .map(Optional::get)
      .forEach(System.out::println);
  }
}
/* Output:
Optional[streams.Signal(dash)]
Optional[streams.Signal(dot)]
Optional[streams.Signal(dash)]
Optional.empty
Optional.empty
Optional[streams.Signal(dash)]
Optional.empty
Optional[streams.Signal(dot)]
Optional[streams.Signal(dash)]
Optional[streams.Signal(dash)]
 ---
streams.Signal(dot)
streams.Signal(dot)
streams.Signal(dash)
streams.Signal(dash)
*/
