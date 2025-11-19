/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String word1 = preProcess(str1);
		String word2 = preProcess(str2);
		int sum1 = 0;
		int sum2 = 0;
    for (int i = 0; i < word1.length(); i++)
    {
      char charInWord = word1.charAt(i);
      int locationInAscii = (int) charInWord;
      sum1 = sum1 + locationInAscii;
      }

 for (int i = 0; i < word2.length(); i++)
    {
      char charInWord = word2.charAt(i);
      int locationInAscii = (int) charInWord;
      sum2 = sum2 + locationInAscii;
    }
      if (sum1 == sum2)
       {
		return true;
       }
    else
      return false;
     }

	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String word = str.toLowerCase();
        String newWord = ""; 
    for (int i = 0; i < word.length(); i++)
    {
      char charInWord = word.charAt(i);
      int locationInAscii = (int) charInWord;
      if (locationInAscii > 96)
      {
        newWord = newWord + charInWord;
      }

    }
	return newWord;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
	String word = str;
    String newWord = "";
    char c;
    int newIndex;

    // We "have to" use isAnagram, so we keep this while.
    // It will run until newWord is an anagram of word.
    while (!isAnagram(word, newWord))
    {
        newWord = ""; // reset for each attempt

        // make a mutable copy of the remaining characters
        StringBuilder temp = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++)
        {
            // pick a random valid index in the remaining characters
            newIndex = (int)(Math.random() * temp.length());
            c = temp.charAt(newIndex);
            newWord += c;

            // remove the used character so it won't be selected again
            temp.deleteCharAt(newIndex);
        }
    }
    return newWord;
}
}

