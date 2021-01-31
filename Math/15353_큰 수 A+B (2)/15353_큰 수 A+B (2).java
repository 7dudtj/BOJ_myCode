#include <iostream>
#include <string>
using namespace std;

int main()
{
	// set needed variables
	string A, B;
	int LA, LB, bigNum, i, sum, FN;
	char *listA, *listB, *listD;
	int *listC;

	// get user input
	cin >> A >> B;

	// find inputs' length
	LA = A.length();
	LB = B.length();

	// find Big Number
	if (LA >= LB)
		bigNum = LA;
	else
		bigNum = LB;

	// set const big number
	const int BN = bigNum;

	// set needed list pointer
	listA = new char[BN];
	listB = new char[BN];
	listC = new int[BN + 1];
	listD = new char[BN + 1];

	// set initial listA & listB
	for (i = 0; i < BN; i++)
	{
		listA[i] = '0';
		listB[i] = '0';
	}		

	// set initial listC
	for (i = 0; i < BN + 1; i++)
		listC[i] = -1;

	// set initial listD
	for (i = 0; i < BN + 1; i++)
		listD[i] = '0';

	// input 'A' to listA
	for (i = 0; i < LA; i++)
		listA[i] = A[LA - 1 - i];

	// input 'B' to listB
	for (i = 0; i < LB; i++)
		listB[i] = B[LB - 1 - i];

	// calculation
	for (i = 0; i < BN; i++)
	{
		sum = 0;
		sum = (listA[i] - 48) + (listB[i] - 48);
		if (sum >= 10)
		{
			listD[i + 1] = '1';
			if (listD[i] == '1')
				sum++;
			listC[i] = sum - 10;
		}
		else if (sum == 9)
		{
			if (listD[i] == '1')
			{
				sum++;
				listD[i + 1] = '1';
				listC[i] = 0;
			}
			else
				listC[i] = 9;
		}
		else // 0 <= sum <= 8
		{
			if (listD[i] == '1')
				sum++;
			listC[i] = sum;
		}
	}

	// check if last number exists
	if (listD[BN] == '1')
	{
		listC[BN] = 1;
		FN = BN + 1;
	}
	else
		FN = BN;

	// print answer
	for (i = 0; i < FN; i++)
		cout << listC[FN - 1 - i];

	// end program
	return 0;
}
