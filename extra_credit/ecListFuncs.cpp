/*  Name: Tianqi Ren
 *  USC NetID: tianqire
 *  CS 455 Fall 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int numRuns(ListType list) {
	if(list == NULL){
		return 0;
	}
	Node *node = list;
	int count = 0;
	while(node->next != NULL){
		if(node->next->data == node->data){
			count++;
			while(node->next->data == node->data){
				node = node->next;
				if(node->next == NULL){
					break;
				}
			}
		}
		if(node->next != NULL){
			node = node->next;
		}
	}
  	return count;

}



ListType reverseCopy(ListType list) {
	if(list == NULL){
		return NULL;
	} 
	// copy all items into a new list
	Node *node = list;
	Node *nNode = new Node(node->data);
	Node *tmp = nNode;
	node = node->next;
	while(node!=NULL){
		tmp->next = new Node(node->data);
		tmp = tmp->next;
		node = node->next;
	}
	// reverse the newly created list
	Node *pre = NULL;
	Node *cur = nNode;
	Node *nex;
	while(cur->next != NULL){
		nex = cur->next;
		cur->next = pre;
		pre = cur;
		cur = nex;
	}
	cur->next = pre;
	return cur;
}



void removeMiddleElmt(ListType &list) {
	Node *node = list;
	int count = 0;
	if(node == NULL){
		return;
	}
	while(node!=NULL){
		node = node->next;
		count++;
	}
	if(count%2 !=0){
		count++;
	}
	if(count == 1){		// only one in list
		Node *tmp = list;
		list = NULL;
		delete tmp;
		return;
	}
	if(count == 2){		// two in list
		Node *tmp = list;
		list = list->next;
		delete tmp;
		return;
	}
	count = count/2;
	count--;
	node = list;
	while(count > 1){
		node = node->next;
		count--;
	}
	Node *tmp = node->next;
	node->next = node->next->next;
	delete tmp;

}



void splitOn(ListType &list, int splitVal, ListType &a, ListType &b) {
	if(list == NULL){
		return;
	}
	Node *aNode = a;
	Node *bNode = b;
	bool flag = false;	// we haven't met the splitVal in list
	while(list != NULL){
		if(list->data == splitVal && flag == false){
			flag = true;
		}else{
			if(flag == false){
				// the value join a
				if(aNode == NULL){
					aNode = list;
					a = aNode;
				}else{
					aNode->next = list;
					aNode = aNode->next;
				}
			}else{
				// the value join b
				if(bNode == NULL){
					bNode = list;
					b = bNode;
				}else{
					bNode->next = list;
					bNode = bNode->next;
				}
			}
		}
		list = list->next;
	}
	if(aNode != NULL){
		aNode->next = NULL;
	}
}
