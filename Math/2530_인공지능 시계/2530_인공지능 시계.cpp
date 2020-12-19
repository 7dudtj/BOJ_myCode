#include <iostream>
using namespace std;

int main() {
	// set needed variables
	int time, minute, second, plusTime;
	int addTime, addMinute, addSecond;
	int answerTime, answerMinute, answerSecond;

	// get time variables
	cin >> time >> minute >> second;
	cin >> plusTime;

	// calculate
	addSecond = plusTime % 60;
	answerSecond = (second + addSecond) % 60;
	addMinute = (plusTime / 60) + ((second + addSecond) / 60);
	answerMinute = (minute + addMinute) % 60;
	addTime = (minute + addMinute) / 60;
	answerTime = (time + addTime) % 24;

	// display results
	cout << answerTime << " " << answerMinute << " " << answerSecond << endl;

	// end program
	return 0;
}
