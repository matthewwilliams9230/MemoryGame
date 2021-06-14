/**
 * Project 3.6.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
public class MemoryGame
{
  public static void main(String[] args) {
    int gameCount = 0; // Initialized up here so that they can be accessed both inside and outside of the while loop
    int score = 0; // same as gameCount ^^^
    // Create the "memory strings" - an array of single character strings to 
    // show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.

    String[] memoryString = {"c", "o", "m", "p", "u", "t", "e", "r"}; // Decided to have fun and pick a longer word

    // Create the game and gameboard. Configure a randomized board with 3 buttons.

    MemoryGameGUI gameBoard = new MemoryGameGUI();
    gameBoard.createBoard(3, true);

    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.)

    // Play the game until user wants to quit.

    boolean play = true;
    while (play == true) {
  
      // Create a new array that will contain the randomly ordered memory strings.

      String[] tempString = new String [memoryString.length];

      // Overload the next method in RandomPermutation to create a random sequence 
      // of the memory strings, passed as a parameter.

      tempString = randomPermutation.next(memoryString);

      // Play one sequence, delaying half a second for the strings to show
      // in the buttons. Save the player's guess. 
      // (Later, you can speed up or slow down the game.)
      String finalRun = gameBoard.playSequence(tempString, 0.5);

      // Determine if player's guess matches all elements of the random sequence.
      if(finalRun!=null) {

        // Cleanup the guess - remove commas and spaces. Refer to a new String method 
        // replace to make this easy.
        finalRun = finalRun.replace(" ", ",");
        finalRun = finalRun.replace(",", "");
      }
        // iterate to determine if guess matches sequence

      boolean isEqual = false;
      if (finalRun.length() == tempString.length) 
      {
        for (int i = 0; i < finalRun.length();i++) 
        {
          String playerGuess = finalRun.substring(i,i+1); //A character in finalRun is accessed by using the substring method because it is just a normal string
          String actual = tempString[i]; //A character in tempString is accessed this way because it is coming out of an array
          if(playerGuess.equals(actual)) 
          {
            isEqual = true;
          }
          else {
            isEqual = false;
          }
        }
      }
      else 
      {
        gameBoard.tryAgain();
      }
        // If match, increase score, and signal a match, otherwise, try again.
      if(isEqual == true) {
        score += 1;
        gameBoard.matched();
      }
      else 
      {
        gameBoard.tryAgain();
      }
      // Ask if user wants to play another round of the game 
      // and track the number of games played.
      gameCount += 1;
      play = gameBoard.playAgain();
    } //Lines below are not put inside of the while loop because they would be used mroe than once, which is not what we want
    // When done playing, show score and end the game.
        gameBoard.showScore(score, gameCount);
        gameBoard.quit();
  }
}