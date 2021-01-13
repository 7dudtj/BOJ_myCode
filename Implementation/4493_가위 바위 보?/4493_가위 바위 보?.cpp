#include <iostream>
using namespace std;

void showAnswer(int totalScore);
int doGames(char var1, char var2);

int main() {
	// set needed variables
	int T, round, i, j, score;
	char one, two;

	// get T
	cin >> T;

	// do game for T times
	for (i = 0; i < T; i++) {
		// set default score
		score = 0;

		// get round number
		cin >> round;

		// do games
		for (j = 0; j < round; j++) {
			cin >> one >> two;
			score += doGames(one, two);
		}
		
		// show answer
		showAnswer(score);	
	}

	// end program
	return 0;
}

// answer displaying function
void showAnswer(int totalScore) {
	if (totalScore == 0) {
		cout << "TIE\n";
	}
	else if (totalScore > 0) {
		cout << "Player 2\n";
	}
	else {
		cout << "Player 1\n";
	}
};

// function doing games and checking score
int doGames(char var1, char var2) {
	int point = 0;

	if (var1 == var2) {
		point = point;
	}
	else if ((var1 == 'S') && (var2 == 'P')) {
		point--;
	}
	else if ((var1 == 'S') && (var2 == 'R')) {
		point++;
	}
	else if ((var1 == 'R') && (var2 == 'S')) {
		point--;
	}
	else if ((var1 == 'R') && (var2 == 'P')) {
		point++;
	}
	else if ((var1 == 'P') && (var2 == 'R')) {
		point--;
	}
	else {
		point++;
	}

	return point;
}
