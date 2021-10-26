package enums;// enums/enums.Reflection.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Analyzing enums using reflection
import java.lang.reflect.*;
import java.util.*;
import onjava.*;

enum Explore { HERE, THERE }

public class Reflection {
  public static
  Set<String> analyze(Class<?> enumClass) {
    System.out.println(
      "_____ Analyzing " + enumClass + " _____");
    System.out.println("Interfaces:");
    for(Type t : enumClass.getGenericInterfaces())
      System.out.println(t);
    System.out.println(
      "Base: " + enumClass.getSuperclass());
    System.out.println("Methods: ");
    Set<String> methods = new TreeSet<>();
    for(Method m : enumClass.getMethods())
      methods.add(m.getName());
    System.out.println(methods);
    return methods;
  }
  public static void main(String[] args) {
    Set<String> exploreMethods =
      analyze(Explore.class);
    Set<String> enumMethods = analyze(Enum.class);
    System.out.println(
      "enums.Explore.containsAll(Enum)? " +
      exploreMethods.containsAll(enumMethods));
    System.out.print("enums.Explore.removeAll(Enum): ");
    exploreMethods.removeAll(enumMethods);
    System.out.println(exploreMethods);
    // Decompile the code for the enum:
    OSExecute.command(
      "javap -cp build/classes/java/main enums.Explore");
  }
}
/* Output:
_____ Analyzing class enums.Explore _____
Interfaces:
Base: class java.lang.Enum
Methods:
[compareTo, equals, getClass, getDeclaringClass,
hashCode, name, notify, notifyAll, ordinal, toString,
valueOf, values, wait]
_____ Analyzing class java.lang.Enum _____
Interfaces:
java.lang.Comparable<E>
interface java.io.Serializable
Base: class java.lang.Object
Methods:
[compareTo, equals, getClass, getDeclaringClass,
hashCode, name, notify, notifyAll, ordinal, toString,
valueOf, wait]
enums.Explore.containsAll(Enum)? true
enums.Explore.removeAll(Enum): [values]
Compiled from "enums.Reflection.java"
final class enums.Explore extends java.lang.Enum<enums.Explore> {
  public static final enums.Explore HERE;
  public static final enums.Explore THERE;
  public static enums.Explore[] values();
  public static enums.Explore valueOf(java.lang.String);
  static {};
}
*/
