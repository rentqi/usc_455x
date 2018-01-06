#include <iostream>
#include <vector>

using namespace std;

vector<int> readVals(){
	vector<int> values;
	int val;
	cout<<"Vectors: ";
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

vector<int> valsGT0(vector<int> v){
	vector<int> res;
	for(vector<int>::size_type i = 0; i < v.size();++i){
		if(v[i] > 0){
			res.push_back(v[i]);
		}
	}
	return res;
}

int main(){
	vector<int> values = readVals();
	cout<<"Filtered vector: ";
	printVals(valsGT0(values));
	cout<<"Original vector: ";
	printVals(values);
	return 0;
}