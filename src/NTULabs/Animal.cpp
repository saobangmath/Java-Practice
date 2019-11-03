#include<iostream>
#include<string>
#include "Animal.h"
using namespace std;

	Animal::Animal() : _name("unknown") {
		cout << "constructing Animal object " << _name << endl;
	}
	Animal::Animal(string n, COLOR c) {
		cout << "Animal name: " << n << endl;
		cout << "Animal color: " << c << endl;
	}
	Animal::~Animal() {
		cout << "destructing Animal object " << _name << endl;
	}
	void Animal::speak() const{
		cout << "Animal speaks " << endl;
	}
	void Animal::move() const { }

	Mammal::Mammal(string n, COLOR c) : Animal(n, c){
			
	}
	Mammal::~Mammal() {
		cout << "destructing Mammal object" << endl;
	}
	void Mammal::eat() const {
		cout << "Mammal eat" << endl;
	}

