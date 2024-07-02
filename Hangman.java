import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new File("C:/Users/gauri/eclipse-workspace/Hangman_Game/file.txt"));
		Scanner keyboard=new Scanner(System.in);
		List<String> words=new ArrayList<>();
		while(sc.hasNext()) {
			words.add(sc.nextLine());
		}
		Random rd=new Random();
		String word=words.get(rd.nextInt(words.size()));
		System.out.println(word);
		
		List<Character> playerGuesses=new ArrayList<>();
		printWordState(word, playerGuesses);
		int wrongCount=0;
		while(true) {
			
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println();
			if(wrongCount>=1) {
				System.out.println("O");
			}
			if(wrongCount>=2) {
				System.out.print("\\ ");
				if(wrongCount>=3) {
					System.out.println("/");
				}
				else {
					System.out.println("");
				}
				
			}
			if(wrongCount>=4) {
				System.out.println(" |");
			}
			if(wrongCount>=5) {
				System.out.print("\\ ");
				if(wrongCount>=6) {
					System.out.println("/");
				}
				else {
					System.out.println("");
				}
				
			}
			printWordState(word, playerGuesses);
		getPlayerGuess(keyboard, word, playerGuesses);
		if(printWordState(word, playerGuesses)) {
			System.out.println("YOU WIN!!!!");
			break;
		}
		System.out.println("please enter your guess for the word:");
		if(keyboard.nextLine().equals(word)) {
			System.out.println("YOU WIN!!!!");
			break;
		}else {
			System.out.println("Nope Try again!!");
		}
		}
		
		System.out.println("YOU WIN!!!!");
	}




	private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
		System.out.println("Please Enter a letter: ");
		String letterGuess=keyboard.nextLine();
		playerGuesses.add(letterGuess.charAt(0));
		printWordState(word, playerGuesses);
	}

	
	
	
	private static boolean printWordState(String word, List<Character> playerGuesses) {
		int correctCount=0;
		for(int i=0;i<word.length();i++) {
			if(playerGuesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctCount++;
			}
			else {
				System.out.print("-");
			}
			}
		System.out.println();
		return(word.length()==correctCount);
	}

}
