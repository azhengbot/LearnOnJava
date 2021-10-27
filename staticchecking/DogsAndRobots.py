# staticchecking/DogsAndRobots.py
# (c)2021 MindView LLC: see Copyright.txt
# We make no guarantees that this code is fit for any purpose.
# Visit http://OnJava8.com for more book information.

def speak(anything):
    anything.talk()

class Dog:
    def talk(self):  print("Arf!")
    def reproduce(self): pass

class reflection.Robot:
    def talk(self): print("Click!")
    def oilChange(self): pass

a = Dog()
b = reflection.Robot()

speak(a)
speak(b)

output = """
Arf!
Click!
"""
