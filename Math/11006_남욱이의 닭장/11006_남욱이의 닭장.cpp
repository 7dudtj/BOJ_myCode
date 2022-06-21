#include <iostream>
using namespace std;

int main()
{
    int T, M, N, i;
    
    cin >> T;
    
    for (i = 0; i < T; i++)
    {
        cin >> M >> N;
        cout << (N * 2 - M) << " " << (N - N * 2 + M) << endl;
    }
}
