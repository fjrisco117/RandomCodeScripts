#include <iostream>
#include <string>
//#include <cstring>
using namespace std;

struct test1{
    string your_name;
    int num;
};

void hello_world(){
    
    cout<<endl;
    cout<<"Hello World"<<endl;
}

int main(){
    auto num = 0;
    auto n = 0;
    //string name;
    
    int nonsense[3];
    cout<<"hi; enter number!"<<endl;
    
    while(n<3){
      cin>>num;
      nonsense[n]=num;
      n++;
    }
    n=0;
    
    cout<<"Numbers in array are : ";
    
    while(n<3){
        cout<<nonsense[n]<<" ";
        n++;
    }
    
    cin.ignore();
    
    hello_world();
    
    test1 guest = 
    {
      "Joe Doe",
      17
    };
    
    cout<<"Name is "<<guest.your_name<<endl;
    
    //cout<<"Enter string"<<endl;
    //getline(cin, name);
    //cout<<"your number is: "<<num<<endl;
    //cout<<sizeof(double)<<endl;
    //int length = strlen(name);//<<endl;
    //cout<<"your string is: "<<name<<endl;
    //cout<<"your string length is "<<name.length()<<endl;
    
    return 0;
}
  