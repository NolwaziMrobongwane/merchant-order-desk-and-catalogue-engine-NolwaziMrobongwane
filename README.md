PayNest Merchant Order Desk and Catalogue Engine
Project Description
PayNest is a Java console application developed to help small merchants manage customers, products and orders.

The application creates customer-linked orders, calculates individual item subtotals and overall order totals, and prints a receipt in South African Rand.

It demonstrates object-oriented programming, input validation, accurate monetary calculations and separation of responsibilities.

Technologies Used
Java 21
Apache Maven
JUnit 5
BigDecimal for monetary calculations
Project Structure
The application follows a simple object-oriented design using three packages:

Domain (com.paynestsystem.domain)

Customer stores customer information.
Product represents catalogue products and their prices.
OrderItem links a product to a quantity and calculates its subtotal.
Order manages order items and calculates the grand total.
Service (com.paynestsystem.service)

OrderService creates orders and coordinates receipt printing.
ReceiptPrinter displays customer details, purchased items and formatted totals.
Application (com.paynestsystem.app)

PayNestApplication contains the main method and demonstrates the complete ordering process.
Business Rules
Customer, product and order IDs must be positive.
Customer names, email addresses and product names cannot be blank.
Product prices cannot be null or negative.
Orders must have a valid customer.
Products cannot be null when added to orders.
Product quantities must be positive integers.
Empty orders have a total of zero.
Monetary calculations use BigDecimal.
Receipts display amounts in South African Rand with two decimal places.
Design Decisions
Accurate calculations: BigDecimal avoids floating-point precision problems. Line subtotals are calculated by multiplying the unit price by the quantity. The order total is the sum of all line subtotals.

Encapsulation: Domain fields are private. The order item collection is exposed through an unmodifiable list to prevent external modification.

Separation of responsibilities: Domain classes manage business data and calculations. OrderService coordinates order operations, while ReceiptPrinter handles console output.

Extensibility: Products are represented as independent objects, allowing the catalogue to grow without changing the order calculation logic.

How to Build and Test
Ensure Java 21 and Apache Maven are installed.

From the project root, run:

mvn clean test
This command compiles the application and runs the JUnit tests.

Verification note: Maven test execution is currently blocked in the development environment by an SSL certificate validation error (PKIX path building failed) when downloading Maven plugins. Successful execution of the full Maven test suite has therefore not yet been confirmed.

How to Run
Compile the application:

mvn compile
Run the main class using Java:

java -cp target/classes com.paynestsystem.app.PayNestApplication
These commands require Maven dependencies and plugins to be available. Alternatively, run PayNestApplication.main() directly from IntelliJ IDEA.

Example Receipt
The sample application creates an order containing one laptop and two mice.

======== PAYNEST RECEIPT ========
Order #: 1001
Customer: Nolwazi
Email: nolwazi.mrobongwane@umuzi.org
--------------------------------------
Laptop x 1 = R12,000.00
Mouse x 2 = R500.00
--------------------------------------
Total: R12,500.00
===================================
Illustrative output. Exact currency spacing and separators may vary depending on Java’s locale formatting.

Testing
JUnit 5 tests cover:

Order item subtotal calculations
Grand total calculations
Empty orders
Zero and negative quantities
Null products and customers
Decimal-price calculations
Large-quantity calculations
Receipt content and validation
Future Improvements
Potential enhancements include persistent product storage, order status tracking, inventory management and payment integration.

Author:
Nolwazi Mrobongwane