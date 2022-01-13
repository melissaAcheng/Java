// Run methods and test here
import java.util.Random;

public class PuzzleTest {
    public static void main(String[] args) {
        
        PuzzleJava puzzleJava = new PuzzleJava();
		
        System.out.println(puzzleJava.getTenRolls());
        System.out.println(puzzleJava.getRandomLetter());
        System.out.println(puzzleJava.generatePassword());


        Random randNum = new Random();
        System.out.println(puzzleJava.getNewPasswordSet(randNum.nextInt(10)));

        


    }
}
