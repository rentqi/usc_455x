// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*

  bool flag = true;
  string cmd;
  string name = "";
  int score = 0;

  while(flag){
    cout<<"cmd>";
    cin>>cmd;

    if(cmd == "insert"){  // insert a name and score
      cin>>name>>score;
      // insert the name and score pair
      if(!grades->insert(name, score)){
        cout<<"the name already exist."<<endl;
      }
    }else if(cmd == "change"){  // change the score for a name
      cin>>name>>score;
      // check if the name exists
      if(grades->lookup(name) == NULL){
        cout<<"the name does not exist"<<endl;
      }else{
        *grades->lookup(name) = score;
      }
    }else if(cmd == "lookup"){
      cin>>name;
      // check if the name exists
      if(grades->lookup(name) == NULL){
        cout<<"the name does not exist"<<endl;
      }else{
        cout<<name<<"'s score is: "<<*grades->lookup(name)<<endl;
      }
    }else if(cmd == "remove"){
      cin>>name;
      if(!grades->remove(name)){
        cout<<"the name does not exist"<<endl;
      }
    }else if(cmd == "print"){
      grades->printAll();
    }else if(cmd == "size"){
      cout<<grades->numEntries()<<endl;
    }else if(cmd =="stats"){
      grades->hashStats(cout);
    }else if(cmd =="help"){
      cout<<"insert name score: insert a name and score in the grade table"<<endl;
      cout<<"change name score: change the score for a name"<<endl;
      cout<<"lookup name: lookup a name and print out his/her score"<<endl;
      cout<<"remove name: remove this student"<<endl;
      cout<<"print: print out all names and scores in the table"<<endl;
      cout<<"size: print out the number of entries"<<endl;
      cout<<"stats: print out statistics about the hash table at this table"<<endl;
      cout<<"help: print out a brief command summary"<<endl;
      cout<<"quit: exit the program"<<endl;
    }else if(cmd == "quit"){
      flag = false;
    }else{
      cout<<"ERROR: invalid command"<<endl;
    }



  }

  return 0;
}
