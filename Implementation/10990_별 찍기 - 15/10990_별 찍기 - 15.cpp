#include <iostream>
using namespace std;

int main()
{
	int N, i, j;
	bool go = true;

	cin >> N;

	for (i = 0; i < N; i++)
	{
		for (j = 0; j < N - 1 - i; j++)
			cout << " ";
		if (i == 0)
			cout << "*";
		else if (i >= 1)
		{
			cout << "*";
			for (j = 0; j < 2*i - 1; j++)
				cout << " ";
			cout << "*";
		}
		cout << endl;
	}
}s
