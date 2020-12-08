#include <iostream>
using namespace std;

int main()
{
	// set needed variables
	int i, total;

	while (true)
	{
		// set default value
		char sentence[256];
		total = 0;
		for (i = 0; i < 256; i++)
			sentence[i] = '*';

		// get user input
		cin.getline(sentence, 256);
		cin.clear();

		// check if input is finished
		if (sentence[0] == '#')
			break;

		// check how many a, e, i, o, u are exist
		for (i = 0; i < 256; i++)
		{
			if ((sentence[i] - 65 == 0) || (sentence[i] - 65 == 4) || (sentence[i] - 65 == 8) || (sentence[i] - 65 == 14)
				|| (sentence[i] - 65 == 20) || (sentence[i] - 97 == 0) || (sentence[i] - 97 == 4) || (sentence[i] - 97 == 8)
				|| (sentence[i] - 97 == 14) || (sentence[i] - 97 == 20))
			{
				total++;
			}
		}
		cout << total << endl;
	}
	return 0;
}
