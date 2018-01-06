// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

int * listLookUp(ListType &list, const string &target){
	Node *node = list;
	while(node != NULL){
		if(node->key == target){
			return &(node->value);
		}
		node = node->next;
	}
	return NULL;
}

bool listRemove(ListType &list, const string &target){
	Node *cur = list;
	if(list == NULL){
		return false;
	}
	Node *pre = NULL;
	// if the first key is the target
	if(cur->key == target){
		Node *tmp = NULL;
		tmp = list;
		list = list->next;
		delete tmp;
		return true;
	}

	// find the target and remove it
	while(cur->next != NULL){
		pre = cur;
		cur = cur->next;
		if(cur->key == target){
			pre->next = cur->next;
			delete cur;
			return true;
		}
	}

	return false;
}

bool listInsertFront(ListType &list, const string &target, int value){
	if(listLookUp(list, target) != NULL){
		return false;
	}else{
		Node *node = new Node(target, value, list);
		list = node;
		return true;
	}
}

int listNum(ListType &list){
	Node *node = list;
	int num = 0;
	while(node != NULL){
		num++;
		node = node->next;
	}
	return num;
}

void listPrint(ListType &list){
	Node *node = list;
	while(node != NULL){
		cout<<node->key<<" "<<node->value<<endl;
		node = node->next;
	}
}


