package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty",
                "json:target\\cucumber_json_reports\\home-page.json",
                "html:target\\home-page-html"},
        features={"D:\\Programming\\[Cucumber]\\Gianni Bruno - Cucumber Selenium Java\\Section06\\Section06_lecture35\\src\\test\\java\\Features"},
        glue={"Step_Definitions"},
        monochrome = true
)
public class Main_Runner {

}
