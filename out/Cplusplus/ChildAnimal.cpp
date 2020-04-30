#include "ChildAnimal.h"

	Dog::Dog(string n, COLOR c, string owner) : Mammal(n, c) {
		_owner = owner;
	}
	Dog::~Dog() {
		cout << "Dog object destroyed!" << endl;
	}
	void Dog::speak() {
		cout << "Woof" << endl;
	}
	void Dog::eat() {
		cout << "Dog eat!" << endl;
	}
	void Dog::move() {
		cout << "Dog move" << endl;
	}



	Cat::Cat(string n, COLOR c, string owner) : Mammal(n, c) {
		_owner = owner;
	}
	Cat::~Cat() {
		cout << "Cat object destroyed!" << endl;
	}
	void Cat ::move() {
		cout << "Cat Go" << endl;
	}
	void Cat::speak() {
		cout << "Cat meow" << endl;
	}
	void Cat::eat() {
		cout << "Cat eat!" << endl;
	}


	Lion::Lion(string n, COLOR c) : Mammal(n, c) {

	}
	Lion::~Lion() {
		cout << "Lion object destroyed!" << endl;
	}
	void Lion::move() {
		cout << "Lion Go" << endl;
	}
	void Lion::speak() {
		cout << "Lion Roar" << endl;
	}

