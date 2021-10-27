package reflection;// reflection/reflection.ClassInitialization.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

class Initable {
  static final int STATIC_FINAL = 47;
  static final int STATIC_FINAL2 =
    ClassInitialization.rand.nextInt(1000);
  static {
    System.out.println("Initializing reflection.Initable");
  }
}

class Initable2 {
  static int staticNonFinal = 147;
  static {
    System.out.println("Initializing reflection.Initable2");
  }
}

class Initable3 {
  static int staticNonFinal = 74;
  static {
    System.out.println("Initializing reflection.Initable3");
  }
}

public class ClassInitialization {
  public static Random rand = new Random(47);
  public static void
  main(String[] args) throws Exception {
    Class initable = Initable.class;
    System.out.println("After creating reflection.Initable ref");
    // Does not trigger initialization:
    System.out.println(Initable.STATIC_FINAL);
    // Triggers initialization:
    System.out.println(Initable.STATIC_FINAL2);
    // Triggers initialization:
    System.out.println(Initable2.staticNonFinal);
    Class initable3 = Class.forName("reflection.Initable3");
    System.out.println("After creating reflection.Initable3 ref");
    System.out.println(Initable3.staticNonFinal);
  }
}
/* Output:
After creating reflection.Initable ref
47
Initializing reflection.Initable
258
Initializing reflection.Initable2
147
Initializing reflection.Initable3
After creating reflection.Initable3 ref
74
*/
