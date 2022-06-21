#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    // set needed vairables
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> v, vc;

    // get n
    cin >> n;

    // get vector
    int a = 0;
    for (int i = 0; i < n; i++){
        cin >> a;
        v.push_back(a);
        vc.push_back(a);
    }

    // sort
    sort(vc.begin(), vc.end());

    // erase duplicates
    vc.erase(unique(vc.begin(), vc.end()), vc.end());

    // find and print answer
    for (int i = 0; i < n; i++){
        cout << lower_bound(vc.begin(), vc.end(), v[i]) - vc.begin() << " ";
    }

    return 0;
}