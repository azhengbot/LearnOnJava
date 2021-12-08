// streams/streams.Informational.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package streams;

public class Informational {
  public static void
  main(String[] args) throws Exception {
      System.out.println(
        FileToWords.stream("streams/Cheese.dat").count());
      System.out.println(
        FileToWords.stream("streams/Cheese.dat")
        .min(String.CASE_INSENSITIVE_ORDER)
        .orElse("NONE"));
      System.out.println(
        FileToWords.stream("streams/Cheese.dat")
        .max(String.CASE_INSENSITIVE_ORDER)
        .orElse("NONE"));
  }
}
/* Output:
32
a
you
*/
