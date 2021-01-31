#include <iostream>
using namespace std;

int main() {
	// set needed variables
	char number[12];
	int i, numberLen, num0 = 0, num1 = 0, num2 = 0, num8 = 0;

	// set default list
	for (i = 0; i < 12; i++) {
		number[i] = '*';
	}

	// get user input
	cin >> number;

	// find number length
	for (i = 0; i < 12; i++) {
		if (number[i] == '*') {
			numberLen = i - 1;
			break;
		}
	}

	// get data from input
	for (i = 0; i < numberLen; i++) {
		if (number[i] == '0') {
			num0++;
		}
		else if (number[i] == '1') {
			num1++;
		}
		else if (number[i] == '2') {
			num2++;
		}
		else if (number[i] == '8') {
			num8++;
		}
	}

	// find out if result is 0
	if ((num0 + num1 + num2 + num8) < numberLen) {
		cout << 0 << endl;
		exit(0);
	}

	// find out if result is 8
	if ((num0 == num1) && (num1 == num2) && (num2 == num8)) {
		cout << 8 << endl;
		exit(0);
	}
	// find out if result is 2
	else if ((num0 > 0) && (num1 > 0) && (num2 > 0) && (num8 > 0)) {
		cout << 2 << endl;
		exit(0);
	}
	// result is 1
	else {
		cout << 1 << endl;
		exit(0);
	}
}
