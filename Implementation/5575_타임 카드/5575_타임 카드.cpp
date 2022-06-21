#include <iostream>
using namespace std;

int main() {
	// set needed varaibles
	int inH, inM, inS, outH, outM, outS, wH, wM, wS;
	int i;

	// do process for three person
	for (i = 0; i < 3; i++) {
		// get in time and out time
		cin >> inH >> inM >> inS >> outH >> outM >> outS;

		// calculate working time
		wH = outH - inH;
		wM = outM - inM;
		wS = outS - inS;

		// rearrange second
		if (wS < 0) {
			wS = 60 + wS;
			wM--;
		}
		// rearrange minute
		if (wM < 0) {
			wM = 60 + wM;
			wH--;
		}

		// display answer
		cout << wH << " " << wM << " " << wS << endl;
	}

	// end program
	return 0;
}
