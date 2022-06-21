#include <iostream>
#include <cstdlib>
#include <ctime>

int main()
{
	srand(time(0));
	int list[6];
	int temprand;
	int i, j;
	for (i = 0; i < 6;)
	{
		temprand = rand() % 45 + 1;
		for (j = 0; j < i; j++)
		{
			if (list[j] == temprand)
			{
				break;
			}
		}
		if (j == i)
		{
			list[i] = temprand;
			i++;
		}
	}
	for (i = 0; i < 5; i++)
	{
		std::cout << list[i] << " ";
	}
	std::cout << list[5];
	return 0;
}
