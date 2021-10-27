package reflection;// reflection/reflection.FamilyVsExactType.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The difference between instanceof and class
// {java reflection.reflection.FamilyVsExactType}

class Base {}
class Derived extends Base {}

public class FamilyVsExactType {
  static void test(Object x) {
    System.out.println(
      "Testing x of type " + x.getClass());
    System.out.println(
      "x instanceof reflection.Base " + (x instanceof Base));
    System.out.println(
      "x instanceof reflection.Derived " + (x instanceof Derived));
    System.out.println(
      "reflection.Base.isInstance(x) " + Base.class.isInstance(x));
    System.out.println(
      "reflection.Derived.isInstance(x) " +
      Derived.class.isInstance(x));
    System.out.println(
      "x.getClass() == reflection.Base.class " +
      (x.getClass() == Base.class));
    System.out.println(
      "x.getClass() == reflection.Derived.class " +
      (x.getClass() == Derived.class));
    System.out.println(
      "x.getClass().equals(reflection.Base.class)) "+
      (x.getClass().equals(Base.class)));
    System.out.println(
      "x.getClass().equals(reflection.Derived.class)) " +
      (x.getClass().equals(Derived.class)));
  }
  public static void main(String[] args) {
    test(new Base());
    test(new Derived());
  }
}
/* Output:
Testing x of type class reflection.reflection.Base
x instanceof reflection.Base true
x instanceof reflection.Derived false
reflection.Base.isInstance(x) true
reflection.Derived.isInstance(x) false
x.getClass() == reflection.Base.class true
x.getClass() == reflection.Derived.class false
x.getClass().equals(reflection.Base.class)) true
x.getClass().equals(reflection.Derived.class)) false
Testing x of type class reflection.reflection.Derived
x instanceof reflection.Base true
x instanceof reflection.Derived true
reflection.Base.isInstance(x) true
reflection.Derived.isInstance(x) true
x.getClass() == reflection.Base.class false
x.getClass() == reflection.Derived.class true
x.getClass().equals(reflection.Base.class)) false
x.getClass().equals(reflection.Derived.class)) true
*/
