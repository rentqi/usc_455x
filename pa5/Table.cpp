// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
	hashSize = HASH_SIZE;
	hashTable = new Node*[HASH_SIZE];
	for(int i=0;i<hashSize;i++){
		hashTable[i] = NULL;
	}
}


Table::Table(unsigned int hSize) {
	hashSize = hSize;
	hashTable = new Node*[hSize];
	for(int i=0;i<hSize;i++){
		hashTable[i] = NULL;
	}
}


int * Table::lookup(const string &key) {
	Node *node = hashTable[hashCode(key)];
  	return listLookUp(node, key);
}

bool Table::remove(const string &key) {
  ListType &node = hashTable[hashCode(key)];
	//Node *node = hashTable[hashCode(key)];
  	return listRemove(node, key);
}

bool Table::insert(const string &key, int value) {
  ListType &node = hashTable[hashCode(key)];
	//Node *node = hashTable[hashCode(key)];
  	return listInsertFront(node, key, value);
}

int Table::numEntries() const {
  	int sum = 0;
  	for(int i=0;i<hashSize;i++){
  		sum += listNum(hashTable[i]);
  	}
  	return sum;
}


void Table::printAll() const {
	for(int i=0;i<hashSize;i++){
		listPrint(hashTable[i]);
	}
}

void Table::hashStats(ostream &out) const {
  	int numEnt = numEntries();
  	int numBuckets = hashSize;
  	int nonEmpBuckets = 0;
  	for(int i=0;i<hashSize;i++){
  		if(hashTable[i] != NULL){
  			++nonEmpBuckets;
  		}
  	}
  	int maxChain = 0;
  	for(int i=0;i<hashSize;i++){
  		int lNum = listNum(hashTable[i]);
  		if(lNum > maxChain){
  			maxChain = lNum;
  		}
  	}
  	// print the result
  	out<<"number of buckets: "<<numBuckets<<endl;
  	out<<"number of entries: "<<numEnt<<endl;
  	out<<"number of non-empty buckets: "<<nonEmpBuckets<<endl;
  	out<<"longest chain: "<<maxChain<<endl;
}


// add definitions for your private methods here
