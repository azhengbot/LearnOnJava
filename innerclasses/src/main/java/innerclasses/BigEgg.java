// innerclasses/innerclasses.BigEgg.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// An inner class cannot be overridden like a method
package innerclasses;

class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("innerclasses.Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New innerclasses.Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("innerclasses.BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
/* Output:
New innerclasses.Egg()
innerclasses.Egg.Yolk()
*/
