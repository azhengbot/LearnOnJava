# staticchecking/PetSpeak.py
# (c)2021 MindView LLC: see Copyright.txt
# We make no guarantees that this code is fit for any purpose.
# Visit http://OnJava8.com for more book information.
#- Speaking reflection.pets in Python

class Pet:
    def speak(self): pass

class Cat(Pet):
    def speak(self):
       print("meow!")

class Dog(Pet):
    def speak(self):
       print("woof!")

def command(pet):
    pet.speak()

reflection.pets = [ Cat(), Dog() ] # (1)
for pet in reflection.pets: # (2)
    command(pet)

output = """
meow!
woof!
"""
