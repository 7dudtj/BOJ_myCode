#include <iostream>
using namespace std;

int main()
{
	int C = 0, K = 0, P = 0;

	cin >> C >> K >> P;
	
	cout << (K * C * (C + 1) / 2) + (P * C * (C + 1) * (2 * C + 1) / 6) << endl;
}
