public class testing {
public static void main(String[] args) {


    String word = "Wazzzuppp!!!";
    String word2 = "awzzzppup";

    if (isAnagram(word, word2) ==true)
    System.out.println("yes!!!");
    else
    System.out.println("you failed brosky");

}

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
    System.out.println(newWord);
	return newWord;
	} 



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

}
