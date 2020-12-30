#include <iostream>
using namespace std;

int calculate(int a, int b);

struct shuttle
{
	int floor;
	int room;
};

int main()
{
	// set needed variables
	int N, k, n, i, answer;

	// get number of cases
	cin >> N;

	// find answer for N times
	for (i = 0; i < N; i++)
	{
		// set default value
		k = 0, n = 0, answer = 0;

		// get k and n
		cin >> k;
		cin >> n;

		// calculate
		answer = calculate(k, n);
		cout << answer << endl;
	}

}

int calculate(int a, int b)
{
	// set needed variables
	int i, result = 0;
	bool go = true;
	shuttle myshuttle = { a, b };
	shuttle* babyshuttle = new shuttle[b];

	// calculation process
	for (i = 0; i < b; i++)
	{
		babyshuttle[i] = { a - 1, i + 1 };
		if (babyshuttle[i].room == 1)
			result += 1;
		else if (babyshuttle[i].floor == 0)
			result += babyshuttle[i].room;
		else
			result += calculate(babyshuttle[i].floor, babyshuttle[i].room);
	}

	// delete pointer and memory
	delete[] babyshuttle;
	babyshuttle = NULL;

	// return answer
	return result;
}
