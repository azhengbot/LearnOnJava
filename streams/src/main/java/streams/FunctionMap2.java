// streams/streams.FunctionMap2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Different input and output types
package streams;
import java.util.stream.*;

class Numbered {
  final int n;
  Numbered(int n) { this.n = n; }
  @Override public String toString() {
    return "streams.Numbered(" + n + ")";
  }
}

class FunctionMap2 {
  public static void main(String[] args) {
    Stream.of(1, 5, 7, 9, 11, 13)
      .map(Numbered::new)
      .forEach(System.out::println);
  }
}
/* Output:
streams.Numbered(1)
streams.Numbered(5)
streams.Numbered(7)
streams.Numbered(9)
streams.Numbered(11)
streams.Numbered(13)
*/
