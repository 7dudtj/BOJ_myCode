#include <iostream>
using namespace std;

int GCD(int A, int B);
int LCM(int A, int B);

int main() {
	// get needed variables
	int a, b, T, i, lcm, gcd;

	// get T
	cin >> T;

	// calculate for T times
	for (i = 0; i < T; i++) {
		// get 'a' and 'b'
		cin >> a >> b;

		// calculate LCM and GCD
		lcm = LCM(a, b);
		gcd = GCD(a, b);

		// display answer
		cout << lcm << " " << gcd << endl;
	}

	// end program
	return 0;
}

// GCD function
int GCD(int A, int B)
{
	// R is rest
	int R;

	// GCD calculation process
	while (B != 0) {
		R = A % B;
		A = B;
		B = R;
	}

	// return GCD
	return A;
}

// LCM function
int LCM(int A, int B)
{
	// return LCM
	return A * B / GCD(A, B);
}
