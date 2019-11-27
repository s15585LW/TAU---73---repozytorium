package WalenskiCorp;
//import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class KajetMethodTest {

    private KajetMethods service = new KajetMethods();
    private ArrayList<Kajet> expectedKajet = new ArrayList<>();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        Kajet kajet1 = new Kajet(1L, 64, "Krata", "Szmaragd");//Random być nie może!!!!
        Kajet kajet2 = new Kajet(2L, 64, "Czysty", "Biały");
        Kajet kajet3 = new Kajet(3L, 92, "Linia", "Czarny");
        Kajet kajet4 = new Kajet(4L, 32, "Krata", "Niebieski");

        expectedKajet.clear();

        expectedKajet.add(kajet1);
        expectedKajet.add(kajet2);
        expectedKajet.add(kajet3);
        expectedKajet.add(kajet4);

        service.kajetList.clear();

        service.create(kajet1);
        service.create(kajet2);
        service.create(kajet3);
        service.create(kajet4);
    }

    @Test
    public void testForCreate() {
        Kajet expectedKajet = new Kajet(5L, 320, "Linie", "Szmaragdowy");
        Kajet actualKajet = service.create(expectedKajet);

        assertEquals(expectedKajet, actualKajet);
    }

    @Test
    public void testForReadAll() {
        List<Kajet> allKajet = service.readAll();

        assertEquals(expectedKajet.get(0), allKajet.get(0));
        assertEquals(expectedKajet.get(1), allKajet.get(1));
        assertEquals(expectedKajet.get(2), allKajet.get(2));
        assertEquals(expectedKajet.get(3), allKajet.get(3));
    }

    @Test
    public void testForReadById() {
        Kajet expected = expectedKajet.get(3);
        Kajet actualKajet = service.read(expected.getId());

        assertEquals(expected, actualKajet);
    }

    @Test
    public void testForReadByIdWhenObjectDoesNotExist() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("ID nie istnieje");
        service.read(1000000L);
    }

    @Test
    public void testForUpdate() {
        //pobrac obiekt zupdatowac i wczytac jescze raz
        Kajet item = service.read(expectedKajet.get(3).getId());
        item.setType_of_pages("Czysty");
        item.setColor("Granatowy");
        item.setPages(32);
        service.update(item);
        Kajet changed = service.read(expectedKajet.get(3).getId());
        assertEquals(item, changed);

    }

    @Test
    public void testForDelete() {
        //pobranie, usuniecie i czy wywali wyjatek
        Kajet taken = service.read(expectedKajet.get(3).getId());
        service.delete(taken.getId());
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("ID nie istenieje");
        service.read(taken.getId());
    }

    @Test
    public void testForDeleteWhenIdDoesNotExist() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("ID nie istnieje");
        service.delete(1000000L);
    }
}
