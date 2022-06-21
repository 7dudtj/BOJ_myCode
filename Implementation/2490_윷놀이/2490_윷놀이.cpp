#include <iostream>
using namespace std;

int main()
{
	int i, a, b, c, d, sum;

	for (i = 0; i < 3; i++)
	{
		cin >> a >> b >> c >> d;

		sum = a + b + c + d;

		if (sum == 0)
			cout << "D" << endl;
		else if (sum == 1)
			cout << "C" << endl;
		else if (sum == 2)
			cout << "B" << endl;
		else if (sum == 3)
			cout << "A" << endl;
		else if (sum == 4)
			cout << "E" << endl;
	}

	return 0;
}
