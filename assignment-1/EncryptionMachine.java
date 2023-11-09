package com.jackhance.encryption;

import java.util.Scanner;

public class EncryptionMachine {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final int SHIFT = 3;
	
	public static void main(String[] args) {
		encryptionMachine();
	}
	
	/**
	 * Interactively gets input from user and encrypts it 
	 */
	private static void encryptionMachine() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the CSCI717 Encryption Machine Construction");
		System.out.println("The program lets you encrypt a message with a key for your recipient to decrypt!");
		
		System.out.println("Enter key:");
		
		// at present key doesn't actually do anything, assuming this is placeholder
		// for later implementation
		String key = scanner.next();
		String encryptedKey = encryptWord(key);
		
		System.out.printf("\"%s\" has been encrypted to: %s\n", key, encryptedKey);
		
		System.out.println("How many words is your message?:");
		
		// number of words to be read in as input 
		int numWords = scanner.nextInt();
		
		for(int i = 0; i < numWords; i++) {
			System.out.println("Next word:");
			String givenWord = scanner.next();
			String encryptedWord = encryptWord(givenWord);
			
			System.out.printf("\"%s\" has been encrypted to: %s\n", givenWord, encryptedWord);
		}
		
		System.out.println("Message fully encrypted. Happy secret messaging!");
		
		
		scanner.close();
	}
	
	/**
	 * Encrypt a single character, uses the global SHIFT as encryption key
	 * @param letter input to be encrypted
	 * @return encrypted letter
	 */
	private static char encryptLetter(char letter) {
		
		int givenLetterIndex = ALPHABET.indexOf(letter);
		
		return ALPHABET.charAt((givenLetterIndex + SHIFT) % ALPHABET.length());
	}
	
	/**
	 * Encrypt a word, that is, a string containing only letters specified in 
	 * the global ALPHABET
	 * @param word input to be encrypted
	 * @return encrypted word
	 */
	private static String encryptWord(String word) {
		StringBuilder builder = new StringBuilder();
		
		for(char c : word.toCharArray()) {
			builder.append(encryptLetter(c));
		}
		
		return builder.toString();
	}
}
