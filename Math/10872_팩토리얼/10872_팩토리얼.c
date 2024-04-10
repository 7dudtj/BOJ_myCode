#include <stdio.h>

int main(void)
{
    int N, answer = 1, i;

    scanf("%d", &N);

    for (i = 1; i <= N; i++)
    {
        answer *= i;
    }

    if (N == 0)
    {
        printf("1");
    }
    else
    {
        printf("%d", answer);
    }
}