// functional/TriFunctionTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class TriFunctionTest {
    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Object> tf =
                TriFunctionTest::f;
        System.out.println(tf.apply(1,3,5));
        tf = (i, l, d) -> 12;
        System.out.println(tf.apply(1,3,5));

    }
}
