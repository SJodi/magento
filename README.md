# Magento 

## Overview

This project performs automated UI testing on the Magento demo application using Serenity BDD and Selenium WebDriver.

## Environment Setup

The tests are run against the Magento demo site: https://magento.softwaretestingboard.com/

### Dependencies

- Java
- Maven
- Selenium
- Serenity BDD
- Firefox browser

### Configuration

The `serenity.properties` file contains the main configuration:

```
## Serenity specific configuration
serenity.take.screenshots=AFTER_EACH_STEP
ignore.failures.in.stories=true
webdriver.timeouts.implicitlywait=5000
story.timeout.in.secs=3600
serenity.maintain.session=true
webdriver.wait.for.timeout=60000

## Use Firefox in private browsing mode  
webdriver.driver=firefox
webdriver.base.url=https://magento.softwaretestingboard.com/
webdriver.firefox.options.args=-private

serenity.browser.width=1366
serenity.browser.height=768
```

## Running Tests

- The tests are located under `src/test/java`
- Use `mvn clean verify` to run all tests and generate the Serenity test report
- View the test report under `target/site/serenity/index.html` after test completion

