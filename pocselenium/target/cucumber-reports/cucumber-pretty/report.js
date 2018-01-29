$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("firstTest.feature");
formatter.feature({
  "line": 1,
  "name": "To search cucumber in google",
  "description": "",
  "id": "to-search-cucumber-in-google",
  "keyword": "Feature"
});
formatter.before({
  "duration": 979261164,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Cucumber Google",
  "description": "",
  "id": "to-search-cucumber-in-google;cucumber-google",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@SearchGoogle"
    },
    {
      "line": 2,
      "name": "@Web"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I am on google page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I type the word Cheese!",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I submit request",
  "keyword": "And "
});
formatter.match({
  "location": "SearchGooglePage.googlePage()"
});
formatter.result({
  "duration": 4023999716,
  "status": "passed"
});
formatter.match({
  "location": "SearchGooglePage.findElement()"
});
formatter.result({
  "duration": 65585919,
  "status": "passed"
});
formatter.match({
  "location": "SearchGooglePage.submitRequest()"
});
formatter.result({
  "duration": 2550015453,
  "status": "passed"
});
formatter.after({
  "duration": 232248,
  "status": "passed"
});
formatter.after({
  "duration": 68971770,
  "status": "passed"
});
});