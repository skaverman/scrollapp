#include <iostream>
using namespace std;


int main()
{
    int n,p=0,q,ans=0;
    cin>>n;
    cout<<"Enter the size of the aray";
    int arr[n];
    cout<<"Enter the elements of the array";
    for(int i=0; i<n;i++)
    {
         p=0;
        cin>>p;
        arr[i]=p;
    }
    for(int i=0; i<n;i++ )
    {
        cout<<(arr[i]*arr[i])<<endl;
    

    }
for(int i=0; i<=n; i++){
    

    if(arr[i+1]*arr[i+1]>arr[i]*arr[i]){
      cout<<arr[i+1]*arr[i+1]<<endl;
      ans++;
    }
    }



return 0;
}