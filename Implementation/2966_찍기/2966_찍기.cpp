#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int number, i, sangPoint = 0, changPoint = 0, hyeonPoint = 0, bigN;
	char answer[101];
	
	// set default answer
	for (i = 0; i < 101; i++) {
		answer[i] = '*';
	}

	// get number of questions
	cin >> number;

	// get answer
	cin >> answer;

	// find sang point
	for (i = 0; i < number; i++) {
		if ((i % 3) == 0) {
			if (answer[i] == 'A') {
				sangPoint++;
			}
		}
		if ((i % 3) == 1) {
			if (answer[i] == 'B') {
				sangPoint++;
			}
		}
		if ((i % 3) == 2) {
			if (answer[i] == 'C') {
				sangPoint++;
			}
		}
	}

	// find chang point
	for (i = 0; i < number; i++) {
		if ((i % 2) == 0) {
			if (answer[i] == 'B') {
				changPoint++;
			}
		}
		if ((i % 4) == 1) {
			if (answer[i] == 'A') {
				changPoint++;
			}
		}
		if ((i % 4) == 3) {
			if (answer[i] == 'C') {
				changPoint++;
			}
		}
	}

	// find hyeon point
	for (i = 0; i < number; i++) {
		if (((i % 6) == 0) || ((i % 6) == 1)) {
			if (answer[i] == 'C') {
				hyeonPoint++;
			}
		}
		if (((i % 6) == 2) || ((i % 6) == 3)) {
			if (answer[i] == 'A') {
				hyeonPoint++;
			}
		}
		if (((i % 6) == 4) || ((i % 6) == 5)) {
			if (answer[i] == 'B') {
				hyeonPoint++;
			}
		}
	}

	// find who gets most point
	bigN = sangPoint;
	if (changPoint > bigN) {
		bigN = changPoint;
	}
	if (hyeonPoint > bigN) {
		bigN = hyeonPoint;
	}

	// display answer
	if ((bigN == sangPoint) && (bigN == changPoint) && (bigN == hyeonPoint)) {
		cout << bigN << endl;
		cout << "Adrian\n";
		cout << "Bruno\n";
		cout << "Goran\n";
	}
	else if ((bigN == sangPoint) && (bigN == changPoint) && (bigN != hyeonPoint)) {
		cout << bigN << endl;
		cout << "Adrian\n";
		cout << "Bruno\n";
	}
	else if ((bigN == sangPoint) && (bigN != changPoint) && (bigN == hyeonPoint)) {
		cout << bigN << endl;
		cout << "Adrian\n";
		cout << "Goran\n";
	}
	else if ((bigN != sangPoint) && (bigN == changPoint) && (bigN == hyeonPoint)) {
		cout << bigN << endl;
		cout << "Bruno\n";
		cout << "Goran\n";
	}
	else if ((bigN == sangPoint)) {
		cout << bigN << endl;
		cout << "Adrian\n";
	}
	else if ((bigN == changPoint)) {
		cout << bigN << endl;
		cout << "Bruno\n";
	}
	else {
		cout << bigN << endl;
		cout << "Goran\n";
	}

	// end program
	return 0;
}
