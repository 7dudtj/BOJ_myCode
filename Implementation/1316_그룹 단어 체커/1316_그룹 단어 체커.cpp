#include <iostream>
#include <string>
using namespace std;

int main()
{
	// set needed variables
	int inputNum, i, j, total = 0, inputLen = 0;
	string input;
	char *inputList;
	int alpa[26];
	char checkPoint = 'y';

	// get inputNumber
	cin >> inputNum;

	// calculate for inputNumber times
	for (i = 0; i < inputNum; i++)
	{
		// set default value
		input = "";
		for (j = 0; j < 26; j++)
			alpa[j] = 0;
		inputLen = 0;
		checkPoint = 'y';

		// get user input
		cin >> input;

		// check input Length
		inputLen = input.length();

		// make inputList pointer
		inputList = new char[inputLen];

		// toss string to char
		for (j = 0; j < inputLen; j++)
		{
			inputList[j] = input[j];
		}

		// check if inputLength is 1
		if (inputLen == 1)
			total++;
		// if inputLength is over 1
		else if (inputLen > 1)
		{
			alpa[inputList[0] - 97] = 1;
			for (j = 1; j < inputLen; j++)
			{
				if (inputList[j - 1] == inputList[j])
				{
					// pass
				}
				else if (inputList[j - 1] != inputList[j])
				{
					if (alpa[inputList[j] - 97] == 1)
					{
						checkPoint = 'n';
						break;
					}
					else if (alpa[inputList[j] - 97] == 0)
						alpa[inputList[j] - 97] = 1;
				}
			}
			// check if this input is answer or not
			if (checkPoint == 'y')
			{
				total++;
			}
			else
				total = total;
		}
		
		// delete memory
		delete[] inputList;
		inputList = NULL;
	}

	cout << total << endl;
}
