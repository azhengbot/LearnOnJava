package polymorphism;// polymorphism/polymorphism.PolyConstructors.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructors and polymorphism
// don't produce what you might expect

class Glyph {
  void draw() { System.out.println("polymorphism.Glyph.draw()"); }
  Glyph() {
    System.out.println("polymorphism.Glyph() before draw()");
    draw();
    System.out.println("polymorphism.Glyph() after draw()");
  }
}

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    System.out.println(
      "polymorphism.RoundGlyph.polymorphism.RoundGlyph(), radius = " + radius);
  }
  @Override void draw() {
    System.out.println(
      "polymorphism.RoundGlyph.draw(), radius = " + radius);
  }
}

public class PolyConstructors {
  public static void main(String[] args) {
    new RoundGlyph(5);
  }
}
/* Output:
polymorphism.Glyph() before draw()
polymorphism.RoundGlyph.draw(), radius = 0
polymorphism.Glyph() after draw()
polymorphism.RoundGlyph.polymorphism.RoundGlyph(), radius = 5
*/
