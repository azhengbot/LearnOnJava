package enums;// enums/enums.NotClasses.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ExcludeFromGradle}
// javap -c enums.LikeClasses

enum LikeClasses {
  WINKEN {
    @Override void behavior() {
      System.out.println("Behavior1");
    }
  },
  BLINKEN {
    @Override void behavior() {
      System.out.println("Behavior2");
    }
  },
  NOD {
    @Override void behavior() {
      System.out.println("Behavior3");
    }
  };
  abstract void behavior();
}

public class NotClasses {
  // void f1(enums.LikeClasses.WINKEN instance) {} // Nope
}
/* Output: (First 12 Lines)
Compiled from "enums.NotClasses.java"
abstract class enums.LikeClasses extends
java.lang.Enum<enums.LikeClasses> {
  public static final enums.LikeClasses WINKEN;

  public static final enums.LikeClasses BLINKEN;

  public static final enums.LikeClasses NOD;

  public static enums.LikeClasses[] values();
    Code:
       0: getstatic     #2                  // Field
$VALUES:[LLikeClasses;
       3: invokevirtual #3                  // Method
"[LLikeClasses;".clone:()Ljava/lang/Object;
                  ...
*/
