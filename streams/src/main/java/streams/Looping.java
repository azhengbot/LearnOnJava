package streams;// streams/streams.Looping.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import static onjava.Repeat.*;

public class Looping {
  static void hi() { System.out.println("Hi!"); }
  public static void main(String[] args) {
    repeat(3, () -> System.out.println("streams.Looping!"));
    repeat(2, Looping::hi);
  }
}
/* Output:
streams.Looping!
streams.Looping!
streams.Looping!
Hi!
Hi!
*/
