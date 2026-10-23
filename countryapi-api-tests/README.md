# Country API automation tests

Standalone Rest Assured and JUnit 5 tests for the Country API.

## Run

1. From the repository root, start the API on port 8080:

```powershell
.\mvnw.cmd spring-boot:run
```

2. In another terminal, change to this folder and run the tests plus Allure CLI setup:

```powershell
Set-Location .\countryapi-api-tests
..\mvnw.cmd test allure:install
```

3. Generate the HTML report:

```powershell
& '.\.allure\allure-2.30.0\bin\allure.bat' generate allure-results -o allure-report --clean
```

Open `allure-report/index.html`. Each test includes its HTTP status code and request/response details. A report overview screenshot is in `screenshots/allure-report.png`.

To use a different API URL, add `"-Dapi.baseUrl=http://localhost:8081"` to the Maven command.
