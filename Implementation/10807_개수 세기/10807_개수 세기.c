#include <stdio.h>

int main(void)
{
    int N, i, v, answer = 0;
    int arr[100];

    scanf("%d", &N);

    for (i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    scanf("%d", &v);

    for (i = 0; i < N; i++)
    {
        if (arr[i] == v)
        {
            answer += 1;
        }
    }

    printf("%d", answer);
}