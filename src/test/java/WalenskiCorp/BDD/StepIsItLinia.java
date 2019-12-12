package WalenskiCorp.BDD;

import WalenskiCorp.Kajet;
import WalenskiCorp.KajetMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StepIsItLinia {

    KajetMethods kajet;
    private String choosenColor;
    private Integer choosenPages;

    private List<Kajet> listOfKajets = new ArrayList<>();    //Baza kajecikow

    @Given("Client decided to look at the kajet")
    public void client_decided_to_look_at_the_kajet() {
        kajet = new KajetMethods();
        KajetMethods.kajetList = new ArrayList<>();
        Collections.addAll(listOfKajets,
                new Kajet(5L, 128, "Linia", "Niebieski"),
                new Kajet(6L, 256, "Krata", "Czarny"),
                new Kajet(7L, 64, "Krata", "Seledynowy"),
                new Kajet(8L, 512, "Czysty", "Zielony"),
                new Kajet(9L, 128, "Krata", "Niebieski"));
    }

    @When("Client says Bring me all kajet color {string}")
    public void client_says_bring_me_all_kajet_kolor_Niebieski(String typePages) {
        this.choosenColor = typePages;
    }

    @When("Bring me all kajet with pages equal {int}")
    public void bring_me_all_kajet_with_page_equal(Integer pages) {
        this.choosenPages = pages;
    }

    @Then("Seller should brings him {int} kajet.")
    public void seller_should_brings_him_kajet(int number) {

        List<Kajet> filterShoes = listOfKajets.stream()
                .filter((Kajet sh) -> sh.getColor().equals(this.choosenColor))
                .filter((Kajet sh) -> sh.getPages().equals(this.choosenPages))
                .collect(Collectors.toList());
        Assert.assertEquals(number, filterShoes.size());
    }
}