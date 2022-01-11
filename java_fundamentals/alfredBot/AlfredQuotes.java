import java.util.Date;  // import the Date class
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String dayPeriod) {
        // Returns a greeting based on the time of day that includes the person's name
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);

    }
    
    public String dateAnnouncement() {
        // Returns the current date and time
        Date date = new Date();
        return "It is currently " + date + ".";
    }
    
    public String respondBeforeAlexis(String conversation) {
        // If Alexis appears in the String
        // If Alfred appears in the String
        // If neither name appears in the String
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certaintly isn't sophisticated enough for that.";
        }
        else if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        } 
        else {
            return "Right. And with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String alarmSystem() {
        //  if intruder enters the house, alarm message will go off
        boolean intruder = false;

        if (intruder) {
            return "INTRUDER DETECTED CALLING 9-1-1";
        }
        return "Security password entered.";
    }
}

