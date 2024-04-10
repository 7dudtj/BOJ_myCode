#include <stdio.h>

int main(void)
{
    int A, B;

    /* Main loop */
    while (scanf("%d %d", &A, &B) != EOF)
    {
        printf("%d\n", A + B);
    }
}