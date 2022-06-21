#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	// set needed variables
	int T, i, j, count, one, two, three, four, five, six, seven, checkPoint, minValue, totalValue;
	int even[7];
	int input[7];
	int *calculate;
	
	// get number of testcase
	cin >> T;

	// calculate process
	for (i = 0; i < T; i++)
	{
		// set default value
		for (j = 0; j < 7; j++)
			even[j] = -1;
		count = 0;
		minValue = 0;
		totalValue = 0;
		checkPoint = 0;

		// get user input
		cin >> one >> two >> three >> four >> five >> six >> seven;
		input[0] = one, input[1] = two, input[2] = three, input[3] = four, input[4] = five, input[5] = six, input[6] = seven;

		// find out which is even number
		for (j = 0; j < 7; j++)
		{
			if (input[j] % 2 == 0)
			{
				even[count] = input[j];
				count++;
			}
		}

		// find even length
		for (j = 0; j < 7; j++)
		{
			if (even[j] == -1)
			{
				checkPoint = j;
				break;
			}
		}

		// find out if all inputs are even
		if (checkPoint == 0)
			checkPoint = 7;

		// make calculate pointer list
		calculate = new int[checkPoint];

		// make only even list for calculate
		for (j = 0; j < checkPoint; j++)
			calculate[j] = even[j];

		// rearrange to find minimum value
		sort(calculate, calculate + checkPoint);

		// we get minValue
		minValue = calculate[0];

		// find sum
		for (j = 0; j < checkPoint; j++)
			totalValue += calculate[j];

		// display answers
		cout << totalValue << " " << minValue << endl;

		// delete pointer
		delete[] calculate;
		calculate = NULL;
	}

	// end program
	return 0;
}
