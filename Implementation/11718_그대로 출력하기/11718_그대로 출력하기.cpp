#include <iostream>
#include <string>
using namespace std;

int main() {
	// set needed variables
	string str;

	// do process while user inputs sentences
	while (getline(cin, str)) {
		cout << str << endl;
	}
}
