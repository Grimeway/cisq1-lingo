Feature: start game
  As a user
  I want to play the game
  In order to learn lingo

  Scenario: starting game
    When I start a game
    Then A word is given with "5" letters
    And I see the first letter of the word
    And My score is "0"

  Scenario: Incorrect word is guessed
    Given A certain amount of letters are given
    And I try to guess the right word but its wrong
    When I'm playing the game
    Then The right letters are marked

  Scenario: Right word is guessed
    Given A certain amount of letters are given
    And i guess the right word
    When i'm playing the game
    Then All the letters are turned red and i win the round

  Scenario Outline: New round is starting
    Given I am playing a game
    And the round was won
    And the last word had "<previous length>" letters
    When i start a new round
    Then the word to guess has "<next length>" letters

    Examples:
    |previous length|next length|
    |5              |6          |
    |6              |7          |
    |7              |5          |


  Scenario Outline: guessing a word
    Given The first letter of a "<word>" is given
    And I need to "<guess>" the word
    When i'm playing the game
    Then I'm given a "<feedback>" on the word

#    + the guessed letter is in the right spot
#    - the letter is not in the word at all
#    / the letter is in the word but not in the right spot

    Examples:
      | word     | guess  |  feedback |
      |   koken  | krook  |  +---/    |
      |   letter | lesuur |  ++----   |
      |   meester| machten|  +----+-  |


  Scenario: Guessing 5 times
    Given I am playing a round
    And i guessed 5 times
    Then the round is over
    And i lose the game

  Scenario: cannot guess a word after the word is guessed
    Given The word is guessed
    And I try to guess again
    Then Nothing happens



