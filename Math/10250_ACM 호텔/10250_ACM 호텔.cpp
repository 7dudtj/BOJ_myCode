#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int H, W, N, T, i, floor = 0, room = 0, number = 0;

	// get testcase number
	cin >> T;

	// run program
	for (i = 0; i < T; i++)
	{
		// get user input
		cin >> H >> W >> N;

		// divide by case
		if (N == 1)
		{
			cout << 101 << endl;
		}
		else if (H == 1)
		{
			number = 100 + N;
			cout << number << endl;
		}
		else if (H == N)
		{
			number = H * 100 + 1;
			cout << number << endl;
		}
		else if ((N % H) == 0)
		{
			// calculation process
			room = N / H;
			floor = H;
			number = floor * 100 + room;

			// display result
			cout << number << endl;
		}
		else
		{
			// calculation process
			floor = N % H;
			room = (N / H) + 1;
			number = floor * 100 + room;

			// display result
			cout << number << endl;
		}

		// reset value
		floor = 0;
		room = 0;
		number = 0;
	}

	// end program
	return 0;
}
