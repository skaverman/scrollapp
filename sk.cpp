#include<iostream>
using namespace std;

int main(){
  /* int n,p=0,g=0,f=0;
   cout<<"enter the size off the array";

   cin>>n;
   int arr[n];
   cout<<"Enter the element of the array"; 
   for(int i=0;i<n;i++)
   {
      cin>>p;
      arr[i]=p;
      p=0;
   }
   for(int i=0;i<n;i++)
   {
      if(arr[i]==0)
      {
         f++;
      }
      else if(arr[i]==1)
      {
         g++;
      }
   }
    for(int i=0;i<g;i++)
   {
      cout<<"1";
   }
   for(int i=0;i<f;i++)
   {
    cout<<"0";
   }*/
  
/*int n;
cout<<"enter the value of n";
cin>>n;
int product=1;
for(int i=1; i<=n; i++){
   product*=n-i;
    

cout<<product;*/

/*int n,p=0,f=0,g=0;//sorts anarray in which first elemment is even and second is odd array should be taken from user

cout<<"enter the size of array";
cin>>n;
int arr[n];
cout<<"enter the value of elements of array";
for(int i=0; i<n; i++){
    cin>>p;
    arr[i]=p;
    p=0;
}
    for(int i=0; i<n; i++){
      
      if (arr[i]%2==0){
         f++;
         
      }else if(arr[i]%2==1){
         g++;
      }
for(int i=0; i<f; i++){
   cout<<arr[i];
}
   for(int i=0; i<g; i++){
      cout<<arr[i];
   }

      
  cout<<endl;  */
  int n,p=0,f=1;  // given a integer  array a sorted in non decreasing order return a array of square of each no. sorted in noon decreasing order
cout <<"enter the size of array ";
cin>>n;
int arr[n]; 
cout<<"enter the value of each elements of an array";
for(int i=0; i<n; i++){
   cin>>p;
   arr[i]=p;
   


}
for(int i=0; i<=n; i++)
{
   
   f=arr[i]*arr[i];
   
}
cout<<f;
   return 0; 
}