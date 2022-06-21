#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int A, B, C;

	// get three angles
	cin >> A;
	cin >> B;
	cin >> C;

	// display result
	if ((A + B + C) != 180)
		cout << "Error" << endl;
	else
	{
		if ((A == B) && (B == C))
			cout << "Equilateral" << endl;
		else if ((A == B) || (B == C) || (C == A))
			cout << "Isosceles" << endl;
		else
			cout << "Scalene" << endl;
	}

	return 0;
}
