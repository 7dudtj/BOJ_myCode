#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int N, i, total = 0, input;

	// get N
	cin >> N;

	// get 0 or 1
	for (i = 0; i < N; i++)
	{
		cin >> input;
		total += input;
	}

	// check answer
	if (total > N / 2)
		cout << "Junhee is cute!" << endl;
	else
		cout << "Junhee is not cute!" << endl;
}
