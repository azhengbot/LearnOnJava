package collections;// collections/LinkedListFeatures.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import reflection.pets.*;
import java.util.*;

public class LinkedListFeatures {
  public static void main(String[] args) {
    LinkedList<Pet> pets =
      new LinkedList<>(new PetCreator().list(5));
    System.out.println(pets);
    // Identical:
    System.out.println(
      "reflection.pets.getFirst(): " + pets.getFirst());
    System.out.println(
      "reflection.pets.element(): " + pets.element());
    // Only differs in empty-list behavior:
    System.out.println("reflection.pets.peek(): " + pets.peek());
    // Identical; remove and return the first element:
    System.out.println(
      "reflection.pets.remove(): " + pets.remove());
    System.out.println(
      "reflection.pets.removeFirst(): " + pets.removeFirst());
    // Only differs in empty-list behavior:
    System.out.println("reflection.pets.poll(): " + pets.poll());
    System.out.println(pets);
    pets.addFirst(new Rat());
    System.out.println("After addFirst(): " + pets);
    pets.offer(new PetCreator().get());
    System.out.println("After offer(): " + pets);
    pets.add(new PetCreator().get());
    System.out.println("After add(): " + pets);
    pets.addLast(new Hamster());
    System.out.println("After addLast(): " + pets);
    System.out.println(
      "reflection.pets.removeLast(): " + pets.removeLast());
  }
}
/* Output:
[Rat, Manx, Cymric, Mutt, Pug]
reflection.pets.getFirst(): Rat
reflection.pets.element(): Rat
reflection.pets.peek(): Rat
reflection.pets.remove(): Rat
reflection.pets.removeFirst(): Manx
reflection.pets.poll(): Cymric
[Mutt, Pug]
After addFirst(): [Rat, Mutt, Pug]
After offer(): [Rat, Mutt, Pug, Rat]
After add(): [Rat, Mutt, Pug, Rat, Rat]
After addLast(): [Rat, Mutt, Pug, Rat, Rat, Hamster]
reflection.pets.removeLast(): Hamster
*/
