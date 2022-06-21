#include <iostream>
#include <cmath>
using namespace std;

int main() {
	// set needed variables
	int T, k, i, count = 0, n = 0;

	// get T
	cin >> T;

	// find number of passangers
	for (i = 0; i < T; i++) {
		// get k
		cin >> k;

		// find n
		n = pow(2, k) - 1;

		// display answer
		cout << n << endl;
	}

	// end program
	return 0;
}
