// onjava/onjava.atunit/ClassNameFinder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java onjava.onjava.atunit.ClassNameFinder}
package onjava.atunit;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ClassNameFinder {
  public static String thisClass(byte[] classBytes) {
    Map<Integer,Integer> offsetTable = new HashMap<>();
    Map<Integer,String> classNameTable =
      new HashMap<>();
    try {
      DataInputStream data = new DataInputStream(
        new ByteArrayInputStream(classBytes));
      int magic = data.readInt();  // 0xcafebabe
      int minorVersion = data.readShort();
      int majorVersion = data.readShort();
      int constantPoolCount = data.readShort();
      int[] constantPool = new int[constantPoolCount];
      for(int i = 1; i < constantPoolCount; i++) {
        int tag = data.read();
        // int tableSize;
        switch(tag) {
          case 1: // UTF
            int length = data.readShort();
            char[] bytes = new char[length];
            for(int k = 0; k < bytes.length; k++)
              bytes[k] = (char)data.read();
            String className = new String(bytes);
            classNameTable.put(i, className);
            break;
          case 5: // LONG
          case 6: // DOUBLE
            data.readLong(); // discard 8 bytes
            i++; // Special skip necessary
            break;
          case 7: // CLASS
            int offset = data.readShort();
            offsetTable.put(i, offset);
            break;
          case 8: // STRING
            data.readShort(); // discard 2 bytes
            break;
          case 3:  // INTEGER
          case 4:  // FLOAT
          case 9:  // FIELD_REF
          case 10: // METHOD_REF
          case 11: // INTERFACE_METHOD_REF
          case 12: // NAME_AND_TYPE
          case 18: // Invoke Dynamic
            data.readInt(); // discard 4 bytes
            break;
          case 15: // Method Handle
            data.readByte();
            data.readShort();
            break;
          case 16: // Method Type
            data.readShort();
            break;
          default:
            throw
              new RuntimeException("Bad tag " + tag);
        }
      }
      short accessFlags = data.readShort();
      String access = (accessFlags & 0x0001) == 0 ?
        "nonpublic:" : "public:";
      int thisClass = data.readShort();
      int superClass = data.readShort();
      return access + classNameTable.get(
        offsetTable.get(thisClass)).replace('/', '.');
    } catch(IOException | RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
  // Demonstration:
  public static void
  main(String[] args) throws Exception {
    PathMatcher matcher = FileSystems.getDefault()
      .getPathMatcher("glob:**/*.class");
    // Walk the entire tree:
    Files.walk(Paths.get("."))
      .filter(matcher::matches)
      .map(p -> {
          try {
            return thisClass(Files.readAllBytes(p));
          } catch(Exception e) {
            throw new RuntimeException(e);
          }
        })
      .filter(s -> s.startsWith("public:"))
      // .filter(s -> s.indexOf('$') >= 0)
      .map(s -> s.split(":")[1])
      .filter(s -> !s.startsWith("enums."))
      .filter(s -> s.contains("."))
      .forEach(System.out::println);
  }
}
/* Output:
onjava.onjava.ArrayShow
onjava.onjava.atunit.AtUnit$TestMethods
onjava.onjava.atunit.AtUnit
onjava.onjava.atunit.ClassNameFinder
onjava.onjava.atunit.Test
onjava.onjava.atunit.TestObjectCleanup
onjava.onjava.atunit.TestObjectCreate
onjava.onjava.atunit.TestProperty
onjava.onjava.BasicSupplier
onjava.onjava.CollectionMethodDifferences
onjava.onjava.ConvertTo
onjava.Count$Boolean
onjava.Count$Byte
onjava.Count$Character
onjava.Count$Double
onjava.Count$Float
onjava.Count$Integer
onjava.Count$Long
onjava.Count$Pboolean
onjava.Count$Pbyte
onjava.Count$Pchar
onjava.Count$Pdouble
onjava.Count$Pfloat
onjava.Count$Pint
onjava.Count$Plong
onjava.Count$Pshort
onjava.Count$Short
onjava.Count
onjava.onjava.CountingIntegerList
onjava.onjava.CountMap
onjava.onjava.Countries
onjava.onjava.Enums
onjava.onjava.FillMap
onjava.onjava.HTMLColors
onjava.onjava.MouseClick
onjava.onjava.Nap
onjava.onjava.Null
onjava.Operations
onjava.onjava.OSExecute
onjava.onjava.OSExecuteException
onjava.onjava.Pair
onjava.onjava.ProcessFiles$Strategy
onjava.onjava.ProcessFiles
onjava.onjava.Rand$Boolean
onjava.onjava.Rand$Byte
onjava.onjava.Rand$Character
onjava.onjava.Rand$Double
onjava.onjava.Rand$Float
onjava.onjava.Rand$Integer
onjava.onjava.Rand$Long
onjava.onjava.Rand$Pboolean
onjava.onjava.Rand$Pbyte
onjava.onjava.Rand$Pchar
onjava.onjava.Rand$Pdouble
onjava.onjava.Rand$Pfloat
onjava.onjava.Rand$Pint
onjava.onjava.Rand$Plong
onjava.onjava.Rand$Pshort
onjava.onjava.Rand$Short
onjava.onjava.Rand$String
onjava.onjava.Rand
onjava.onjava.Range
onjava.onjava.Repeat
onjava.onjava.RmDir
onjava.onjava.Sets
onjava.onjava.Stack
onjava.onjava.Suppliers
onjava.onjava.TimedAbort
onjava.onjava.Timer
onjava.onjava.Tuple
onjava.onjava.Tuple2
onjava.onjava.Tuple3
onjava.onjava.Tuple4
onjava.onjava.Tuple5
onjava.onjava.TypeCounter
*/
