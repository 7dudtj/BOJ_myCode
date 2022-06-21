#include <iostream>
using namespace std;
int main() {
	int firstA, getA, total;
	char calculator;
	cin >> firstA;
	total = firstA;
	while (true) {
		cin >> calculator;
		if (calculator == '=') {
			cout << total;
			break;
		}
		cin >> getA;
		switch (calculator) {
		case '+':
			total += getA;
			break;
		case '-':
			total -= getA;
			break;
		case '*':
			total *= getA;
			break;
		case '/':
			total /= getA;
			break;
		}
	}
}
