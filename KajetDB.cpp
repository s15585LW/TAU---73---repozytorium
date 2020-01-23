#include "KajetDB.h"
#include <algorithm>

using namespace std;

void KajetDB::add(Kajet *kajet) {
	kajet->id = db_counter;
	db_source.insert(make_pair(db_counter, kajet));
	db_counter++;
}

Kajet* KajetDB::find(int id) {
	return db_source.at(id);
}

void KajetDB::remove(int id) {
	db_source.erase(id);
}

void KajetDB::update(int id, Kajet *kajet) {
	db_source[id] = kajet;
}

std::vector<Kajet*> Database::getAll() {

	result.clear();

	for (auto i : db_source)
	{
		result.push_back(i.second);
	}

	return result;
}