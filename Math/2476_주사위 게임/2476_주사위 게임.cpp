#include <iostream>
#include <algorithm>
using namespace std;

// function list
int calculatePrice(int a, int b, int c);
void putPrice(int *list, int location, int price);
void priceSorting(int *list, int T);
void findAnswer(int *list, int T);

int main() {
	// set needed variables
	int T, i, A, B, C, price;
	int *priceList;

	// get number of test case
	cin >> T;

	// make price pointer list
	priceList = new int[T];

	// do calculate for T times
	for (i = 0; i < T; i++) {
		// get number of dice
		cin >> A >> B >> C;

		// get price
		price = calculatePrice(A, B, C);

		// put price to priceList
		putPrice(priceList, i, price);
	}

	// sorting price
	priceSorting(priceList, T);

	// find out answer
	findAnswer(priceList, T);

	// end program
	return 0;
}

// price calculation function
int calculatePrice(int a, int b, int c) {
	int totalPrice;

	// if a = b = c
	if ((a == b) && (b == c)) {
		totalPrice = 10000 + a * 1000;
	}
	// if a == b != c
	else if ((a == b) && (b != c)) {
		totalPrice = 1000 + a * 100;
	}
	// if a == c != b
	else if ((a == c) && (b != c)) {
		totalPrice = 1000 + a * 100;
	}
	// if b == c != a
	else if ((c == b) && (b != a)) {
		totalPrice = 1000 + b * 100;
	}
	// if a != b != c
	else {
		// set needed variables
		int bigN;

		// find out which number is most big
		bigN = a;
		if (b > bigN) {
			bigN = b;
		}
		if (c > bigN) {
			bigN = c;
		}

		totalPrice = bigN * 100;
	}

	// return totalPrice
	return totalPrice;
};

// putting price function
void putPrice(int *list, int location, int price) {
	// put value to list
	list[location] = price;
};

// price sorting function
void priceSorting(int *list, int T) {
	sort(list, list + T);
};

// answer finding function
void findAnswer(int *list, int T) {
	cout << list[T - 1] << endl;
};
