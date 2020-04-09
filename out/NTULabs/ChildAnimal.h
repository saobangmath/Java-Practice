#include<iostream>
#include "Animal.h"
#include<string>
using namespace std;
#pragma once
class Dog : public Mammal {
public:
	Dog(string n, COLOR c, string owner);
	~Dog();
	void speak();
	void eat();
	void move();
private:
	string _owner;
};

class Cat : public Mammal {
public:
	Cat(string n, COLOR c, string owner);
	~Cat();
	void move();
	void speak();
	void eat();
private:
	string _owner;
};

class Lion : public Mammal {
public:
	Lion(string n, COLOR c);
	~Lion();
	void move();
	void speak();
};

