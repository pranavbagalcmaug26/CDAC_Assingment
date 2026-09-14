#include<iostream>
#include<vector>
#include <string>
#include <utility>
using namespace std;
using Header=pair<string,string>;
using HeaderList=vector<Header>;
using Port=unsigned int;
using IPAddress=string;

typedef unsigned long long RequestId;

	void printHeaders(const HeaderList& Header){
		for(const auto& h:Header){
			cout<<h.first<<" : "<<h.second<<endl;
		}
	}

int main(){

	Port serverPort=8080;
	RequestId requestId =1748293847;
	HeaderList headers={
			{"Content-Type","application/json"},
			{"Authorization","Bearer eyJhbGci..."},
			{"Accept-Language","en-US"}
	};
	cout<<"Request ID : "<<requestId<<endl;
	cout<<"Server Port : "<<serverPort <<endl;
	cout<<"Headers: "<<endl;
	printHeaders(headers);

	return 0;
}
