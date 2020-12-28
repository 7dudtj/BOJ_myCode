#include <iostream>
#include <string>
using namespace std;

int main()
{
	// set needed variable
	string lenShuttle;
	int strLen, i;
	char *inputList, *outputList;

	// get user input
	cin >> lenShuttle;

	// check input size
	strLen = lenShuttle.size();

	// make inputList and outputList pointer
	inputList = new char[strLen];
	outputList = new char[strLen];

	// toss string to char
	for (i = 0; i < strLen; i++)
		inputList[i] = lenShuttle[i];

	// change small to big, big to small
	for (i = 0; i < strLen; i++)
	{
		if ((65 <= inputList[i]) && (inputList[i] <= 90))
			outputList[i] = char(inputList[i] + 32);
		else
			outputList[i] = char(inputList[i] - 32);
	}

	// display answer
	for (i = 0; i < strLen; i++)
		cout << outputList[i];

	return 0;
}
