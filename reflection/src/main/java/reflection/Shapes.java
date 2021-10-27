package reflection;// reflection/reflection.Shapes.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.stream.*;

abstract class Shape {
  void draw() {
    System.out.println(this + ".draw()");
  }
  @Override public abstract String toString();
}

class Circle extends Shape {
  @Override public String toString() {
    return "reflection.Circle";
  }
}

class Square extends Shape {
  @Override public String toString() {
    return "reflection.Square";
  }
}

class Triangle extends Shape {
  @Override public String toString() {
    return "reflection.Triangle";
  }
}

public class Shapes {
  public static void main(String[] args) {
    Stream.of(
      new Circle(), new Square(), new Triangle())
      .forEach(Shape::draw);
  }
}
/* Output:
reflection.Circle.draw()
reflection.Square.draw()
reflection.Triangle.draw()
*/
