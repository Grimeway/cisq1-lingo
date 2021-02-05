Feature: start game
  As a player,
  i want to start a game,
  so that i can train my lingo skills.

  Scenario: starting game
    When I start a game
    Then a game is started

  Scenario: playing game
    Given a game is started
    And a new word is given
    When