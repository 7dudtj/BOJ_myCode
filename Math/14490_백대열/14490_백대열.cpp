#include <iostream>
#include <cmath>
using namespace std;

int main(){
	// 변수 설정
	char input[20];
	int i, checkPoint, endPoint, firstNum = 0, secondNum = 0,
		bNum = 0, sNum = 0, GCD;

	cin >> input; // 입력 받음

	// : 기준으로 자르기 위해 찾기
	for (i = 0; i < 20; i++)
	{
		if (input[i] == ':')
		{
			checkPoint = i;
			break;
		}
	}

	// 끝나는 지점 찾기
	for (i = 0; i < 20; i++)
	{
		if (input[i] == '\0')
		{
			endPoint = i;
			break;
		}
	}

	// char로 되어있는 애들을 int로 바꾸기 (앞 숫자)
	for (i = 0; i < checkPoint; i++)
	{
		firstNum += int(input[i] - 48) * int (round(pow(10, checkPoint - 1 - i) + 0.005));
	}

	// char로 되어있는 애들을 int로 바꾸기 (뒷 숫자)
	for (i = checkPoint + 1; i < endPoint; i++)
	{
		secondNum += int(input[i] - 48) * int (round(pow(10, endPoint -1 - i) + 0.005));
	}

	// big Number와 small Number 정렬
	if (firstNum >= secondNum)
	{
		bNum = firstNum;
		sNum = secondNum;
	}
	else
	{
		bNum = secondNum;
		sNum = firstNum;
	}

	// 최대공약수(GCD) 구하기
	while (true)
	{
		if ((bNum % sNum) == 0)
		{
			GCD = sNum;
			break;
		}
		else
		{
			int temp = bNum % sNum;
			bNum = sNum;
			sNum = temp;
		}
	}

	// 답 출력
	cout << firstNum / GCD << ":" << secondNum / GCD << endl;
}
