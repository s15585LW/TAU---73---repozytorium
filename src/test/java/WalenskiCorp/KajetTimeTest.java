package WalenskiCorp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KajetTimeTest {

    private KajetMethods service = new KajetMethods();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    TimeStampInterface timeStamp;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    private void assertNotNull(long readTime) {
    }

    @Test
    public void testOfReadTimeOnReadMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn((long)222222);
        Kajet kajet = new Kajet(100L,32,"Linia","Brazowy");
        service.create(kajet);
        service.setTime(timeStamp.getTimeNow());
        service.read(100L);
        assertEquals(time, service.read(100L).getReadTime());
    }
    @Test
    public void testOfReadTimeOnReadAllMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet1 = new Kajet(101L,320,"Linia","Czarny");
        Kajet kajet2 = new Kajet(102L,540,"Krata","Zielony");
        Kajet kajet3 = new Kajet(103L,128,"Czysty","Fioletowy");

        service.create(kajet1);
        service.create(kajet2);
        service.create(kajet3);
        service.setTime(timeStamp.getTimeNow());

        assertEquals(time, service.readAll().get(0).getReadTime());
        assertEquals(time, service.readAll().get(1).getReadTime());
        assertEquals(time, service.readAll().get(2).getReadTime());
    }

    @Test
    public void testOfAddTimeOnCreateMethod() {
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(104L,42,"Adidas","white");
        service.setTime(timeStamp.getTimeNow());
        service.create(kajet);
        assertEquals(time, service.read(104L).getAddTime());
    }

    @Test
    public void testOfUpdateTimeOnUpdateMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet shoes = new Kajet(105L,420,"Czysty","Czarny");
        service.create(shoes);
        service.setTime(timeStamp.getTimeNow());
        Kajet expectedShoes = service.read(shoes.getId());
        expectedShoes.setPages(44);
        expectedShoes.setType_of_pages("Linie");
        expectedShoes.setColor("Różowy");
        service.update(expectedShoes);
        assertEquals(time, service.read(105L).getUpdateTime());
    }

    @Test
    public void testOfAllTimesInformationForReadMethod(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(106L,254,"Czysty","Zielony");
        service.setTime(timeStamp.getTimeNow());
        service.create(kajet);
        Kajet expectedShoes = service.read(kajet.getId());
        expectedShoes.setType_of_pages("Krata");
        service.update(expectedShoes);
        ArrayList<Long> listOfTimesMethods = new ArrayList<>();
        listOfTimesMethods.add(0, time);
        listOfTimesMethods.add(1, time);
        listOfTimesMethods.add(2, time);
        ArrayList<Long> listOfTimesForShoes = service.getAllTimesForKajet(106L);
        assertEquals(listOfTimesMethods, listOfTimesForShoes);
    }

    @Test
    public void testOfAddTimeDisabled(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(107L,430,"Krata","Pistacjowy");
        service.setTime(timeStamp.getTimeNow());
        service.setAddTimeDisabled();
        service.create(kajet);
        assertEquals(0,service.read(107L).getAddTime());
    }

    @Test
    public void testAddTimeDisabledAndEnabled(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet1 = new Kajet(108L,40,"Puma","yellow");
        Kajet kajet2 = new Kajet(109L,44,"Reabok","white");
        service.setTime(timeStamp.getTimeNow());
        service.setAddTimeDisabled();
        service.create(kajet1);
        service.setAddTimeEnabled();
        service.create(kajet2);
        assertEquals(0, service.read(108L).getAddTime());
        assertEquals(time, service.read(109L).getAddTime());
    }

    @Test
    public void testOfReadTimeDisabled(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(110L,44,"Puma","yellow");
        service.create(kajet);
        service.setTime(timeStamp.getTimeNow());
        service.setReadTimeDisabled();
        service.read(110L);
        assertEquals(0, service.read(110L).getReadTime());
    }

    @Test
    public void testReadTimeDisabledAndEnabled() {
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(111L,44,"Puma","yellow");
        service.create(kajet);
        service.setTime(timeStamp.getTimeNow());
        service.setReadTimeDisabled();
        service.read(111L);
        assertEquals(0, service.read(111L).getReadTime());
        service.setReadTimeEnabled();
        service.read(111L);
        assertEquals(time, service.read(111L).getReadTime());
    }

    @Test
    public void testOfUpdateTimeDisabled(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(112L,44,"Czyste","czarny");
        service.create(kajet);
        service.setTime(timeStamp.getTimeNow());
        service.setUpdateTimeDisabled();
        Kajet expectedShoes = service.read(kajet.getId());
        expectedShoes.setType_of_pages("Spalding");
        expectedShoes.setPages(44);
        expectedShoes.setColor("brown");
        service.update(expectedShoes);
        assertEquals(0,service.read(112L).getUpdateTime());
    }

    @Test
    public void testUpdateTimeDisabledAndEnabled(){
        long time = 222222;
        when(timeStamp.getTimeNow()).thenReturn(time);
        Kajet kajet = new Kajet(113L,44,"Krata","szary");
        service.create(kajet);
        service.setTime(timeStamp.getTimeNow());
        service.setUpdateTimeDisabled();
        Kajet expectedShoes = service.read(kajet.getId());
        expectedShoes.setType_of_pages("Czyste");
        expectedShoes.setPages(64);
        expectedShoes.setColor("Czerwony");
        service.update(expectedShoes);
        assertEquals(0,service.read(113L).getUpdateTime());
        service.setUpdateTimeEnabled();
        service.update(expectedShoes);
        assertEquals(time, service.read(113L).getUpdateTime());
    }

}