#include "Animal.h"
#include "ChildAnimal.h"

int main() {
	Animal a;
	a.speak();
	system("PAUSE");
	Animal b = Animal("dog", Black);
	b.speak();
	system("PAUSE");
	Mammal c = Mammal("Mammal", Blue);
	c.eat();
	system("PAUSE");
	Dog dog = Dog("dog", Blue, "TAI");
	dog.speak();
	dog.move();
	system("PAUSE");
	Animal* animalPtr = new Dog("Lassie", White, "Andy");
	animalPtr->move();
	animalPtr->speak();
	delete animalPtr;
	system("PAUSE");
	// Build a Zoo
	// declare animals in the zoo
	Dog d1 = Dog("Pluto", White, "A");
	Cat c1 = Cat("Kitty", Black, "B");
	Lion l1 = Lion("hjhjk", White);
	// declare set of available animals in the zoo
	cout << "(1) Dog (2) Cat (3) Lion (4) Move all animals (5) Quit" << endl;
	Mammal objects[] = { d1, c1, l1 };
	int choice;
	bool stop = false;
	while (!stop) {
		cout << "Select the animal to send to Zoo:" << endl;
		cin >> choice;
		switch (choice)
		{
		case 1:
			d1.move();
			d1.speak();
			d1.eat();
			break;
		case 2:
			c1.move();
			c1.speak();
			c1.eat();
			break;
		case 3:
			l1.move();
			l1.speak();
			l1.eat();
			break;
		case 4:
			// dog 
			d1.move();
			d1.speak();
			d1.eat();
			// cat
			c1.move();
			c1.speak();
			c1.eat();
			// lion
			l1.move();
			l1.speak();
			l1.eat();
			break;
		default:
			stop = true;
			break;
		}
	}
	cout << "Program existing ...." << endl;
	return 0;
}