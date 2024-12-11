/*
 * RUNI version of the Scrabble game.
 */

import java.util.Dictionary;

public class Scrabble {

	// Note 1: "Class variables", like the five class-level variables declared below,
	// are global variables that can be accessed by any function in the class. It is
	// customary to name class variables using capital letters and underline characters.
	// Note 2: If a variable is declared "final", it is treated as a constant value
	// which is initialized once and cannot be changed later.

	// Dictionary file for this Scrabble game
	static final String WORDS_FILE = "dictionary.txt";

	// The "Scrabble value" of each letter in the English alphabet.
	// 'a' is worth 1 point, 'b' is worth 3 points, ..., z is worth 10 points.
	static final int[] SCRABBLE_LETTER_VALUES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3,
												  1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

	// Number of random letters dealt at each round of this Scrabble game
	static int HAND_SIZE = 10;

	// Maximum number of possible words in this Scrabble game
	static int MAX_NUMBER_OF_WORDS = 100000;

    // The dictionary array (will contain the words from the dictionary file)
	static String[] DICTIONARY = new String[MAX_NUMBER_OF_WORDS];

	// Actual number of words in the dictionary (set by the init function, below)
	static int NUM_OF_WORDS;

	// Populates the DICTIONARY array with the lowercase version of all the words read
	// from the WORDS_FILE, and sets NUM_OF_WORDS to the number of words read from the file.
	public static void init() {
		// Declares the variable in to refer to an object of type In, and initializes it to represent
		// the stream of characters coming from the given file. Used for reading words from the file.  
		In in = new In(WORDS_FILE);
        System.out.println("Loading word list from file...");
        NUM_OF_WORDS = 0;
		while (!in.isEmpty()) {
			// Reads the next "token" from the file. A token is defined as a string of 
			// non-whitespace characters. Whitespace is either space characters, or  
			// end-of-line characters.
			DICTIONARY[NUM_OF_WORDS++] = in.readString().toLowerCase();
		}
        System.out.println(NUM_OF_WORDS + " words loaded.");
	}

	// Checks if the given word is in the dictionary.
	public static boolean isWordInDictionary(String word) {
		for(int i=0; i<NUM_OF_WORDS; i++){
			if (DICTIONARY[i].equals(word)) {
				return true;
			}
		}
		return false;
	}
	
	// Returns the Scrabble score of the given word.
	// If the length of the word equals the length of the hand, adds 50 points to the score.
	// If the word includes the sequence "runi", adds 1000 points to the game.
	public static int wordScore(String word) {
		if (word.equals("")) {
			return 0;
		}
		int count = 0;
		for(int i=0; i<word.length(); i++){
		//	if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'n' || word.charAt(i) =='l' || word.charAt(i) == 'i' ||  word.charAt(i) == 'u' || word.charAt(i) == 't' || word.charAt(i) == 's' || word.charAt(i) == 'r' ||word.charAt(i) == 'o') {
		//	count+=1;
		//	}
		//	if (word.charAt(i) == 'b'|| word.charAt(i) == 'c' || word.charAt(i) == 'm'|| word.charAt(i) == 'p' ){
		//	count+=3;
		//	}
		//	if (word.charAt(i) == 'd'|| word.charAt(i) == 'g' ){
		//		count+=2;
		//	}
		//	if (word.charAt(i) == 'f'|| word.charAt(i) == 'h' || word.charAt(i) == 'y'|| word.charAt(i) == 'w' || word.charAt(i) == 'v'){
		//		count+=4;
		//	}
		//	if (word.charAt(i) == 'k'){
		//		count+=5;
		//	}
		//	if (word.charAt(i) == 'j'|| word.charAt(i) == 'x' ){
		//		count+=8;
		//	}
		//	if (word.charAt(i) == 'q'|| word.charAt(i) == 'z' ){
		//		count+=10;
		
		if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				count+= SCRABBLE_LETTER_VALUES[word.charAt(i)- 97];
			}
		}
		count *= word.length();
		if (subsetOf("runi", word)) {
			count+=1000;
		}
	
		if (word.length() == HAND_SIZE) {
			count+=50;
		}
		
		return count;
	}
	//if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'n' || word.charAt(i) =='l' || word.charAt(i) == 'i' ||  word.charAt(i) == 'u' || word.charAt(i) == 't' || word.charAt(i) == 's' || word.charAt(i) == 'r' ||word.charAt(i) == 'o') {
			//	count+=1;
			//}
			//if (word.charAt(i) == 'b'|| word.charAt(i) == 'c' || word.charAt(i) == 'm'|| word.charAt(i) == 'p' ){
		//		count+=3;
		//	}
		//	if (word.charAt(i) == 'd'|| word.charAt(i) == 'g' ){
		//		count+=2;
		//	}
		//	if (word.charAt(i) == 'f'|| word.charAt(i) == 'h' || word.charAt(i) == 'y'|| word.charAt(i) == 'w' || word.charAt(i) == 'v'){
		//		count+=4;
		//	}
		//	if (word.charAt(i) == 'k'){
		//		count+=5;
		//	}
		//	if (word.charAt(i) == 'j'|| word.charAt(i) == 'x' ){
		//		count+=8;
		//	}
		//	if (word.charAt(i) == 'q'|| word.charAt(i) == 'z' ){
		//		count+=10;
		//	}
	public static int countChar(String str, char ch) {
        int counter = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch)
            counter++;
        }
        return counter;
    }
	//public static boolean subsetOf(String str1, String str2) {
      //  for(int i=0; i<str1.length(); i++){ // ("pass"
        //    for(int j=0; j<str2.length(); j++){ // ,"space")
          //      if (str1.charAt(i) == str2.charAt(j)) {
            //        int cheackStr1 = countChar(str1, str1.charAt(i));
              //      int cheackStr2 = countChar(str2, str2.charAt(j));
                //    if (cheackStr1 != cheackStr2) {
                  //      return false;
                   //}
                    //break;
               // }
           // }
       // }
       // return true;
   // }
   public static boolean subsetOf(String str1, String str2) {
    for (int i = 0; i < str1.length(); i++) {
        int countStr1 = countChar(str1, str1.charAt(i)); 
        int countStr2 = countChar(str2, str1.charAt(i)); 
        if (countStr2 < countStr1) {
            return false; 
        }
    }
    return true;
}
	public static String insertRandomly(char ch, String str) {
		// Generate a random index between 0 and str.length()
		int randomIndex = (int) (Math.random() * (str.length() + 1));
		// Insert the character at the random index
		String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
		return result;
   }    
   public static String randomStringOfLetters(int n) {
	String str = "";
	char c;
	 for(int i =0; i<n; i++){
	 double random = (Math.random()) * 26;
	 c = (char)('a' + random);
	 str += c;
	 }
	 return str;
 }

	// Creates a random hand of length (HAND_SIZE - 2) and then inserts
	// into it, at random indexes, the letters 'a' and 'e'
	// (these two vowels make it easier for the user to construct words)
	public static String createHand() {
		char[] createHand = new char[HAND_SIZE];
		String str = randomStringOfLetters(HAND_SIZE);
		for(int i=0; i< createHand.length; i++){
			createHand[i] = str.charAt(i);
		}
		int random1 = (int)((Math.random()) * (HAND_SIZE));
		int random2 = (int)((Math.random()) * (HAND_SIZE));
		while (random1 == random2) {
			 random2 = (int)((Math.random()) * (HAND_SIZE));
		}
		createHand[random1] = 'e';
		createHand[random2] = 'a';
		String NewStr = "";
		for(int i=0; i<createHand.length; i++){
			NewStr+= createHand[i];
		}
		return NewStr;
	}
	public static String remove(String str2, String str1) {
		if (str1 == "") {
			return str2;
		}
		if (str2 == "") {
			return str2;
		}
		char[] charArray = new char[str1.length()];
		String Newstring = "";
		for(int i=0; i<str1.length(); i++){
			charArray[i] = str1.charAt(i);
		}
		for(int i=0; i<str2.length(); i++){
			for(int j=0; j<charArray.length; j++){
				if (str2.charAt(i) == charArray[j]) {
					charArray[j] = 0;
					break;
				}
				if (str2.charAt(i) != charArray[j] && j == charArray.length-1)
				Newstring += str2.charAt(i);
			}
		}
	return Newstring;
	}
    // Runs a single hand in a Scrabble game. Each time the user enters a valid word:
    // 1. The letters in the word are removed from the hand, which becomes smaller.
    // 2. The user gets the Scrabble points of the entered word.
    // 3. The user is prompted to enter another word, or '.' to end the hand. 
	public static void playHand(String hand) {
		int n = hand.length();
		int score = 0;
		// Declares the variable in to refer to an object of type In, and initializes it to represent
		// the stream of characters coming from the keyboard. Used for reading the user's inputs.   
		In in = new In();
		while (hand.length() > 0) {
			System.out.println("Current Hand: " + MyString.spacedString(hand));
			System.out.println("Enter a word, or '.' to finish playing this hand:");
			// Reads the next "token" from the keyboard. A token is defined as a string of 
			// non-whitespace characters. Whitespace is either space characters, or  
			// end-of-line characters.
			String input = in.readString();
			if (input.equals(".")) {
				//// Replace the following break statement with code
				//// that completes the hand playing loop
				break;
			}
			if (isWordInDictionary(input)) {
			score += wordScore(input);
			hand = remove(hand, input);
			}
			else
			System.out.println("Invalid word. Try again");
		}
		if (hand.length() == 0) {
	        System.out.println("Ran out of letters. Total score: " + score + " points");
		} else {
			System.out.println("End of hand. Total score: " + score + " points");
		}
	}

	// Plays a Scrabble game. Prompts the user to enter 'n' for playing a new hand, or 'e'
	// to end the game. If the user enters any other input, writes an error message.
	public static void playGame() {
		// Initializes the dictionary
    	init();
		// The variable in is set to represent the stream of characters 
		// coming from the keyboard. Used for getting the user's inputs.  
		In in = new In();
		while(true) {
			System.out.println("Enter n to deal a new hand, or e to end the game:");
			// Gets the user's input, which is all the characters entered by 
			// the user until the user enter the ENTER character.
			String input = in.readString();
			if(input.equals("n")){
				String str = createHand();
				playHand(str);
			}
			if(input.equals("e")){
				System.out.println("Thanks for playing!");
				break;
			}
			if(!input.equals("e") && !input.equals("n")){
				System.out.println("Error. Try again");

			}

		}
	}

	public static void main(String[] args) {
		//Uncomment the test you want to run
		testBuildingTheDictionary();  
		testScrabbleScore();    
		testCreateHands();  
		testPlayHands();
		playGame();
	}

	public static void testBuildingTheDictionary() {
		init();
		// Prints a few words
		for (int i = 0; i < 5; i++) {
			System.out.println(DICTIONARY[i]);
		}
		System.out.println(isWordInDictionary("mango"));
	}
	
	public static void testScrabbleScore() {
		System.out.println(wordScore("bee"));	
		System.out.println(wordScore("babe"));
		System.out.println(wordScore("friendship"));
		System.out.println(wordScore("running"));
	}
	
	public static void testCreateHands() {
		System.out.println(createHand());
		System.out.println(createHand());
		System.out.println(createHand());
	}
	public static void testPlayHands() {
		init();
		//playHand("ocostrza");
		//playHand("arbffip");
		//playHand("aretiin");
	}
}
