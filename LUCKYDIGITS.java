import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LUCKYDIGITS {
  // Instantiating utility objects
  public static Scanner Input = new Scanner(System.in);
  public static Random randonNum = new Random();

  public static String Title() {
    return """
         ▄█       ███    █▄   ▄████████    ▄█   ▄█▄ ▄██   ▄        ████████▄   ▄█     ▄██████▄   ▄█      ███        ▄████████
        ███       ███    ███ ███    ███   ███ ▄███▀ ███   ██▄      ███   ▀███ ███    ███    ███ ███  ▀█████████▄   ███    ███
        ███       ███    ███ ███    █▀    ███▐██▀   ███▄▄▄███      ███    ███ ███▌   ███    █▀  ███▌    ▀███▀▀██   ███    █▀
        ███       ███    ███ ███         ▄█████▀    ▀▀▀▀▀▀███      ███    ███ ███▌  ▄███        ███▌     ███   ▀   ███
        ███       ███    ███ ███        ▀▀█████▄    ▄██   ███      ███    ███ ███▌ ▀▀███ ████▄  ███▌     ███     ▀███████████
        ███       ███    ███ ███    █▄    ███▐██▄   ███   ███      ███    ███ ███    ███    ███ ███      ███              ███
        ███▌    ▄ ███    ███ ███    ███   ███ ▀███▄ ███   ███      ███   ▄███ ███    ███    ███ ███      ███        ▄█    ███
        █████▄▄██ ████████▀  ████████▀    ███   ▀█▀  ▀█████▀       ████████▀  █▀     ████████▀  █▀      ▄████▀    ▄████████▀
        I've generated a random number from 1 to 100, your goal is to guessed it right.
        Goodluck you only have 7 attempts :)
                          """;
  }

  // This method is for cleaning the console such as erasing all the printed text
  public static void clearConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch (IOException | InterruptedException exception) {
      System.out.println(exception.getCause());
    }
  }

  @SuppressWarnings("unused")
  public static void GuessingGame() {
    // Calling the title method
    String Title = Title();
    System.out.println(Title);

    int generatedNum = randonNum.nextInt(100) + 1; // Declering a new variable that generated a random number
    int userInput = 0; // this variable is for getting the input of the user
    int attempts = 7; // this is how we can how the attempts left

    // Using try catch method for error handling if the user is inputting a value
    // that is not a number
    try {
      // Keep asking the user to guess the right number!
      // You see, we also need to check if the attempts of the user is not zero
      while (userInput != generatedNum && attempts >= 1) {
        System.out.print("Enter a number from 1 - 100: ");
        userInput = Input.nextInt();
        Input.nextLine();

        // Checking if the guess of the user is too high and too low
        // Its like a hint for them, so that it can still be a fair game
        if (userInput > generatedNum && attempts >= 1) {
          --attempts; // Decrementing the value of attempts by -1
          System.out.println("Too high! Try again :)");
          System.out.println("You only have " + attempts + " attempts left");
        } else if (userInput < generatedNum && attempts >= 1) {
          --attempts; // Decrementing the value of attempts by -1
          System.out.println("Too low! Try again :)");
          System.out.println("You only have " + attempts + " attempts left");
        } else {
          System.out.println("Wow you got it right!");
          System.out.println("Congratulations you guessed it with only " + attempts + " attempts left");
        }
      }
      // If the attempts of the user drops to zero, of course its a game over :)
      if (userInput != generatedNum && attempts == 0) {
        System.out.println("Oops game over!");
      }
    } catch (Exception exception) {
      System.out.println("Invalid Input!");
      Input.nextLine();
    }

    System.out.print("Press any key to continue...");
    String userContinue = Input.nextLine();
  }

  public static void main(String[] args) throws Exception {
    String userChoice = "";

    clearConsole();
    GuessingGame();

    try {
      while (!userChoice.equals("EXIT") || userChoice.isEmpty()) {
        System.out.print("Would you like to exit or play again? (EXIT/PLAY): ");
        userChoice = Input.nextLine().toUpperCase();

        if (userChoice.equals("PLAY")) {
          clearConsole();
          GuessingGame();
        }
      }
    } catch (Exception exception) {
      System.out.println("Invalid Input! (ONLY EXIT/YES)");
      Input.nextLine();
    }

    Input.close();
    System.exit(0);
  }
}
