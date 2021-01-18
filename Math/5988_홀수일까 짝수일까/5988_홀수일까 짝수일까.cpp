#include <iostream>
#include <string>
using namespace std;

int main() {
	// set needed variables
	string number, last;
	int length, N, i;

	// get N
	cin >> N;

	// do process
	for (i = 0; i < N; i++) {
		cin >> number;
		length = number.size();
		last = number[length - 1];

		if ((last == "0") || (last == "2") || (last == "4") || (last == "6") || (last == "8"))
			cout << "even\n";
		else
			cout << "odd\n";
	}

	return 0;
}
