#include <stdio.h>
#include <iostream>
#include <fstream>
#include<stdlib.h> //without this, you cant use system()
using namespace std;

int main()
{
	ofstream myfile; 
	myfile.open("example.bat"); //make a name of file
	myfile<< "@echo off \n echo hi \n pause"; //write in the file
	myfile.close(); //save and close the file
	system ("example.bat"); //same as cmd (start example.bat)
	/*
		switch(choice)
		{
			case 1: answer=num1+num2;
			break;
			case 2: num1-num2;
			break;
		}
	*/

/*
////////////STRING CODES\\\\\\\\\\\\\\\\\\\\\
Use #include <string.h>
strcpy(s1, s2);
strncpy(s1, s2, 7);
strcat(s1,s2);
strncat(s1,s2, 3);
strcmp(s1,s2);
num=strlen(s1);
*/
	return 0;
}
