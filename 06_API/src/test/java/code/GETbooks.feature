Feature: GET Books

  Scenario: Given baseUrl When make Get call to books/:bookId Then Verify status code equal to 200 and get book information
    Given baseUrl
    When GET call to "books/:bookId"
    Then Verify status code equal to 200 and get book information