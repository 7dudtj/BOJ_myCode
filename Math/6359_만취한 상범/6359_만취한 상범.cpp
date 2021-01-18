#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int T, n, i, j, k, h, total = 0;
	int *room;

	// get T
	cin >> T;

	// do process
	for (i = 0; i < T; i++) {
		// get n
		cin >> n;

		// set default room condition
		room = new int[n];
		for (j = 0; j < n; j++) {
			room[j] = 0;
		}

		// do process
		for (k = 0; k < n; k++) {
			for (h = 0; h < n; h++) {
				if (((h + 1) % (k + 1)) == 0) {
					if (room[h] == 0) {
						room[h] = 1;
					}
					else {
						room[h] = 0;
					}
				}
			}
		}

		// add how many go out
		for (j = 0; j < n; j++) {
			total += room[j];
		}

		// display result
		cout << total << endl;

		// reset total
		total = 0;
	}

	// end program
	return 0;
}
