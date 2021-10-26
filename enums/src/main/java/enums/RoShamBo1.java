package enums;// enums/enums.RoShamBo1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstration of multiple dispatching
// {java enums.enums.RoShamBo1}

import java.util.*;

public class RoShamBo1 {
  static final int SIZE = 20;
  private static Random rand = new Random(47);
  public static Item newItem() {
    switch(rand.nextInt(3)) {
      default:
      case 0: return new Scissors();
      case 1: return new Paper();
      case 2: return new Rock();
    }
  }
  public static void match(Item a, Item b) {
    System.out.println(
      a + " vs. " + b + ": " +  a.compete(b));
  }
  public static void main(String[] args) {
    for(int i = 0; i < SIZE; i++)
      match(newItem(), newItem());
  }
}
/* Output:
enums.Rock vs. enums.Rock: DRAW
enums.Paper vs. enums.Rock: WIN
enums.Paper vs. enums.Rock: WIN
enums.Paper vs. enums.Rock: WIN
enums.Scissors vs. enums.Paper: WIN
enums.Scissors vs. enums.Scissors: DRAW
enums.Scissors vs. enums.Paper: WIN
enums.Rock vs. enums.Paper: LOSE
enums.Paper vs. enums.Paper: DRAW
enums.Rock vs. enums.Paper: LOSE
enums.Paper vs. enums.Scissors: LOSE
enums.Paper vs. enums.Scissors: LOSE
enums.Rock vs. enums.Scissors: WIN
enums.Rock vs. enums.Paper: LOSE
enums.Paper vs. enums.Rock: WIN
enums.Scissors vs. enums.Paper: WIN
enums.Paper vs. enums.Scissors: LOSE
enums.Paper vs. enums.Scissors: LOSE
enums.Paper vs. enums.Scissors: LOSE
enums.Paper vs. enums.Scissors: LOSE
*/
