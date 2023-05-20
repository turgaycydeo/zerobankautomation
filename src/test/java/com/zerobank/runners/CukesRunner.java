package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/zerobank/step_definitions",
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                //"me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt"},
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
