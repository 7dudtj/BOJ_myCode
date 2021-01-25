#include <iostream>
using namespace std;

int main()
{
	int T, d, n, s, p, i, BT, JT;

	cin >> T;

	for (i = 0; i < T; i++)
	{
		cin >> d >> n >> s >> p;

		BT = d + n * p;
		JT = n * s;

		if (BT < JT)
			cout << "parallelize" << endl;
		else if (BT > JT)
			cout << "do not parallelize" << endl;
		else
			cout << "does not matter" << endl;
	}
}
