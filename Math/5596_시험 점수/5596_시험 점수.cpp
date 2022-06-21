#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int a1, a2, a3, a4, A, b1, b2, b3, b4, B;

	// get scores
	cin >> a1 >> a2 >> a3 >> a4;
	cin >> b1 >> b2 >> b3 >> b4;

	// find A and B
	A = a1 + a2 + a3 + a4;
	B = b1 + b2 + b3 + b4;

	// display result
	if (A >= B) {
		cout << A << endl;
	}
	else {
		cout << B << endl;
	}

	// end program
	return 0;
}
