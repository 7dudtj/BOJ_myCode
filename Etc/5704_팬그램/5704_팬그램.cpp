#include <iostream>
using namespace std;

// checking function
int* checkProcess(int list[], char sentence[]);

// checking pangram function
void checkPangram(int list[]);

int main() {
	// set needed variables
	char input[201];
	int i;
	int *checkList;
	

	// do process
	while (true) {
		checkList = new int[26];

		// set default input
		for (i = 0; i < 201; i++) {
			input[i] = '*';
		}

		// set default checkList
		for (i = 0; i < 26; i++) {
			checkList[i] = 0;
		}

		// get user input
		cin.getline(input, 201);

		// check if program will run
		if (input[0] == '*') {
			break;
		}

		// check input and get list
		checkList = checkProcess(checkList, input);
		
		// determine if it is pangram or not
		checkPangram(checkList);

		// delete pointer data
		delete[] checkList;
		checkList = NULL;
	}

	// end program
	return 0;
}

// checking function
int* checkProcess(int list[], char sentence[]) {
	// set needed variables
	int i;

	// read sentence
	for (i = 0; i < 201; i++) {
		if ((sentence[i] - 97 >= 0) && (sentence[i] - 97 <= 25)) {
			list[sentence[i] - 97]++;
		}
	}

	// send list data
	return list;
}

// checking pangram function
void checkPangram(int list[]) {
	// set needed variables
	int i, checkPoint = 1;

	// check if it is pangram or not
	for (i = 0; i < 26; i++) {
		if (list[i] == 0) {
			checkPoint = 0;
			break;
		}
	}

	// display results
	if (checkPoint == 1) {
		cout << "Y\n";
	}
	else {
		cout << "N\n";
	}
}
