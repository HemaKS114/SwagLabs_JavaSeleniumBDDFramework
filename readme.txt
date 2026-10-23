Framework creation roadmap:
1. Project setup
	Eclipse, Maven, Java, Selenium WebDriver, Cucumber, JUnit or TestNG.
	Start here

2. BDD implementation
	Feature files, Gherkin scenarios, step definitions and the Cucumber runner.

3. Framework architecture
	Page Object Model, BasePage, reusable waits, configuration and test data.

4. Reporting and reliability
	Hooks, screenshots on failure, reports, tags, and parallel execution.

5. CI/CD
	Git, GitHub, Jenkins or GitHub Actions, and automated execution.

Framework Creation:
1. Create a maven project
2. Update pom.xml file, 
3. Created testNG file as it's required to run the cucumberrunner file with testng.
4. Created feature folder unser ssrc/test/resources and created feature files in it based on pages.
5. created StepDef folder under src/test/java and created stepdef files based on pages.
6. created runner folder under src/test/java and created cucumberRunner file in it provided with cucumberoption
7. Run the cucumberRunner file as TestNG tests, it should generate the glues for the feature file lines.
