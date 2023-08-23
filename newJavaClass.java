

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


	class Word {
	  public String maskedword = "";
	  public String word = "";
	  private String[] words = {"apple","dog","cat","book"}; 

	  public String maskWord() { 
	      Random rand = new Random();
	      int randNum = rand.nextInt(words.length);
	      if(randNum>0) {
	      
	      word = words[randNum];
	      for (int i = 0; i < word.length(); i++) { 
	        maskedword = maskedword + "*";
	      }
	      }
	      return word;
	  }

	  public String currentOutput(char letter) { 
	    char[] wordArray = word.toCharArray(); 
	    char[] maskedWordArray = maskedword.toCharArray();
	    for (int i = 0; i < wordArray.length; i++) {
	      char ichar = wordArray[i];
	      if (letter == ichar) { 
	        maskedWordArray[i] = ichar; 
	      }
	    }
	    maskedword = String.valueOf(maskedWordArray);	    
	    return maskedword;
	  }
	}

	public class newJavaClass {
		
	  public static void main(String[] args) {
		int attempts =0;
	    Word word = new Word();
	    String currentWord = word.maskWord(); 
	    boolean won=false;
	    while (true) { 
	      System.out.print("Guess the word:"+word.maskedword);
	      Scanner guessLetter = new Scanner(System.in); 
	      char letterGuessed = guessLetter.nextLine().charAt(0); 
	      String letter = letterGuessed+"";
	      ArrayList<String> repeat = new ArrayList<String>();
	      do {
	    	  
		      if (word.currentOutput(letterGuessed).equals(currentWord)) { 
		    	  System.out.println("You have won the game. The word was "+currentWord);
		    	  won=true;
		          word = new Word();
		          currentWord = word.maskWord();
		          
		          attempts = 0;
		        }
		      else if(word.maskedword.contains(letter)){
		    	  System.out.print("correct ");
		    	  System.out.println(word.maskedword);
		    	  won = false;
			      guessLetter = new Scanner(System.in); 
			      letterGuessed = guessLetter.nextLine().charAt(0); 
			      letter = letterGuessed+"";
		      }else {	
		    	  won = false;
		        	attempts++;
		        	if(repeat.contains(letter)) {
		        		System.out.println("You have already tried this letter ");
		        		won=false;
					      guessLetter = new Scanner(System.in); 
					      letterGuessed = guessLetter.nextLine().charAt(0); 
					      letter = letterGuessed+"";
		        	}
		        	else {
		        	System.out.print("Incorrect ");
		        	if(attempts>=5) {
		        		System.out.println("Game over  ");
		        		won = true;
		        	}else {		        		
		        		repeat.add(letter);
		        		System.out.println(attempts +" life lost."+(5-attempts)+" remaining.The current word is "+word.maskedword);
		        	
				      guessLetter = new Scanner(System.in); 
				      letterGuessed = guessLetter.nextLine().charAt(0); 
				      letter = letterGuessed+"";
		        	}
		        }}
	      }while(!won);
	    }
	      
	    }
	  }

