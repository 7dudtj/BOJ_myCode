#include <iostream>
using namespace std;

int main() {
	// set needed variables
	double FN, SN, answer;

	// set first number
	cin >> FN;

	// do process
	while (true) {
		// get second number
		cin >> SN;

		// find out if this program should finish
		if (SN == 999) {
			break;
		}

		// calculate
		answer = SN - FN;

		// set new value
		FN = SN;

		// display results
		cout.setf(ios::fixed);
		cout.showpoint;
		cout.precision(2);
		cout << answer << endl;
	}

	// end program
	return 0;
}
