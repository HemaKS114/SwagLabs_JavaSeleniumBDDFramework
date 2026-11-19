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
4. Created feature folder under src/test/resources and created feature files in it based on pages.
5. created StepDef folder under src/test/java and created stepdef files based on pages.
6. created runner folder under src/test/java and created cucumberRunner file in it provided with cucumberoption
7. Run the cucumberRunner file as TestNG tests, it should generate the glues for the feature file lines.
8. Created a Github repository for versioning
9. Updated framework with the configuration of extent report
10. Updated the Jenkins file with triggers with each git push also installed ngrok for access the public host tunneling to keep activate the auto execution via jenkins

Framework Architecture:

It's a layered framework

1. Feature layer - consists of our test scenarios
2. Step Definition layer - consists of methods/glues that acts as bridge b/w test cases and code logics
3. Utitlities/Resuable components - CommonMethods and Config files to make the framework maintainance easy and resuable 
4. Json Files(Object Repo and test data repo) - Preferred JSON as it's lightweighted and easy to maintain when objects maintained separately from code logic.
5. Execution layer - Cucumber Runner, Hooks which helps us to execute our tests.
6. enhancement layer - Reporting(We can use extend report), Versioning(GitHub for versioning).

Execution flow:

1. Cucumber Runner triggers the execution, it has the path to feature file, step defnition and utility classes.
2. Hooks file is being executed first as it has @Before cucumber annotation mentioned, it will be executed before the scenario is been executed.
3. Test Scenarios from the feature file gets executed along with step definitions and its assosicated files.
4. Report is been generated once the execution is completed.

