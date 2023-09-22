# google-cloud-calculator-testing

# Google Cloud Platform Pricing Calculator Automation Framework

## Project Description

This project is an automation framework designed for testing the Google Cloud Platform Pricing Calculator. The framework includes test scenarios for filling out the pricing calculator form, generating a temporary email address, and verifying the results. It has been developed with compatibility for Jenkins, allowing seamless integration into your continuous integration (CI) pipeline.

## Key Features

* **Selenium WebDriver Automation**: The project utilizes Selenium WebDriver to automate interactions with the Google Cloud Platform Pricing Calculator web application, ensuring efficient and reliable testing.
* **Page Object/Page Factory Pattern**: To enhance maintainability and readability, we have implemented the Page Object and Page Factory pattern, creating abstractions for web pages to streamline test development.
* **Business Object Models**: We've created business object models to represent key elements and data structures within the pricing calculator, making the automation more organized and intuitive.
* **XML Test Suites**: Test scenarios are organized into XML test suites, allowing for easy grouping and execution of tests based on specific criteria or requirements.
* **Screenshot Capture**: Screenshot capture functionality has been integrated to capture evidence of failed tests, aiding in debugging and issue identification.
* **Jenkins Integration**: The framework is configured for seamless integration with Jenkins. It supports parameterization for browser selection, test suite selection, and environment settings. Test results are displayed on Jenkins job charts for comprehensive reporting.
