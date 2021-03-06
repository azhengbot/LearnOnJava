// concurrent/CompletableOperations.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

//import static onjava.CompletableUtilities.*;
//import static CompletableUtilities.*;
import java.util.concurrent.*;

public class CompletableOperations {
  static CompletableFuture<Integer> cfi(int i) {
    return CompletableFuture.completedFuture(
        Integer.valueOf(i));
  }

  public static void main(String[] args) {
    CompletableUtilities.showr(cfi(1)); // Basic test
    CompletableUtilities.voidr(cfi(2).runAsync(() -> System.out.println("runAsync")));
    CompletableUtilities.voidr(cfi(3).thenRunAsync(() -> System.out.println("thenRunAsync")));
    CompletableUtilities.voidr(CompletableFuture.runAsync(() -> System.out.println("runAsync is static")));
    CompletableUtilities.showr(CompletableFuture.supplyAsync(() -> 99));
    CompletableUtilities.voidr(cfi(4).thenAcceptAsync(i -> System.out.println("thenAcceptAsync: " + i)));
    CompletableUtilities.showr(cfi(5).thenApplyAsync(i -> i + 42));
    CompletableUtilities.showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));
    CompletableFuture<Integer> c = cfi(7);
    c.obtrudeValue(111);
    CompletableUtilities.showr(c);
    CompletableUtilities.showr(cfi(8).toCompletableFuture());
    c = new CompletableFuture<>();
    c.complete(9);
    CompletableUtilities.showr(c);
    c = new CompletableFuture<>();
    c.cancel(true);
    System.out.println("cancelled: " +
        c.isCancelled());
    System.out.println("completed exceptionally: " +
        c.isCompletedExceptionally());
    System.out.println("done: " + c.isDone());
    System.out.println(c);
    c = new CompletableFuture<>();
    System.out.println(c.getNow(777));
    c = new CompletableFuture<>();
    c.thenApplyAsync(i -> i + 42)
        .thenApplyAsync(i -> i * 12);
    System.out.println("dependents: " +
        c.getNumberOfDependents());
    c.thenApplyAsync(i -> i / 2);
    System.out.println("dependents: " +
        c.getNumberOfDependents());
  }
}
/*
 * Output:
 * 1
 * runAsync
 * thenRunAsync
 * runAsync is static
 * 99
 * thenAcceptAsync: 4
 * 47
 * 105
 * 111
 * 8
 * 9
 * cancelled: true
 * completed exceptionally: true
 * done: true
 * java.util.concurrent.CompletableFuture@1629346[Complete
 * d exceptionally]
 * 777
 * dependents: 1
 * dependents: 2
 */
