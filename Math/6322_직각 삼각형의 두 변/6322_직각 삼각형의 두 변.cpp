#include <iostream>
#include <cmath>
using namespace std;

// answer showing function
void showAnswer(double result, int number, char line);

int main() {
	// set needed varaibles
	int a, b, c, count = 0;
	double answer;

	// calculation process
	while (true) {
		// get user input
		cin >> a >> b >> c;

		// find out if program will finish
		if ((a == 0) && (b == 0) && (c == 0)) {
			break;
		}

		// input sucess! let's count
		count++;

		// calculate
		// find a
		if (a == -1) {
			if ((c * c - b * b) <= 0) {
				cout << "Triangle #" << count << endl;
				cout << "Impossible.\n";
			}
			else {
				answer = sqrt(c * c - b * b);
				showAnswer(answer, count, 'a');
			}
		}
		// find b
		else if (b == -1) {
			if ((c * c - a * a) <= 0) {
				cout << "Triangle #" << count << endl;
				cout << "Impossible.\n";
			}
			else {
				answer = sqrt(c * c - a * a);
				showAnswer(answer, count, 'b');
			}
		}
		// find c
		else if (c == -1) {
			answer = sqrt(a * a + b * b);
			showAnswer(answer, count, 'c');
		}
		cout << endl;
	}

	// end program
	return 0;
}

// answer showing function
void showAnswer(double result, int number, char line) {
	// default setting
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(3);

	// show results
	cout << "Triangle #" << number << endl;
	cout << line << " = " << result << endl;
}
