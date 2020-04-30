#include <iostream> // header in standard library
#include<string>
using namespace std;
enum COLOR { Green, Blue, Black, Brown, White };
#pragma once
class Animal {
public:
	Animal();
	Animal(string n, COLOR c);
	~Animal();
	virtual void speak() const;
	virtual void move() const;
private:
	string _name;
	COLOR _color;
};
class Mammal : public Animal {
public:
	Mammal(string n, COLOR c);
	~Mammal();
	void eat() const;
};
