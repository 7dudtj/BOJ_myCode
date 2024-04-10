#include <stdio.h>

int main(void)
{
    int N, X, i;

    scanf("%d %d", &N, &X);

    int arr[10000];

    for (i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);

        if (arr[i] < X)
        {
            printf("%d ", arr[i]);
        }
    }
}