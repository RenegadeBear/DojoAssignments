import java.util.HashMap;
import java.util.Map;

public class Hashmatique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> trackList = new HashMap<>();
		trackList.put("Try Everything","I won't give, up no I won't give in\r\n" +
				"Till I reach the end\r\n" + 
				"And then I'll start again\r\n" + 
				"Though I'm on the lead\r\n" + 
				"I wanna try everything\r\n" + 
				"I wanna try even though I could fail\r\n" + 
				"I won't give up, no I won't give in\r\n" + 
				"Till I reach the end\r\n" + 
				"And then I'll start again\r\n" + 
				"No I won't leave\r\n" + 
				"I wanna try everything\r\n" + 
				"I wanna try even though I could fail");
		trackList.put("The Man in the Mirror", "If you want to make the world a better place\r\n" + 
				"Take a look at yourself, and then make a change.");
		trackList.put("Breakaway", "I'll take a risk\r\n" + 
				"Take a chance\r\n" + 
				"Make a change\r\n" + 
				"And breakaway.");
		trackList.put("Try", "Where there is desire, there is gonna be a flame\r\n" + 
				"Where there is a flame, someone's bound to get burned\r\n" + 
				"But just because it burns, doesn't mean you're gonna die\r\n" + 
				"You gotta get up and try, and try, and try\r\n" + 
				"Gotta get up and try, and try, and try\r\n" + 
				"You gotta get up and try, and try, and try");
//		String track1 = trackList.get("Try Everything");
//		String track2 = trackList.get("The Man in the Mirror");
//		String track3 = trackList.get("Breakaway");
//		String track4 = trackList.get("Try");
//		System.out.println(track1);
//		System.out.println(track2);
//		System.out.println(track3);
//		System.out.println(track4);
		for (Map.Entry<String,String> entry : trackList.entrySet()) {
			String track = entry.getKey();
			String lyric = entry.getValue();
			System.out.println("Track: " + track);
			System.out.println("Lyrics: " + lyric);
		}
		}

		

	}


