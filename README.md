Tools & Technologies Used:

- Java (JDK 11+): Programming language
- Selenium WebDriver: Browser automation framework
- TestNG: Testing framework for structuring and running tests
- Maven: Project and dependency management
- WebDriverManager: Auto-manages browser drivers
- Eclipse IDE: Development environment

Project Structure:

QA-Assignments/
├── src/
│   └── test/
│       ├── java/
│       │   ├── Pages/           - Page Object classes
│       │   ├── Tests/           - Test classes with TestNG
│       │   └── Utility/         - Browser setup & Base class

├── pom.xml                      - Maven configuration


How to Run the Script:

1. Import Project into Eclipse:
   File → Import → Existing Maven Project → Select folder

2. Ensure Java and Maven are configured in Eclipse

3. Run via Class  (Eclipse):
   Right-click  → Run As → TestNG Class


What the Script Does:

- Opens homepage of AutomationExercise.com
- Searches for a product and verifies results
- Adds a product to the cart
- Asserts correct product name and price in cart
- Validates cart total after quantity update
