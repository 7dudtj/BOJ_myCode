#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int N, i, j;

	// get user input
	cin >> N;

	// print stars
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) {
			cout << "*";
		}
		cout << endl;
	}
	
	// end program
	return 0;
}
