#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int i, j, k, count = 0, existence = 0;
	char name[11];

	// find FBI for 5 times
	for (i = 0; i < 5; i++) {
		// set default name
		for (k = 0; k < 11; k++) {
			name[k] = '*';
		}

		// get agents' name
		cin >> name;

		// set count
		count++;

		// find if FBI is in
		for (j = 0; j < 8; j++) {
			if (name[j] == 'F') {
				if (name[j + 1] == 'B') {
					if (name[j + 2] == 'I') {
						cout << count << endl;
						existence++;
						break;
					}
				}
			}
		}
	}

	// check if FBI not exists
	if (existence == 0) {
		cout << "HE GOT AWAY!" << endl;
	}

	// end program
	return 0;
}
