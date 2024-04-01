#include <stdio.h>
#include <stdlib.h>

int main(void){
    long long int N, M;
    scanf("%lld %lld", &N, &M);
    printf("%lld", llabs(N - M));
}