#include<iostream>
#include<memory>
#include<string>
using namespace std;

class AudioClip{
	string name;
	double duration;

public:
	AudioClip(string n,double d):name(n),duration(d){

	}
	string getName()const{
		return name;
	}
};
int main(){
	shared_ptr<AudioClip> audio=make_shared<AudioClip>("explosion",3.5);
	weak_ptr<AudioClip> w=audio;
	
	if(auto clip=w.lock())
		cout<<"Clip alive: "<<clip->getName()<<endl;

	audio.reset();
	if(w.expired())
		cout<<"Clip already unloaded."<<endl;
	
	return 0;
}
