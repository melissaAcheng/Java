import java.util.HashMap;
// import java.util.Set;

public class Hashmatique {

    // Write a method
    public void getTracks() {
        HashMap<String, String> trackList = new HashMap<String, String>();
    
        trackList.put("Sunday Best", "Good, feeling good\nAy, feeling good, like I should\nWent and took a walk around the neighbourhood\n");
        trackList.put("Shake It Off", "I stay out too late\nGot nothing in my brain\n That's what people say, mm, mm\nThat's what people say, mm, mm\n");
        trackList.put("Memories", "Here's to the ones that we got\nCheers to the wish you were here, but you're not\n'Cause the drinks bring back all the memories\nOf everything we've been through\n");
        trackList.put("Paradise", "When she was just a girl she expected the world\nBut it flew away from her reach\n So she ran away in her sleep\n");

        String oneTrack = trackList.get("Sunday Best");

        // Print out the lyrics for one track
        System.out.println(oneTrack);

        // Iterate over trackList and print the key:value pairs
        // Get the keys using the keySet method
        // Set<String> lyrics = trackList.keySet();
        for(String key: trackList.keySet()) {
            // System.out.println(key);
            // System.out.println(trackList.get(key));
            System.out.printf("Track: %s \nLyrics: %s\n", key, trackList.get(key));
        }


    }



}
