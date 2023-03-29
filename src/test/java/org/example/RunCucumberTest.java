package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reports/html/report.html"},
        features = {"src/resources/org/example"},
        glue = {"org.example"})
public class RunCucumberTest {

}
