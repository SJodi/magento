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

# Serenity Specific Configuration

The following configuration options are specific to the Serenity framework.

- **serenity.take.screenshots**: Set to `AFTER_EACH_STEP` to capture screenshots after each step.

- **ignore.failures.in.stories**: Set to `true` to ignore failures in stories.

- **webdriver.timeouts.implicitlywait**: Set the implicit wait timeout to 5000 milliseconds.

- **story.timeout.in.secs**: Set the story timeout to 3600 seconds.

- **serenity.maintain.session**: Set to `true` to maintain the session.

- **webdriver.wait.for.timeout**: Set the WebDriver wait timeout to 60000 milliseconds.

## Use Firefox in Private Browsing Mode

Configure the use of Firefox in private browsing mode with the following options:

- **webdriver.driver**: Set to `firefox` to use the Firefox browser.

- **webdriver.base.url**: The base URL for your application, set to https://magento.softwaretestingboard.com/.

- **webdriver.firefox.options.args**: Specify arguments for Firefox, in this case, `-private` for private browsing.

## Browser Dimensions

Set the dimensions for the browser window:

- **serenity.browser.width**: Set the browser width to 1366 pixels.

- **serenity.browser.height**: Set the browser height to 768 pixels.


## Running Tests

- The tests are located under `src/test/java`
- Use `mvn clean verify` to run all tests and generate the Serenity test report
- View the test report under `target/site/serenity/index.html` after test completion

