#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	// set needed variables
	int a, b, c;
	int value[3];
	int temp;

	while (true)
	{
		// set default value
		a = 0, b = 0, c = 0;
		value[0] = 0, value[1] = 0, value[2] = 0;
		temp = 0;

		// get user input
		cin >> a >> b >> c;

		// check if program will finish
		if ((a == 0) && (b == 0) && (c == 0))
			break;

		// calculation
		else
		{
			// allocate value to list
			value[0] = a, value[1] = b, value[2] = c;

			// sort 1&2
			if (value[0] >= value[1])
			{
				temp = int(value[0]);
				value[0] = int(value[1]);
				value[1] = temp;
			}

			// sort 2&3
			if (value[1] >= value[2])
			{
				temp = int(value[1]);
				value[1] = int(value[2]);
				value[2] = temp;
			}

			// check if this triangle is right
			if (value[2] * value[2] == value[0] * value[0] + value[1] * value[1])
				cout << "right" << endl;
			else
				cout << "wrong" << endl;
		}
	}
	return 0;
}