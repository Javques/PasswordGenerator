//--------------------------------------
// Assignment 3 (Q1)
// Written by: Alexis Bolduc 40126092
// For COMP 248 Section FF - Fall 2019
//--------------------------------------
//Welcome to question1 of assignment 3
//Purpose: generating multiple passwords that are respecting different conditions 
// with the use of arrays, loops, the random method and if statements
//import Random 
import java.util.Random;  
public class q1 {

	public static void main(String[] args) {
		
		Random random = new Random();
		//this is the text from which we will take some random words
		final String[][][] book = {
	            {
	                {"ALICE was beginning to get very tired of sitting by her sister on the\n",
	                    "bank, and of having nothing to do. Once or twice she had peeped into the\n",
	                    "book her sister was reading, but it had no pictures or conversations in\n",
	                    "it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
	                    "conversations?\"\n"},
	                {"So she was considering in her OWN mind (as well as she could, for the\n",
	                    "day made her feel very sleepy and stupid), whether the pleasure of\n",
	                    "making a daisy-chain would be worth the trouble of getting up and\n",
	                    "picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
	                    "close by her.\n"},
	                {"There was nothing so very remarkable in that, nor did Alice think it so\n",
	                    "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
	                    "dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
	                    "out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
	                    "started to her feet, for it flashed across her mind that she had never\n",
	                    "before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
	                    "out of it, and, burning with curiosity, she ran across the field after\n",
	                    "it and was just in time to see it pop down a large rabbit-hole, under\n",
	                    "the hedge. In another moment, down went Alice after it!"}
	            },
	            {
	                {"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
	                    "telescope!\"\n"},
	                {"And so it was indeed! She was now only ten inches high, and her face\n",
	                    "brightened up at the thought that she was now the right size for going\n",
	                    "through the little door into that lovely garden.\n"},
	                {"After awhile, finding that nothing more happened, she decided on going\n",
	                    "into the garden at once; but, alas for poor Alice! When she got to the\n",
	                    "door, she found she had forgotten the little golden key, and when she\n",
	                    "went back to the table for it, she found she could not possibly reach\n",
	                    "it: she could see it quite plainly through the glass and she tried her\n",
	                    "best to climb up one of the legs of the table, but it was too slippery,\n",
	                    "and when she had tired herself out with trying, the poor little thing\n",
	                    "sat down and cried.\n"},
	                {"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
	                    "sharply. \"I advise you to leave off this minute!\" She generally gave\n",
	                    "herself very good advice (though she very seldom followed it), and\n",
	                    "sometimes she scolded herself so severely as to bring tears into her\n",
	                    "eyes.\n"},
	                {"Soon her eye fell on a little glass box that was lying under the table:\n",
	                    "she opened it and found in it a very small cake, on which the words \"EAT\n",
	                    "ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
	                    "Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
	                    "makes me grow smaller, I can creep under the door: so either way I'll\n",
	                    "get into the garden, and I don't care which happens!\"\n"},
	                {"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
	                    "way?\" holding her hand on the top of her head to feel which way she was\n",
	                    "growing; and she was quite surprised to find that she remained the same\n",
	                    "size. So she set to work and very soon finished off the cake."}
	            },
	            {
	                {"The King and Queen of Hearts were seated on their throne when they\n",
	                    "arrived, with a great crowd assembled about them--all sorts of little\n",
	                    "birds and beasts, as well as the whole pack of cards: the Knave was\n",
	                    "standing before them, in chains, with a soldier on each side to guard\n",
	                    "him; and near the King was the White Rabbit, with a trumpet in one hand\n",
	                    "and a scroll of parchment in the other. In the very middle of the court\n",
	                    "was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
	                    "trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
	                {"The judge, by the way, was the King and he wore his crown over his great\n",
	                    "wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
	                    "(some were animals and some were birds) I suppose they are the jurors.\"\n"},
	                {"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
	                {"\"HERALD! read the accusation!\" said the King."}
	            }
	        };
		//the three constant string are used to evaluate the lower case, upper case, and special case
		//conditions
		final String upperAlph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String lowerAlph = "abcdefghijklmnopqrstuvwxyz";
		final String speChar = "`-=~!@#$%^&*()_+[]\\\\;'./,{}|:\\\"<>?";
		//initialization of the password array
		String [] password = {"temp1","temp2","temp3"};
		// an Out of the loop boolean value in order to break the loop if a condition is not respected
		boolean Ootl = true ;
		// initialization of the whole password that will  be created
		String wholePass = "";
		// a temporary transformation of the whole password to evaluate certain conditions
		String tempPass = "" ;
		// the proper way to format the password in order to respect the output format
		String formatPass;
		// i is the number of password generated 
		int i = 0;	
		//counts the number of special characters in a password for the sake of the loop 
		int countSpe = 0;
		//welcome message
		System.out.println("Welcome to the password generator game!\n");
		// initialization of the conditions values
		int newLine =0, single =0, equal = 0, length = 0, upper = 0, lower = 0, special = 0  ; 
		//this main loop generates up to 10000 passwords
		label1:
		for( i=0; i<10000; i++) {
			//the initialization of the boolean value that evaluates a problem in the first nested loop
			boolean hasProblem = false;
			//choose a random page
			int pageNum = random.nextInt(book.length);
			// in this random page we choose a random paragraph
			int paragraphNum = random.nextInt(book[pageNum].length);
			//in this random paragraph we choose a random line
			int lineNum = random.nextInt(book[pageNum][paragraphNum].length);
				// this is the loop in order to choose three words from the text
				for (int a = 0; a <3; a++) {
					// if one of the word chosen is of length 1 or has \n character, we choose
					// another line from the text
					if(hasProblem) {
						pageNum = random.nextInt(book.length);
						paragraphNum = random.nextInt(book[pageNum].length);
						lineNum = random.nextInt(book[pageNum][paragraphNum].length);
					}
					hasProblem = false;
					
					// we convert the line chosen in a string
					String thisLine = book [pageNum][paragraphNum][lineNum];
					// we split the string in an array of word
					String [] arWord = thisLine.split(" ",thisLine.length());
					// this is the length of the array
					int numbWord = arWord.length;
					//choosing a random word from the array of words
					int ranWord = random.nextInt(numbWord);
					String  word = arWord[ranWord];
					// the condition evaluator for a word of more than 1 character
					if(word.length()==1) {
						single++;
						a--;
						hasProblem = true;
						continue; }
					// condition evaluator for a word without \n character
					if (word.contains("\n")) {
						newLine++;
						a--;
						hasProblem = true;
						continue ; }
					//store the word in the password array
					password [a] = word;
					
					}
		
		String word1 = password [0];
		String word2 = password [1];
		String word3 = password [2];
		//combination of the 3 words in one password
		wholePass = word1+word2+word3;
		//evaluate the length
		if (wholePass.length()>16 || wholePass.length() < 8) {
				i--;
				length++; 
				continue label1;}
		//evaluate that each word is unique	
		if (word1.compareTo(word2)==0|| word2.compareTo(word3)==0 || word1.compareTo(word3)==0){
				i--;
				equal++; 
				continue label1; }
		// evaluate that the password has at least a lower case	
		for(int c = 0; c<lowerAlph.length(); c++ )	{
			
			String temp = lowerAlph.substring(c, c+1); 
			  

					if (wholePass.contains(temp)) {
						 
						Ootl = false;
						break; }
		}
	
	 //if this condition is not respected we go back to find 3 other words
		if (Ootl)
			{lower++;
			i--; 
			continue label1;
			}
		// re-initialization of out of the loop evaluator
		Ootl = true;
		// evaluate that the password has at least an upper case
		for(int c = 0; c<upperAlph.length(); c++ )
				{
					String temp = upperAlph.substring(c, c+1); 
					
						if (wholePass.contains(temp)) 
							{Ootl = false;  
								break ;}					
					}
		//if this condition is not respected we go back to find 3 other words
		if (Ootl)
			{upper++;
			i--;
			continue label1;
			}
		// re-initialization of out of the loop evaluator
		Ootl = true;
		// re-initialization of out of the special character counter 
		countSpe = 0;
		for(int c = 0; c<wholePass.length(); c++ )
			{
				
			 	tempPass = wholePass.substring(c, c+1); 
			
			 		if (speChar.contains(tempPass)) 
			 			++countSpe; 
				
			}
		// if there is not only one special character, we exit the loop and choose 3 other words
		if (countSpe != 1)
			{special++;
			i--;
			countSpe = 0; 
			continue label1;
			}
			
		
			
			
		//formatting of output	
		formatPass = String.format("%-16s", wholePass);	
		System.out.print("Password = " + formatPass);
		System.out.println( "\tNewline = "
		+ newLine + "\tSingle = "+single+"\tEqual = "+equal+
		 "\tLength = "+length + "\tUpper = "+upper+ "\tLower = "+
			lower+ "\tSpecial = "+special); 
		//if the the lower case character was not respected we end the loop
			if (lower == 1)
				break;
			newLine =0;
			single =0;
			equal = 0; 
			length = 0; 
			upper = 0;
			lower = 0; 
			special = 0  ; 
			}
		// end message 
	    System.out.println("\n\nTotal passwords generated: "+ i+"\n");
	    System.out.println("Thanks for using the password generator game. Good bye."); 
	}

}
//this marks the end of the program, thank you 

