// collections/AddingGroups.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Adding groups of elements to Collection object
package collections;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("collection: " + collection);
        Integer[] moreInts = {6, 7, 8, 9, 10};
        System.out.println("moreInts: " + moreInts);
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        System.out.println("list2: " + list);
        // OK -- modify an element
        // list.add(21); // Runtime error; the underlying
        // array cannot be resized.
    }
}
