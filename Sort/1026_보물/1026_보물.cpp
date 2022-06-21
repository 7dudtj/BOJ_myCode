#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// set needed variables
	int S = 0, N, i;
	int *A, *B;

	// get N
	cin >> N;

	// make A and B
	A = new int[N];
	B = new int[N];

	// get A and B
	for (i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (i = 0; i < N; i++) {
		cin >> B[i];
	}

	// sort A and B
	sort(A, A + N);
	sort(B, B + N);

	// calculate S
	for (i = 0; i < N; i++) {
		S += A[i] * B[N - i - 1];
	}

	// display S
	cout << S << endl;

	// end program
	return 0;
}