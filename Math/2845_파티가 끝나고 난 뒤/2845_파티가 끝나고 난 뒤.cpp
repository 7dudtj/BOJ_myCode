#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int L, P, manifest, news1, news2, news3, news4, news5;

	// get L, P and calculate manifest
	cin >> L >> P;
	manifest = L * P;

	// get data from news
	cin >> news1 >> news2 >> news3 >> news4 >> news5;

	// display answer
	cout << news1 - manifest << " " << news2 - manifest << " "
		<< news3 - manifest << " " << news4 - manifest << " "
		<< news5 - manifest << endl;

	// end program
	return 0;
}
