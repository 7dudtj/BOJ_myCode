#include <iostream>
using namespace std;

// set answer list
long long answerList[68];

// get koong function
long long getKoong(int N);

int main() {
	// set needed variables
	int t, n, i;
	long long koongValue;

	// get t
	cin >> t;

	// do proess for t times
	for (i = 0; i < t; i++) {
		// get value n
		cin >> n;

		// display value
		koongValue = getKoong(n);
		cout << koongValue << endl;
	}

	// end program
	return 0;
}

// get koong function
long long getKoong(int N) {
	int i;

	if (N == 0) {
		answerList[0] = 1;
	}
	else if (N == 1) {
		answerList[1] = 1;
	}
	else if (N == 2) {
		answerList[2] = 2;
	}
	else if (N == 3) {
		answerList[3] = 4;
	}
	else {
		answerList[0] = 1;
		answerList[1] = 1;
		answerList[2] = 2;
		answerList[3] = 4;
		for (i = 4; i <= N; i++) {
			answerList[i] = answerList[i - 1] + answerList[i - 2] +
				answerList[i - 3] + answerList[i - 4];
		}
	}

	return answerList[N];
};
