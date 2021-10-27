package reflection;// reflection/reflection.SweetShop.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Examination of the way the class loader works

class Cookie {
  static { System.out.println("Loading reflection.Cookie"); }
}

class Gum {
  static { System.out.println("Loading reflection.Gum"); }
}

class Candy {
  static { System.out.println("Loading reflection.Candy"); }
}

public class SweetShop {
  public static void main(String[] args) {
    System.out.println("inside main");
    new Candy();
    System.out.println("After creating reflection.Candy");
    try {
      Class.forName("reflection.Gum");
    } catch(ClassNotFoundException e) {
      System.out.println("Couldn't find reflection.Gum");
    }
    System.out.println("After Class.forName(\"reflection.Gum\")");
    new Cookie();
    System.out.println("After creating reflection.Cookie");
  }
}
/* Output:
inside main
Loading reflection.Candy
After creating reflection.Candy
Loading reflection.Gum
After Class.forName("reflection.Gum")
Loading reflection.Cookie
After creating reflection.Cookie
*/
