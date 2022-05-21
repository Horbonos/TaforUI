Feature: Smoke

  Background:
    Given User opens homepage


  Scenario: Verify that the word correctly appears in the first paragraph
    When Switch to Russian language using one of the links
    Then Verify that the text of the first  element, which is the first paragraph, contains the word «рыба».

  Scenario: Let's verify that default setting result in text starting with Lorem ipsum
    When Press Generate Lorem Ipsum button
    Then Verify that the first paragraph starts with Lorem ipsum dolor sit amet, consectetur adipiscing elit

  Scenario Outline: Let's verify that Lorem Ipsum is generated with correct word size
    When Click on word button
    And Input '<value>' into the number field
    And Press Generate Lorem Ipsum button
    Then Verify the result has '<value>' words

    Examples:
      |     value    |
      |      -1      |
      |       0      |
      |       5      |
      |      10      |
      |      20      |

  Scenario Outline: Let's verify that Lorem Ipsum is generated with correct byte size
    When Click on byte button
    And Input '<value>' into the number field
    And Press Generate Lorem Ipsum button
    Then Verify the result has '<value>' bytes

    Examples:
      |     value    |
      |      -1      |
      |       0      |
      |       5      |
      |      10      |
      |      20      |


  Scenario: Let's verify the checkbox
    When Uncheck start with Lorem Ipsum checkbox
    And  Press Generate Lorem Ipsum button
    Then Verify that result no longer starts with Lorem ipsum dolor sit amet, consectetur adipiscing elit

  Scenario: Let's also check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%
    When Press Generate Lorem Ipsum button
    Then Run the generation 10 times and get the average number of paragraphs containing the word “lorem”
