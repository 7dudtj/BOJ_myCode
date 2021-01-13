#include <iostream>
using namespace std;
int main() {
	int n, e;
	cin >> n;
	while (true) {
		cin >> e;
		if (e == 0) {
			break;
		}
		if ((e % n) == 0) {
			cout << e << " is a multiple of " << n << "." << endl;
		}
		else {
			cout << e << " is NOT a multiple of " << n << "." << endl;
		}
	}
	return 0;
}
