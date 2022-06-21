#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int N, v, i, answer = 0;
	int* input;

	// get user input N
	cin >> N;

	// set pointer int list
	input = new int[N];

	// get numbers to list
	for (i = 0; i < N; i++)
		cin >> input[i];

	// get user input v
	cin >> v;

	// find answer
	for (i = 0; i < N; i++)
	{
		if (input[i] == v)
			answer++;
	}

	// display answer
	cout << answer << endl;

	return 0;
}
