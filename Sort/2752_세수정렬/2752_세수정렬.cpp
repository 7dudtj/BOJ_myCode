#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	// set needed variables
	int A, B, C;
	int array[3];

	// get user input
	cin >> A >> B >> C;
	array[0] = A;
	array[1] = B;
	array[2] = C;

	// rearrange
	sort(array, array + 3);

	// display answer
	cout << array[0] << " " << array[1] <<  " " << array[2] << endl;
}
