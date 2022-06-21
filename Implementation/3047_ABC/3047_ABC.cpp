#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// set needed variables
	int a, b, c, A, B, C, i;
	int finder[3];
	char order[4];

	// set default order
	for (i = 0; i < 4; i++) {
		order[i] = '*';
	}

	// get a, b, c
	cin >> a >> b >> c;

	// find out A, B, C
	finder[0] = a;
	finder[1] = b;
	finder[2] = c;
	sort(finder, finder + 3);
	A = finder[0];
	B = finder[1];
	C = finder[2];

	// get A, B, C order
	cin >> order;

	// display results
	for (i = 0; i < 3; i++) {
		if (order[i] == 'A') {
			cout << A << " ";
		}
		else if (order[i] == 'B') {
			cout << B << " ";
		}
		else {
			cout << C << " ";
		}
	}

	// end program
	return 0;
}
