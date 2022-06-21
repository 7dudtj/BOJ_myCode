#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	char list[101];
	int i, check = 0;

	// set default value
	for (i = 0; i < 101; i++)
		list[i] = '*';

	// get user input
	cin >> list;

	// censor time
	for (i = 0; i < 101; i++)
	{
		if ((list[i] == 65) || (list[i] == 66) || (list[i] == 67) || (list[i] == 68) || (list[i] == 69) ||
			(list[i] == 71) || (list[i] == 73) || (list[i] == 77) || (list[i] == 82))
			list[i] = '*';
	}

	// check if all letter will be delete
	for (i = 0; i < 101; i++)
		if (list[i] == '*')
			check++;

	// display answer when all letter are deleted
	if (check == 100)
	{
		cout << " " << endl;
		exit(1);
	}

	// display censored answer
	for (i = 0; i < 101; i++)
	{
		if ((list[i] != '*') && (list[i] != '\0'))
			cout << list[i];
	}
}
