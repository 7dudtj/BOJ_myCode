#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int T, i, j, wrongPosition;
	char word[81];

	// get number of testcase
	cin >> T;

	for (i = 0; i < T; i++) {
		// set default list
		for (j = 0; j < 81; j++) {
			word[j] = '*';
		}

		// get wrong position
		cin >> wrongPosition >> word;

		// display results
		for (j = 0; j < 81; j++) {
			if ((j != (wrongPosition - 1)) && (word[j] != '*') && (word[j] != '\0')) {
				cout << word[j];
			}
		}
		cout << endl;
	}

	// end program
	return 0;
}
