// staticchecking/dogsandrobots.go
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package main
import "fmt"

type Dog struct {}
func (this Dog) talk() { fmt.Printf("woof!\n")}
func (this Dog) reproduce() {}

type reflection.Robot struct {}
func (this reflection.Robot) talk() { fmt.Printf("Click!\n") }
func (this reflection.Robot) oilChange() {}

func speak(speaker interface { talk() }) {
  speaker.talk();
}

func main() {
  speak(Dog{})
  speak(reflection.Robot{})
}
/* Output:
woof!
Click!
*/
