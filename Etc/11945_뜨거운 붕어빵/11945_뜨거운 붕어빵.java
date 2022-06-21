#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int N, M, i, j, count = 0;
	char *bung;

	// get N and M
	cin >> N >> M;

	// do process for N times
	while (true) {
		// set count
		count++;

		// check
		if (count > N) {
			break;
		}

		// make input list
		bung = new char[M + 1];

		// set default bung
		for (i = 0; i < M + 1; i++) {
			bung[i] = '*';
		}

		// get input
		cin >> bung;

		// display result
		for (j = M - 1; j >= 0; j--) {
			cout << bung[j];
		}
		cout << endl;

		// delete input list
		delete[] bung;
		bung = NULL;
	}

	// end program
	return 0;
}
