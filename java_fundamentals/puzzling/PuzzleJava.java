// Write methods here
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    // Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 1; i <=10; i++) {
            random10.add(rand.nextInt(20));
            
        }
        // System.out.println(random10);
        return random10;
    }

    // Write a method that will 
        // Create an array that contains all 26 letters of the alphabet
        // Generate a random index between 0-25 use it to pull a random letter out of the array
        // return the random letter

    public String getRandomLetter() {
        Random rand = new Random();

        String[] alphabetArray = new String[26]; // intialization
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Loop through adding a letter of the alphabet to the fixed array
        for (int i = 0; i < 26; i++) {
            String letter = Character.toString(alphabet.charAt(i));
            alphabetArray[i] = letter;
        }

        return alphabetArray[rand.nextInt(26)];
    }

    // Write a method that uses getRandomLetter() to create a random string of eight characters
    // Return the string

    public String generatePassword() {
        // Create an empty string
        String password = "";

        // Loop through 8 times and add a random letter to the string
        for (int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }

        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        // Create empty array list
        ArrayList<String> passwordSet = new ArrayList<String>();

        // Loop through number of length times
        for (int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }

        return passwordSet;

    }

    
}
