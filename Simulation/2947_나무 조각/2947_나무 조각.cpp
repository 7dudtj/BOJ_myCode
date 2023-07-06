#include <iostream>
using namespace std;

void swapValue(int& a, int& b);

int main()
{
	// set needed variables
	int one, two, three, four, five;

	// get user input
	cin >> one >> two >> three >> four >> five;

	// calculation process
	while (true)
	{
		if ((one == 1) && (two == 2) && (three == 3) && (four == 4) && (five == 5))
			break;
		else
		{
			if (one > two)
			{
				swapValue(one, two);
				cout << one << " " << two << " " << three << " " << four << " " << five << endl;
			}
			if (two > three)
			{
				swapValue(two, three);
				cout << one << " " << two << " " << three << " " << four << " " << five << endl;
			}
			if (three > four)
			{
				swapValue(three, four);
				cout << one << " " << two << " " << three << " " << four << " " << five << endl;
			}
			if (four > five)
			{
				swapValue(four, five);
				cout << one << " " << two << " " << three << " " << four << " " << five << endl;
			}
		}
	}

	// end program
	return 0;
}

void swapValue(int& a, int& b)
{
	int temp = a;
	a = b;
	b = temp;
	return;
}