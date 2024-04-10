#include <stdio.h>

int main(void)
{
    int N, M, i, j, tmp;
    int map[100][100];

    scanf("%d %d", &N, &M);

    /* Get map A */
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < M; j++)
        {
            scanf("%d", &tmp);
            map[i][j] = tmp;
        }
    }

    /* Add map B */
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < M; j++)
        {
            scanf("%d", &tmp);
            map[i][j] += tmp;
        }
    }

    /* Print answer */
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < M; j++)
        {
            printf("%d ", map[i][j]);
        }
        printf("\n");
    }
}