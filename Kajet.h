#ifndef __KAJET_TEST__
#define __KAJET_TEST__
#include <string>

using namespace std;

class Kajet {

public:
    int id;
    int pages;
	string type_of_pages;
	string color; 

    Kajet(int pages, string type_of_pages, int string color);
};