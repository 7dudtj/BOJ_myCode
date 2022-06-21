#include <iostream>
using namespace std;

int main()
{
	int L, A, B, C, D, mathDay, koreanDay;

	cin >> L;
	cin >> A;
	cin >> B;
	cin >> C;
	cin >> D;

	if ((A % C) == 0)
		koreanDay = A / C;
	else if ((A % C) != 0)
		koreanDay = (A / C) + 1;

	if ((B % D) == 0)
		mathDay = B / D;
	else if ((B % D) != 0)
		mathDay = (B / D) + 1;

	if (mathDay >= koreanDay)
		cout << L - mathDay << endl;
	else
		cout << L - koreanDay << endl;

	return 0;
}
