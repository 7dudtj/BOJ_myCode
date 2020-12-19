#include <iostream>
using namespace std;

int main()
{
	int N, i, j;

	cin >> N;

	for (i = 0; i < N; i++)
	{
		for (j = 0; j < i + 1; j++)
			cout << "*";
		cout << endl;
	}

	for (i = N - 2; i >= 0; i--)
	{
		for (j = i; j >= 0; j--)
			cout << "*";
		cout << endl;
	}
}
