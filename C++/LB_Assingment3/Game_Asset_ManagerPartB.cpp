#include<iostream>
#include<string>
#include<memory>
using namespace std;
class Shader{
	string name;
	string type;

public:
	Shader(string n,string t):name(n),type(t){
		cout<<"[Shader Compiled]"<<endl;
	}
	~Shader(){
		cout<<"[Shader Destroyed]"<<endl;
	}

	int getReferenceCount(const shared_ptr<Shader>& shader)
	{
	    return shader.use_count();
	}
};


int main(){
	shared_ptr<Shader> shader=make_shared<Shader>("main_vertex","vertex");
	cout<<"Ref count: "<<shader->getReferenceCount(shader)<<endl;
	{
		shared_ptr<Shader> shader2=shader;
		cout<<"Ref count: "<<shader->getReferenceCount(shader)<<endl;

		shared_ptr<Shader> shader3=shader;
		cout<<"Ref count: "<<shader->getReferenceCount(shader)<<endl;
	}
	cout<<"Ref count: "<<shader->getReferenceCount(shader)<<endl;
	return 0;
}
