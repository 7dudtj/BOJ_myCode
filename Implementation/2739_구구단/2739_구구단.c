#include <stdio.h>

int main(void)
{
    int N, i;

    scanf("%d", &N);

    for (i = 1; i <= 9; i++)
    {
        printf("%d * %d = %d\n", N, i, N * i);
    }
}