#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int e, f, c, N, R, D = 0;

	// get user input
	cin >> e >> f >> c;

	// do process
	while (true) {
		N = (e + f) / c;
		R = (e + f) % c;
		D += N;

		if ((N + R) >= c) {
			e = N;
			f = R;
		}
		else {
			break;
		}
	}

	// display result
	cout << D << endl;

	// end program
	return 0;
}
