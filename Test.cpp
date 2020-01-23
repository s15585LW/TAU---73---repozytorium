#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Kajet.h"
#include "KajetDB.h"

using namespace std;

TEST_CASE("Tworzenie nowego kajetu") {
	Kajet *kajet = new Kajet(64, "Linie", "Zielony");

	REQUIRE(kajet->pages == 64);
	REQUIRE(kajet->type_of_pages == "Linie");
	REQUIRE(kajet->color == "Zielony");
}

TEST_CASE("Dodanie kajetow do DB i sprawdzenie czy prawidlowo przypisze") {
	KajetDB db = KajetDB();

	Kajet* kajet = new Kajet(128, "Krata", "Niebieski");
	Kajet* kajet2 = new Kajet(96, "Linie", "Czerwony");

	db.add(kajet);
	db.add(kajet2);

	REQUIRE(db.db_source[0]->type_of_pages == "Krata");
	REQUIRE(db.db_source[1]->pages == 96);
}

TEST_CASE("Wyszukiwanie po id") {
	KajetDB db = KajetDB();

	Kajet* kajet = new Kajet(128, "Krata", "Niebieski");
	Kajet* kajet2 = new Kajet(96, "Linie", "Czerwony");

	db.add(kajet);
	db.add(kajet2);

	REQUIRE(db.find(1)->pages == 96);
	REQUIRE(db.find(0)->color == "Niebieski");
}

TEST_CASE("Usuwanie z DB") {
	Database db = Database();

	Kajet* kajet = new Kajet(128, "Krata", "Niebieski");
	Kajet* kajet2 = new Kajet(96, "Linie", "Czerwony");

	db.add(kajet);
	db.add(kajet2);

	db.remove(1);

	CHECK_THROWS(db.find(1));
}

TEST_CASE("Zmiana danych w DB") {
	KajetDB db = KajetDB();

	Kajet* kajet = new Kajet(128, "Krata", "Niebieski");
	Kajet* kajet2 = new Kajet(96, "Linie", "Czerwony");

	db.add(kajet);
	db.add(kajet2);

	Kajet* poprawka_kajet2 = new Kajet(128, "Linie", "Zolty");
	
	REQUIRE(db.find(1)->color == "Czerwony");
	
	db.update(1, poprawka_kajet2);

	REQUIRE(db.find(1)->color == "Zolty");
}

TEST_CASE("Czy funckja getAll istnieje") {
	KajetDB db = KajetDB();

	REQUIRE_NOTHROW(db.getAll());
}

TEST_CASE("Zwroc pusty jesli uzyjemy getAll na pustej DB") {
	KajetDB db = KajetDB();

	vector<Kajet*> result = db.getAll();

	REQUIRE(result.size() == 0);
}

TEST_CASE("getAll returns vector with correct size") {
	KajetDB db = KajetDB();

	Kajet* kajet = new Kajet(128, "Krata", "Niebieski");
	Kajet* kajet2 = new Kajet(96, "Linie", "Czerwony");
	Kajet* kajet3 = new Kajet(256, "Czysty", "Bialy");
	Kajet* kajet4 = new Kajet(144, "Kancelaryjny", "Czarny");

	db.add(kajet);
	db.add(kajet2);
	db.add(kajet3);
	db.add(kajet4);

	vector<Kajet*> result = db.getAll();

	REQUIRE(result.size() == 4);
}