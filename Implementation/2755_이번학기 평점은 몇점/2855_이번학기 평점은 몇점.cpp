#include <iostream>
#include <string>
#include <cmath>
using namespace std;

double calculate(int level, string grade);

int main() {
	// set needed variables
	int T, level, totalLevel = 0;
	double totalGrade, calculateSum = 0;
	string lecture, grade;

	// get T
	cin >> T;

	// do process
	for (int i = 0; i < T; i++) {
		cin >> lecture >> level >> grade;
		totalLevel += level;
		calculateSum += calculate(level, grade);
	}

	// calculate total grade
	totalGrade = calculateSum / totalLevel;

	// do round
	double answer = (round(totalGrade * 100)) / 100;

	// set precision
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);

	// display answer
	cout << answer << endl;

	// end program
	return 0;
}

double calculate(int level, string grade) {
	double sum;

	if (grade == "A+") {
		sum = 4.3 * level;
	}
	else if (grade == "A0") {
		sum = 4.0 * level;
	}
	else if (grade == "A-") {
		sum = 3.7 * level;
	}
	else if (grade == "B+") {
		sum = 3.3 * level;
	}
	else if (grade == "B0") {
		sum = 3.0 * level;
	}
	else if (grade == "B-") {
		sum = 2.7 * level;
	}
	else if (grade == "C+") {
		sum = 2.3 * level;
	}
	else if (grade == "C0") {
		sum = 2.0 * level;
	}
	else if (grade == "C-") {
		sum = 1.7 * level;
	}
	else if (grade == "D+") {
		sum = 1.3 * level;
	}
	else if (grade == "D0") {
		sum = 1.0 * level;
	}
	else if (grade == "D-") {
		sum = 0.7 * level;
	}
	else if (grade == "F") {
		sum = 0;
	}

	return sum;
}
