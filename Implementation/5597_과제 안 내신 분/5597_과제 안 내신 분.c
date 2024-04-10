#include <stdio.h>

int main(void)
{
    int arr[31], i, tmp;

    for (i = 0; i < 31; i++)
    {
        arr[i] = 0;
    }

    for (i = 0; i < 28; i++)
    {
        scanf("%d", &tmp);
        arr[tmp] = 1;
    }

    for (i = 1; i <= 30; i++)
    {
        if (arr[i] == 0)
        {
            printf("%d\n", i);
        }
    }
}