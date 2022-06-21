#include <iostream>
using namespace std;

// functions
int intensity(int R, int G, int B);
char convertAscii(int input);

int main() {
	// set needed variables
	int N, M, i, j, r, g, b, asciiVal, charVal;
	char asciiMap[400][400];

	// get N and M
	cin >> N >> M;

	// get R, G, B and process
	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			cin >> r >> g >> b;
			asciiVal = intensity(r, g, b);
			charVal = convertAscii(asciiVal);
			asciiMap[i][j] = charVal;
		}
	}

	// display map
	for (i = 0; i < N - 1; i++) {
		for (j = 0; j < M - 1; j++) {
			cout << asciiMap[i][j];
		}
		cout << asciiMap[i][j];
		cout << endl;
	}
	i = N - 1;
	for (j = 0; j < M - 1; j++) {
		cout << asciiMap[i][j];
	}
	cout << asciiMap[i][j];
}

// calculate intensity function
int intensity(int R, int G, int B) {
	int intense = 0;

	intense = 2126 * R + 7152 * G + 722 * B;

	return intense;
}

// change intensity to ascii character
char convertAscii(int input) {
	if ((0 <= input) && (input < 510000))
		return '#';
	else if ((510000 <= input) && (input < 1020000))
		return 'o';
	else if ((1020000 <= input) && (input < 1530000))
		return '+';
	else if ((1530000 <= input) && (input < 2040000))
		return '-';
	else
		return '.';
}
