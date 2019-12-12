package WalenskiCorp.BDD;

import WalenskiCorp.Kajet;
import WalenskiCorp.KajetMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class StepIsItDeleted {
    KajetMethods kajety;
    private String choosenType_of_Pages;
    private Integer choosenColor;

    @Given("Customer chooses a kajet from list and buy")
    public void customer_chooses_a_kajet_from_list_and_buy() {
        kajety = new KajetMethods();
        KajetMethods.kajetList = new ArrayList<>();
        Collections.addAll(KajetMethods.kajetList,
                new Kajet(10L, 64, "Linia", "Zielony"),
                new Kajet(11L, 512, "Krata", "Purpurowy"),
                new Kajet(12L, 1024, "Czysty", "Czarny"),
                new Kajet(13L, 64, "Czysty", "Turkusowy"),
                new Kajet(14L, 128, "Krata", "Niebieski"));
    }

    @When("Customer choose type of pages \"([^\"]*)\"$")
    public void customer_choose_type_of_pages(String pagesType) {
        choosenType_of_Pages = pagesType;
    }

    @When("Customer choose pages equal {int}")
    public void customer_choose_size_equal(Integer color) {
        choosenColor = color;
    }

    @Then("kajet has been bought and removed from list of kajet")
    public void shoes_has_been_bought_and_removed_from_list_of_kajet() {
        Kajet choosedKajet = kajety.readAll().stream()
                .filter(kajet -> kajet.getType_of_pages().equals(choosenType_of_Pages)
                        && kajet.getPages() == choosenColor).findFirst().get();
        assertEquals(choosedKajet, kajety.read(choosedKajet.getId()));
        kajety.delete(choosedKajet.getId());
        assertEquals(4, KajetMethods.kajetList.size());
    }
}
