package polymorphism;// polymorphism/polymorphism.ReferenceCounting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cleaning up shared member objects

class Shared {
  private int refcount = 0;
  private static long counter = 0;
  private final long id = counter++;
  Shared() {
    System.out.println("Creating " + this);
  }
  public void addRef() { refcount++; }
  protected void dispose() {
    if(--refcount == 0)
      System.out.println("Disposing " + this);
  }
  @Override public String toString() {
    return "polymorphism.Shared " + id;
  }
}

class Composing {
  private Shared shared;
  private static long counter = 0;
  private final long id = counter++;
  Composing(Shared shared) {
    System.out.println("Creating " + this);
    this.shared = shared;
    this.shared.addRef();
  }
  protected void dispose() {
    System.out.println("disposing " + this);
    shared.dispose();
  }
  @Override public String toString() {
    return "polymorphism.Composing " + id;
  }
}

public class ReferenceCounting {
  public static void main(String[] args) {
    Shared shared = new Shared();
    Composing[] composing = {
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared)
    };
    for(Composing c : composing)
      c.dispose();
  }
}
/* Output:
Creating polymorphism.Shared 0
Creating polymorphism.Composing 0
Creating polymorphism.Composing 1
Creating polymorphism.Composing 2
Creating polymorphism.Composing 3
Creating polymorphism.Composing 4
disposing polymorphism.Composing 0
disposing polymorphism.Composing 1
disposing polymorphism.Composing 2
disposing polymorphism.Composing 3
disposing polymorphism.Composing 4
Disposing polymorphism.Shared 0
*/
