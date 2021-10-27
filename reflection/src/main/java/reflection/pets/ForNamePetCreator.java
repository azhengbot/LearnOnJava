// reflection/reflection.pets/ForNamePetCreator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package reflection.pets;
import java.util.*;

public class ForNamePetCreator extends Creator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<>();
  // Types you want randomly created:
  private static String[] typeNames = {
    "reflection.reflection.pets.Mutt",
    "reflection.reflection.pets.Pug",
    "reflection.reflection.pets.EgyptianMau",
    "reflection.reflection.pets.Manx",
    "reflection.reflection.pets.Cymric",
    "reflection.reflection.pets.Rat",
    "reflection.reflection.pets.Mouse",
    "reflection.reflection.pets.Hamster"
  };
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  @Override public List<Class<? extends Pet>> types() {
    return types;
  }
}
