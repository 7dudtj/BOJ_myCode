#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int T, n;

	// get T
	cin >> T;

	// do process
	for (int i = 0; i < T; i++) {
		// get n
		cin >> n;

		// display answer
		if (n == 1) {
			cout << "Pairs for 1:" << endl;
		}
		else if (n == 2) {
			cout << "Pairs for 2:" << endl;
		}
		else if (n == 3) {
			cout << "Pairs for 3: 1 2" << endl;
		}
		else if (n == 4) {
			cout << "Pairs for 4: 1 3" << endl;
		}
		else if (n == 5) {
			cout << "Pairs for 5: 1 4, 2 3" << endl;
		}
		else if (n == 6) {
			cout << "Pairs for 6: 1 5, 2 4" << endl;
		}
		else if (n == 7) {
			cout << "Pairs for 7: 1 6, 2 5, 3 4" << endl;
		}
		else if (n == 8) {
			cout << "Pairs for 8: 1 7, 2 6, 3 5" << endl;
		}
		else if (n == 9) {
			cout << "Pairs for 9: 1 8, 2 7, 3 6, 4 5" << endl;
		}
		else if (n == 10) {
			cout << "Pairs for 10: 1 9, 2 8, 3 7, 4 6" << endl;
		}
		else if (n == 11) {
			cout << "Pairs for 11: 1 10, 2 9, 3 8, 4 7, 5 6" << endl;
		}
		else if (n == 12) {
			cout << "Pairs for 12: 1 11, 2 10, 3 9, 4 8, 5 7" << endl;
		}
	}

	// end program
	return 0;
}
