#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int T, BL, SL, i;

	// get T
	cin >> T;

	// do for T times
	for (i = 0; i < T; i++) {
		// get L
		cin >> BL >> SL;

		// calculate and display answer
		cout << (BL / SL) * (BL / SL) << endl;
	}

	// end program
	return 0;
}
