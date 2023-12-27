Feature: login

Scenario: Test scenario
  Given Website is opened
  When User Entered valid username and password
  And User Clicked on AdminTab
  And Get number of records
  And Click on Add button
  And Choose Desired UserRole
  And Choose Employee Name
  And Choose Status
  And Set UserName
  And Set password
  And Click on save Button
  Then Verify that number of records increased by 1
  And Set UserName
  And Click on Search
  And Click on Delete
  Then Verify that number of records decreased by 1
