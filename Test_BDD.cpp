#include "catch.hpp"
#include "KajetDB.h"
#include "Kajet.h"

SCENARIO("Usun pozycje z DB") {

	GIVEN("Database with product") {
		KajetDB db = KajetDB();

		Kajet* kajet = new Kajet(64, "Krata", "Brazowy");

		db.add(kajet);

		CHECK_NOTHROW(db.find(0));

		WHEN("Kajet zostal usuniety") {
			db.remove(0);

			THEN("Kajet nie istenieje w DB") {
				CHECK_THROWS(db.find(0));
			}
		}
	}
}