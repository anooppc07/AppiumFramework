# language: en

@test
Feature: Login Feature

Scenario: Verifying the Login Functionality
Given I Am on the Login Page
When Click on Submit button
Then School Selection Container should be displayed
And On Selection School the Activity feed should be displayed
