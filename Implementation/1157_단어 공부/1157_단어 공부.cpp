#include <iostream>
#include <string>
using namespace std;

int main()
{
	// set needed variables
	char *alpa;
	int i, inputLen, max;
	int count[26];
	string input;

	// get user input
	cin >> input;

	// check input's length
	inputLen = input.size();

	// set pointer list
	alpa = new char[inputLen];

	// toss input value to alpa
	for (i = 0; i < inputLen; i++)
		alpa[i] = input[i];

	// set default count list
	for (i = 0; i < 26; i++)
		count[i] = 0;

	// check how many alpabets are exist
	for (i = 0; i < inputLen; i++)
	{
		if ((alpa[i] - 65 == 0) || (alpa[i] - 97 == 0))
			count[0]++;
		else if ((alpa[i] - 65 == 1) || (alpa[i] - 97 == 1))
			count[1]++;
		else if ((alpa[i] - 65 == 2) || (alpa[i] - 97 == 2))
			count[2]++;
		else if ((alpa[i] - 65 == 3) || (alpa[i] - 97 == 3))
			count[3]++;
		else if ((alpa[i] - 65 == 4) || (alpa[i] - 97 == 4))
			count[4]++;
		else if ((alpa[i] - 65 == 5) || (alpa[i] - 97 == 5))
			count[5]++;
		else if ((alpa[i] - 65 == 6) || (alpa[i] - 97 == 6))
			count[6]++;
		else if ((alpa[i] - 65 == 7) || (alpa[i] - 97 == 7))
			count[7]++;
		else if ((alpa[i] - 65 == 8) || (alpa[i] - 97 == 8))
			count[8]++;
		else if ((alpa[i] - 65 == 9) || (alpa[i] - 97 == 9))
			count[9]++;
		else if ((alpa[i] - 65 == 10) || (alpa[i] - 97 == 10))
			count[10]++;
		else if ((alpa[i] - 65 == 11) || (alpa[i] - 97 == 11))
			count[11]++;
		else if ((alpa[i] - 65 == 12) || (alpa[i] - 97 == 12))
			count[12]++;
		else if ((alpa[i] - 65 == 13) || (alpa[i] - 97 == 13))
			count[13]++;
		else if ((alpa[i] - 65 == 14) || (alpa[i] - 97 == 14))
			count[14]++;
		else if ((alpa[i] - 65 == 15) || (alpa[i] - 97 == 15))
			count[15]++;
		else if ((alpa[i] - 65 == 16) || (alpa[i] - 97 == 16))
			count[16]++;
		else if ((alpa[i] - 65 == 17) || (alpa[i] - 97 == 17))
			count[17]++;
		else if ((alpa[i] - 65 == 18) || (alpa[i] - 97 == 18))
			count[18]++;
		else if ((alpa[i] - 65 == 19) || (alpa[i] - 97 == 19))
			count[19]++;
		else if ((alpa[i] - 65 == 20) || (alpa[i] - 97 == 20))
			count[20]++;
		else if ((alpa[i] - 65 == 21) || (alpa[i] - 97 == 21))
			count[21]++;
		else if ((alpa[i] - 65 == 22) || (alpa[i] - 97 == 22))
			count[22]++;
		else if ((alpa[i] - 65 == 23) || (alpa[i] - 97 == 23))
			count[23]++;
		else if ((alpa[i] - 65 == 24) || (alpa[i] - 97 == 24))
			count[24]++;
		else if ((alpa[i] - 65 == 25) || (alpa[i] - 97 == 25))
			count[25]++;
	}

	// check which alpabet is most frequently used
	max = 0;
	int code = 0;
	int checkPoint = 0;
	for (i = 0; i < 26; i++)
	{
		if (count[i] != 0)
		{
			if (max < count[i])
			{
				max = count[i];
				code = i;
				checkPoint = 0;
			}
			else if (max > count[i])
			{
				max = max;
			}
			else // (max == count[i])
			{
				max = max;
				checkPoint = 1;
			}
		}
	}

	// display answer
	if (checkPoint == 1)
		cout << "?" << endl;
	else
		cout << char(code + 65) << endl;

	return 0;
}
