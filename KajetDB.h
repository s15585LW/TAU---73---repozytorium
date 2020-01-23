#ifndef __KAJETDB_TEST__
#define __KAJETDB_TEST__

#include "Kajet.hpp"
#include <map>
#include <vector>

using namespace std;

class KajetDB {

public:
	void add(Kajet *kajet);
	void remove(int id);
	void update(int id, Kajet* Kajet);
	
	Kajet* find(int id);
	vector<Kajet*> getAll();

	map<int, Kajet*> db_source;

private:
	int db_counter = 0;
	vector<Kajet*> result;
};