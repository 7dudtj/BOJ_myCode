#include <iostream>
using namespace std;

int main() {
	// set neede variables
	long int N, M;
	
	// get user input
	cin >> N >> M;
	
	// check if N & M are same
	if (N == M)
		cout << "1\n";
	else
		cout << "0\n";
}
