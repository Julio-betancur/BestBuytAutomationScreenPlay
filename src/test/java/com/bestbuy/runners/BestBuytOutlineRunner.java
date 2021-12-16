package com.bestbuy.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/BestBuyOutline.feature",
        glue = "com.bestbuy.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class BestBuytOutlineRunner {
}
