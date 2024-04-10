#include <stdio.h>
#include <stdbool.h>

int main(void)
{
    int A, B;

    while (true)
    {
        scanf("%d %d", &A, &B);

        if (A == 0 & B == 0)
        {
            break;
        }

        printf("%d\n", A + B);
    }
}