// streams/streams.Reduce.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package streams;

import java.util.*;
import java.util.stream.*;

class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "streams.Frobnitz(" + size + ")";
    }

    // streams.Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
//                .forEach(System.out::println);
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                .ifPresent(System.out::println);
    }
}
/* Output:
streams.Frobnitz(58)
streams.Frobnitz(55)
streams.Frobnitz(93)
streams.Frobnitz(61)
streams.Frobnitz(61)
streams.Frobnitz(29)
streams.Frobnitz(68)
streams.Frobnitz(0)
streams.Frobnitz(22)
streams.Frobnitz(7)
streams.Frobnitz(29)
*/
