#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int T, r, e, c;

	// get T
	cin >> T;

	// do process for T times
	for (int i = 0; i < T; i++) {
		// get r, e, c
		cin >> r >> e >> c;

		if ((e - r) > c) {
			cout << "advertise" << endl;
		}
		else if ((e - r) == c) {
			cout << "does not matter" << endl;
		}
		else {
			cout << "do not advertise" << endl;
		}
	}

	// end program
	return 0;
}
