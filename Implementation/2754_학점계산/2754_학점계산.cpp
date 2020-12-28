#include <iostream>
#include <string>
using namespace std;

int main() {
	// set needed variables
	string c_grade;

	// get user grade
	cin >> c_grade;

	// display answer
	if (c_grade == "A+") {
		cout << "4.3\n";
	}
	else if (c_grade == "A0") {
		cout << "4.0\n";
	}
	else if (c_grade == "A-") {
		cout << "3.7\n";
	}
	else if (c_grade == "B+") {
		cout << "3.3\n";
	}
	else if (c_grade == "B0") {
		cout << "3.0\n";
	}
	else if (c_grade == "B-") {
		cout << "2.7\n";
	}
	else if (c_grade == "C+") {
		cout << "2.3\n";
	}
	else if (c_grade == "C0") {
		cout << "2.0\n";
	}
	else if (c_grade == "C-") {
		cout << "1.7\n";
	}
	else if (c_grade == "D+") {
		cout << "1.3\n";
	}
	else if (c_grade == "D0") {
		cout << "1.0\n";
	}
	else if (c_grade == "D-") {
		cout << "0.7\n";
	}
	else {
		cout << "0.0\n";
	}

	// end program
	return 0;
}
