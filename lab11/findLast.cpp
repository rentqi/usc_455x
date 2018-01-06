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

int findLast(vector<int> v, int target){
	for(int i=v.size()-1;i>=0;--i){
		if(v[i]==target){
			return i;
		}
	}
	return -1;
}

void testFindLast(vector<int> v, int target){
	cout<<"find "<<target<<" in "<<endl;
	printVals(v);
	cout<<findLast(v, target)<<endl;
}

int main(){
	//vector<int> in1 = readVals();
	vector<int> in1;
	int nums [] = {1, -2, 0, 5, 3, 3, 5, 6, 1, 3, -4, -3, -5, 2};
	for(int i=0;i<sizeof(nums)/sizeof(nums[0]);i++){
		in1.push_back(nums[i]);
	}
	vector<int> in2 = valsGT0(in1);
	//testcase 1 = {1, -2, 0, 5, 3, 3, 5, 6, 1, 3, -4, -3, -5, 2} find 3
	testFindLast(in1, 3);
	cout<<"Expected result: 9"<<endl;
	//testcase 2 = {1, -2, 0, 5, 3, 3, 5, 6, 1, 3, -4, -3, -5, 2} find 100
	testFindLast(in1, 100);
	cout<<"Expected result: -1"<<endl;
	//testcase 3 = {1, 5, 3, 3, 5, 6, 1, 3, 2} find 5
	testFindLast(in2, 5);
	cout<<"Expected result: 4"<<endl;
	//testcase 4 = {1, 5, 3, 3, 5, 6, 1, 3, 2} find -3
	testFindLast(in2, -3);
	cout<<"Expected result: -1"<<endl;
	return 0;
}