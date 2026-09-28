

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import io.cucumber.junit.*;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("feature")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "steps"

)


@ConfigurationParameter(
        key=PLUGIN_PROPERTY_NAME,
        value="pretty,html:target/cucumber-report.html"
)
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@wip"
)

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {
}

//cucumber option reads
//featurefile
//filters using tags
//scenario mapping using tags
//scenario stepdefinition connection
//execute
//result