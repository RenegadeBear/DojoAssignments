import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzling {

	//Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. 
	//Print the sum of all numbers in the array. Also have the function 
	//return an array that only includes numbers that are greater than 10 
	public static void greaterThan(ArrayList<Integer> arl1, Integer num) {
		ArrayList<Integer> arl2 = new ArrayList<Integer>();
		for (int i=0; i< arl1.size(); i++) {
			if (arl1.get(i) > num) {
				arl2.add(arl1.get(i));
			}
		}
		System.out.print(arl2);
	}
	
	//Create an array with the following values: Nancy, Jinichi, Fujibayashi,
	//Momochi, Ishikawa. Shuffle the array and print the name of each person.
	//Have the method also return an array with names that are longer than 5 characters.
	public static void longNames(String[] names) {
		ArrayList<String> folks = new ArrayList<String>();
		for (String name: names) {
			if (name.length() > 5) {
				folks.add(name);
			}
		}
		Collections.shuffle(folks);
		System.out.println(folks);
	}
	
	//Create an array that contains all 26 letters of the alphabet (this array 
	//must have 26 values). Shuffle the array and display the last letter of the 
	//array. Have it also display the first letter of the array. If the first letter
	//in the array is a vowel, have it display a message

	public static void abcShuffle() {
		char [] alphabet =  "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList <Character> abcs = new ArrayList<Character>();
        for (int i =0; i<=alphabet.length-1; i++) {
        	abcs.add(alphabet[i]);
        }
        Collections.shuffle(abcs);
        System.out.println(abcs);
        char v = abcs.get(0);
        
		if (v=='a'||v=='e'||v=='i'||v=='o'||v=='u') {
			System.out.println(abcs.get(0) + "<- This is a vowel " + abcs.get(25));
		}
		System.out.println(abcs.get(0) +" "+ abcs.get(25));
	}
	
	//Generate and return an array with 10 random numbers between 55-100.
	public static void random10() {
		ArrayList <Integer> rand10 = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			Random rand = new Random();
			int num = rand.nextInt(45)+55;
			rand10.add(num);
		}
		System.out.println(rand10);
	}
	
	//Generate and return an array with 10 random numbers between 55-100 and have 
	//it be sorted (showing the smallest number in the beginning). Display all the 
	//numbers in the array. Next, display the minimum value in the array as well 
	//as the maximum value.
	public static void random10Sorted() {
		ArrayList <Integer> rand10 = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			Random rand = new Random();
			int num = rand.nextInt(45)+55;
			rand10.add(num);
		}
		Collections.sort(rand10);
		int min = rand10.get(0);
		int max = rand10.get(9);
		System.out.println("Min: "+ min + "; Max: " + max);
		System.out.println(rand10);
	}
	
	// Create a random string that is 5 characters long.
	public static void randString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println(saltStr);
	}
	
	//Generate an array with 10 random strings that are each 5 characters long
	public static void randStrings() {
		ArrayList <String> randArrList = new ArrayList<String>();
		for (int i=0; i<10; i++) {
	        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr1 = salt.toString();
	        randArrList.add(saltStr1);
		}
		System.out.println(randArrList);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Puzzling");
//        Puzzling p = new Puzzling();
        Integer[] arr = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> arl1 = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(arl1);
        Puzzling.greaterThan(arl1, 10);
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        Puzzling.abcShuffle();
        Puzzling.random10();
        Puzzling.random10Sorted();
        Puzzling.randString();
        Puzzling.randStrings();
        
	}

}
