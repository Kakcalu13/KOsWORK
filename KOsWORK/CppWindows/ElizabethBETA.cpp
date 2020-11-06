#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

int main()
{
	char name[4]="cls";
	printf("Hello! My name is Elizabeth! how can I help you, KO?\n");
	printf("You can also type a program you wish to start.\n");
	printf("Well, when you want to quit the program, type exit and BAM! Disappeared!\n");
	printf("if you are not sure what to put, type help.\n");
	while (strcmp(name,"exit")!=0)
	{
		if (strcmp(name,"exit")==0)
		{
			system("exit");
		}
		printf("Program: ");
		scanf("%s",name);
		if (strcmp(name, "google")==0)
		{
			system("start chrome.exe");
		}
		else if ((strcmp(name, "facebook")==0) || (strcmp(name, "fb")==0))
		{
			system("start chrome.exe www.facebook.com");
		}
		else if ((strcmp(name, "help")==0))
		{
			printf("Here of list that you can type:\n fb\n google \n notepad \n");
		}
		else
			system(("%s", name));
		
			
	}
}
