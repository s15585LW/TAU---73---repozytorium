package WalenskiCorp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class KajetTest {

    @Test
    public void classImplementationTest(){
        assertNotNull(new Kajet());
    }

    @Test
    public void isObjectAbleToInstantiate(){
        assertNotNull(new Kajet(1L,64,"Krata","Czarny"));
    }

    @Test
    public void isPropertiesAreProperlyAssigned() {
        Kajet kajet = new Kajet(1L,64,"Krata","Czarny");
        assertEquals(Long.valueOf(1), kajet.getId());
        assertEquals(Integer.valueOf(64), kajet.getPages());
        assertEquals("Krata", kajet.getType_of_pages());
        assertEquals("Czarny", kajet.getColor());

        assertEquals("Alabastrowy ", kajet.getColor());
    }
}
