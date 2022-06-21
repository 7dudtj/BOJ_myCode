#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	char list[100];
	int i, number = 0;

	// set default value
	for (i = 0; i < 100; i++)
		list[i] = '*';

	// get user input
	cin >> list;

	// check if alphabet is a, e, i, o, u
	for (i = 0; i < 100; i++)
	{
		if ((list[i] - 97 == 0) || (list[i] - 97 == 4) || (list[i] - 97 == 8) || (list[i] - 97 == 14) || (list[i] - 97 == 20))
			number++;
	}

	// display answer
	cout << number << endl;
}
