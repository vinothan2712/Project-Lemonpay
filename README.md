# Project-Lemonpay# Automation Test Engineer Assessment

##  Quick Start

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox browser
- Git
- Jenkins (for CI/CD)
-Jmeter

### Installation

```bash
# Clone the repository
git clone https://github.com/vinothan2712/Project-Lemonpay.git
cd Project-Lemonpay

# Install Maven dependencies
mvn clean install

```

## 🧪 Test Structure

```
src/
├── main/java/
│   ├── pages/           # Page Object Model classes
│   ├── utils/           # Utility classes and helpers
│   └── config/          # Configuration files
├── test/java/
│   ├── ui/              # Selenium Web UI tests
│   ├── api/             # REST API tests
│   └── performance/     # Performance test scripts
├── resources/
│   ├── testdata/        # Test data files
│   ├── config/          # Configuration properties
│   └── drivers/         # WebDriver binaries
└── reports/             # Test execution reports
```

## 🌐 Web UI Automation (Selenium + TestNG)

### Test Coverage
- **Login Tests**: Valid/invalid login attempts, session persistence
- **Product Filtering**: Price sorting verification
- **Cart Functionality**: Add/remove products, total calculation
- **Checkout Process**: Complete order flow validation
- **Edge Cases**: Empty cart checkout, responsive design testing

### Running UI Tests

```bash
# Run all UI tests
mvn test -Dtest=ui.*

# Run specific test class
mvn test -Dtest=LoginTest

# Run tests in headless mode
mvn test -Dtest=ui.* -Dheadless=true

# Run tests in parallel
mvn test -Dtest=ui.* -DthreadCount=3
```

### Test Data
- **Valid Users**: `standard_user`, `performance_glitch_user`
- **Invalid Users**: `locked_out_user`, invalid credentials
- **Test URL**: https://www.saucedemo.com/

## 🔌 API Automation (REST Assured)

### Test Coverage
- **Authentication**: Login validation, token management
- **Product Operations**: CRUD operations, schema validation
- **Cart Operations**: Add/remove items, quantity verification
- **Negative Scenarios**: Invalid parameters, error handling

### API Endpoints Tested

| Functionality | Endpoint | Method |
|--------------|----------|---------|
| Get all products | `/products` | GET |
| Get single product | `/products/{id}` | GET |
| Add to cart | `/carts` | POST |
| Get cart details | `/carts/{id}` | GET |
| User login | `/auth/login` | POST |

### Running API Tests

```bash
# Run all API tests
mvn test -Dtest=api.*

# Run specific API test suite
mvn test -Dtest=ProductAPITest

# Run with specific environment
mvn test -Dtest=api.* -Denv=staging
```

### Sample API Test Data

```json
{
  "login": {
    "username": "mor_2314",
    "password": "83r5^_"
  },
  "product": {
    "id": 1,
    "expectedPrice": 109.95
  }
}
```

## ⚡ Performance Testing ()

### Test Scenarios
- **Load Test**: 100 concurrent users on `/products` endpoint
- **Stress Test**: Gradual traffic increase until failure
- **Response Time**: `/auth/login` within 200ms threshold


```

### Performance Thresholds
- Response time: < 200ms (95th percentile)
- Error rate: < 1%
- Throughput: > 100 RPS

## 🔄 CI/CD Pipeline Integration

### GitHub Actions

The project includes automated CI/CD pipeline that:
- Triggers on every push and pull request
- Runs all test suites (UI, API, Performance)
- Generates and archives test reports
- Executes tests in headless mode for faster execution

### Pipeline Configuration

```yaml
# .github/workflows/test-automation.yml
name: Test Automation Pipeline

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Setup Java
        uses: actions/setup-java@v2
        with:
          java-version: '11'
      - name: Run Tests
        run: mvn clean test
      - name: Generate Reports
        run: mvn allure:report

## 📊 Test Reporting

### Allure Reports
- Detailed test execution reports with steps
- Screenshots on failure
- API request/response logs
- Performance metrics

### Generating Reports

```bash
# Generate Allure report
mvn allure:report

# Serve report locally
mvn allure:serve

# Generate Extent reports
mvn test -DgenerateExtentReport=true
```

### Report URLs
- **Allure Reports**: `target/site/allure-maven-plugin/`
- **Extent Reports**: `test-output/ExtentReports/`
- **Surefire Reports**: `target/surefire-reports/`

## 🛠️ Configuration

### Environment Configuration

```properties
# src/test/resources/config.properties
base.url=https://www.saucedemo.com
api.base.url=https://fakestoreapi.com
browser=chrome
headless=false
timeout=10
```

### Test Data Management
- External JSON files for test data
- Property files for environment configuration
- CSV files for data-driven testing

## 🎯 Advanced Features

### Screenshot on Failure
- Automatic screenshot capture on test failure
- Screenshots saved with timestamp
- Attached to Allure reports

### JSON Schema Validation
- API response schema validation
- Contract testing implementation
- Schema files in `src/test/resources/schemas/`

### Cross-Browser Testing
- Support for Chrome, Firefox, Safari
- Parallel execution across browsers
- Browser configuration via TestNG XML

## 🚀 Execution Commands

### Complete Test Suite
```bash
# Run all tests with reports
mvn clean test allure:report

# Run tests in different environments
mvn test -Denv=dev
mvn test -Denv=staging
mvn test -Denv=prod

# Run specific test groups
mvn test -Dgroups=smoke
mvn test -Dgroups=regression
mvn test -Dgroups=api
```


```

## 📝 Test Results

### Success Criteria
- All UI tests pass with 100% success rate
- API tests validate response schemas and performance
- Performance tests meet defined thresholds
- CI/CD pipeline executes successfully

### Sample Test Metrics
- **Total Tests**: 45
- **UI Tests**: 20
- **API Tests**: 20
- **Performance Tests**: 5
- **Execution Time**: ~15 minutes
- **Success Rate**: 98%

## 🔧 Troubleshooting

### Common Issues

1. **WebDriver Issues**
   ```bash
   # Update ChromeDriver
   mvn dependency:resolve
   ```

2. **API Connection Issues**
   ```bash
   # Check API connectivity
   curl https://fakestoreapi.com/products
   ```

3. **Report Generation Issues**
   ```bash
   # Clean and regenerate
   mvn clean compile test allure:report
   ```


## 🏆 Assessment Completion

This project successfully demonstrates:
- ✅ Web UI automation with Selenium and TestNG
- ✅ REST API testing with REST Assured
- ✅ Performance testing with JMeter
- ✅ CI/CD integration with GitHub Actions
- ✅ Comprehensive test reporting
- ✅ Advanced features like screenshot capture and schema validation

