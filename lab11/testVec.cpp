#include <iostream>
#include <vector>

using namespace std;

vector<int> readVals(){
	vector<int> values;
	int val;
	cout<<"Enter numbers: ";
	while(cin >> val){
		values.push_back(val);
	}
	return values;
}

void printVals(vector<int> v){
	for(vector<int>::iterator i = v.begin(); i!=v.end();++i){
		cout<<*i<<" ";
	}
	cout<<endl;
}

int main(){
	vector<int> values = readVals();
	printVals(values);
	return 0;
}