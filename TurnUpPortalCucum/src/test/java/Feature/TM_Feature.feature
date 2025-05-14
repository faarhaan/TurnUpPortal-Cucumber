Feature: TM_Feature

As a TurnUp Portal Admin user,
  I would like to create, edit and delete time and material records
  so that i can manage employees time and material successfully.

  @regression @CreateTimeRecord
  Scenario: Create Time Record with Valid Data
    Given  I Login to the Portal Successfully
    When   I navigate to Time and Material Page
    When   I create the time record successfully
    Then   Record should be created successfully

  @regression  @EditTimeRecord
  Scenario Outline: Edit existing time record with Valid Data
    Given    I Login to the Portal Successfully
    When     I navigate to Time and Material Page
    When     I update the '<Code>' and '<description>' on an existing Time Record
    Then     the record should have the updated '<Code>' and '<description>'
    Examples:
      | Code  |description|
      | alpha | gold      |
      | beta  | silver    |
      | gamma | bronze    |