#include <iostream>
using namespace std;

int main() {
	int n, k, i, j;
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> k;
		for (j = 0; j < k; j++) {
			cout << "=";
		}
		cout << endl;
	}
	return 0;
}
