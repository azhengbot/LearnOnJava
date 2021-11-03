// innerclasses/innerclasses.BigEgg2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Proper inheritance of an inner class
package innerclasses;

class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("innerclasses.Egg2.Yolk()");
        }

        public void f() {
            System.out.println("innerclasses.Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    Egg2() {
        System.out.println("New innerclasses.Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        y.f();
    }
}

public class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("innerclasses.BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("innerclasses.BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}
/* Output:
innerclasses.Egg2.Yolk()
New innerclasses.Egg2()
innerclasses.Egg2.Yolk()
innerclasses.BigEgg2.Yolk()
innerclasses.BigEgg2.Yolk.f()
*/
