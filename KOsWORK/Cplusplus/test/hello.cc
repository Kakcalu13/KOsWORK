#include <string>
#include <iostream>
#include <stdio.h>
#include "test.h"
//using namespace std; //comment this out due to bad practice on this one, apparently.

std::string str = "has ";
int var=50;
std::string str1;
int age=0;
int total =0;
std::string ArrayTest= "test";
std::string name;
int day=0;

class MyEgg {
	public:
		//test this code out
		int eggs;
		std::string eggsname;
		MyEgg(std::string x, int z) {
					eggs=z;
					eggsname=x;
					}
		};

void nameFunction(std::string fname){
		std::cout << fname << " is the name";
}


int main() 
{
	//cout << "Hello, World!" << "\n";
	std::cout << "This " << str << var <<  " apple" << "\n";
	printf("git gud\n");
	str1="git gud\n";
	std::cout << str1;
	std::cout << answer();
	std::cout << "\n";
	printf("How old are you, punk?\n");
	std::cin >> age;
	std::cout << "You are " << age << "?\n";
	std::cout << "I am " << answer() << "!\n";
	for (int i =0; i <= 5; i++) {
					total = i + age; //This is to count a simple math. Just don't mind this, refresh my skills
				   }
	std::cout << "\n" << "so that means if you are " << age << " then it would " << total << " in 5 years later!\n"; //total is an int nbr
	total = age; //basically reset the total value.
	for (int i=5; i > 0; i--){
					total= total - 1;//just to decrease
				}
	std::cout << "but you were " << total << " 5 years ago though\n";
	char A=33; //just to test and see what it does to remind myself.
	std::cout << "test: " << A << "\n";
	std::cout << "Okay, new line\n";
	std::cout << ArrayTest[2] << "\n"; //See if it would display 's'
	std::cout << "Okay, punk! What's ya name?\n";
	std::cout << "Your name: ";
	//std::getline (std::cin, name);
	std::cin >> name;
	std::cout << "\n";
	std::cout << "huh, " << name << "?\n";
	int day = 4;
/*	if (day=1,day <+ 7, day++){
		switch (day) {
  		case 1:
    			std::cout << "The number is " <<  "Monday\n";
    			break;
  		case 2:
    			std::cout << "The number is " << "Tuesday\n";
    			break;
  		case 3:
    			std::cout << "The number is " << "Wednesday\n";
    			break;
  		case 4:
    			std::cout << "The number is " << "Thursday\n";
    			break;
  		case 5:
    			std::cout << "The number is " << "Friday\n";
    			break;
  		case 6:
    			std::cout << "The number is " << "Saturday\n";
    			break;
  		case 7:
    			std::cout << "Sunday";
    			break;
				}
}*/  //Just want to see if break and switch works well together. I expected it to not work together very well and I was right.It jumps out of break simply
	nameFunction(name);
	std::cout << "\n";
	MyEgg obj("eggs", 5); 
	std::cout << "All right, so we need to buy "<< obj.eggs << " of " << obj.eggsname << "\n"; //Just to review my knowledge on this one.  
    return 0;
}
