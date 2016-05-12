$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Homepage",
  "description": "",
  "id": "homepage",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User accesses home page",
  "description": "",
  "id": "homepage;user-accesses-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@full_regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User goes to homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify sweetgreen logo is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "homePage_steps.userGoesToHomepage()"
});
formatter.result({
  "duration": 22838278921,
  "status": "passed"
});
formatter.match({
  "location": "homePage_steps.verifySweetgreenLogoIsDisplayed()"
});
formatter.result({
  "duration": 2665331,
  "status": "passed"
});
formatter.after({
  "duration": 194554756,
  "status": "passed"
});
formatter.uri("SmokeTest.feature");
formatter.feature({
  "line": 1,
  "name": "Smoke Tests",
  "description": "",
  "id": "smoke-tests",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User accesses online ordering",
  "description": "",
  "id": "smoke-tests;user-accesses-online-ordering",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@full_regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User goes to homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "make sure the page is displayed properly",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "click orderonline button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user should be redirected to ordering site",
  "keyword": "Then "
});
formatter.match({
  "location": "homePage_steps.userGoesToHomepage()"
});
formatter.result({
  "duration": 19124668935,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.makeSureThePageIsDisplayedProperly()"
});
formatter.result({
  "duration": 17603268071,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.clickOrderonlineButton()"
});
formatter.result({
  "duration": 309055976,
  "status": "passed"
});
formatter.match({
  "location": "smokeTest.userShouldBeRedirectedToOrderingSite()"
});
formatter.result({
  "duration": 4435196452,
  "status": "passed"
});
formatter.after({
  "duration": 137595103,
  "status": "passed"
});
});