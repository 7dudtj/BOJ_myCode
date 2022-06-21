#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int V, Anum = 0, Bnum = 0, i;
	char* vote;

	// get V
	cin >> V;

	// make vote pointer
	vote = new char[V];

	// get vote
	cin >> vote;

	// count
	for (i = 0; i < V; i++)
	{
		if (vote[i] == 'A')
			Anum++;
		else if (vote[i] == 'B')
			Bnum++;
	}

	// display answer
	if (Anum > Bnum)
		cout << "A" << endl;
	else if (Anum == Bnum)
		cout << "Tie" << endl;
	else if (Anum < Bnum)
		cout << "B" << endl;

	return 0;
}