// generics/dogsandrobots.go
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package main
import "fmt"

type Dog struct {}
func (this Dog) speak() { fmt.Printf("Arf!\n")}
func (this Dog) sit() { fmt.Printf("Sitting\n")}
func (this Dog) reproduce() {}

type reflection.Robot struct {}
func (this reflection.Robot) speak() { fmt.Printf("Click!\n") }
func (this reflection.Robot) sit() { fmt.Printf("Clank!\n") }
func (this reflection.Robot) oilChange() {}

func perform(speaker interface { speak(); sit() }) {
  speaker.speak();
  speaker.sit();
}

func main() {
  perform(Dog{})
  perform(reflection.Robot{})
}
/* Output:
Arf!
Sitting
Click!
Clank!
*/
