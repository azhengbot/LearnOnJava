// reflection/reflection.pets/PetCreator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using class literals
// {java reflection.reflection.pets.PetCreator}
package reflection.pets;
import java.util.*;

public class PetCreator extends Creator {
  // No try block needed.
  public static final
  List<Class<? extends Pet>> ALL_TYPES =
    Collections.unmodifiableList(Arrays.asList(
      Pet.class, Dog.class, Cat.class, Rodent.class,
      Mutt.class, Pug.class, EgyptianMau.class,
      Manx.class, Cymric.class, Rat.class,
      Mouse.class, Hamster.class));
  // Types for random creation:
  private static final
  List<Class<? extends Pet>> TYPES =
    ALL_TYPES.subList(
      ALL_TYPES.indexOf(Mutt.class),
      ALL_TYPES.size());
  @Override
  public List<Class<? extends Pet>> types() {
    return TYPES;
  }
  public static void main(String[] args) {
    System.out.println(TYPES);
    List<Pet> pets = new PetCreator().list(7);
    System.out.println(pets);
  }
}
/* Output:
[class reflection.reflection.pets.Mutt, class reflection.reflection.pets.Pug,
class reflection.reflection.pets.EgyptianMau, class
reflection.reflection.pets.Manx, class reflection.reflection.pets.Cymric, class
reflection.reflection.pets.Rat, class reflection.reflection.pets.Mouse, class
reflection.reflection.pets.Hamster]
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
*/
