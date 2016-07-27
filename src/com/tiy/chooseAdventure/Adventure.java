package com.tiy.chooseAdventure;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Adventure
{
	private static Scanner userInput = new Scanner(System.in);
	
	public Adventure()
	{
		
	}
	
	public void startAdventure() throws IOException
	{
		boolean whileNotX = true;
		String[] adventureString = new String[2];
		long adventureFilePosition = 0;
		
		String[] choiceStringOne = new String[2];
		String[] choiceStringTwo = new String[2];
		String[] choiceStringThree = new String[2];
		String userChoice;
		
		RandomAccessFile adventureFile = new RandomAccessFile(".\\Adventure.txt","r");
		
		adventureFile.seek(adventureFilePosition);
		
		System.out.println("You are about to start an adventure.");
		System.out.println("You will be able to choose your own path by selecting from the options presented.");
		System.out.println("You can exit the adventure at any time by pressing X");
		
		while(whileNotX)
		{
			adventureString = adventureFile.readLine().split(":");
			
			switch(adventureString[1])
			{
				case "N":
					System.out.println(adventureString[0]);
					break;
				case "X":
					System.out.println("Your adventure has ended");
					whileNotX = false;
					break;
				case "2":
					System.out.println(adventureString[0]);
					
					choiceStringOne = adventureFile.readLine().split(":");
					choiceStringTwo = adventureFile.readLine().split(":");
					
					System.out.println(choiceStringOne[0]);
					System.out.println(choiceStringTwo[0]);
					
					userChoice = userInput.nextLine();
					if(!userChoice.equalsIgnoreCase("X"))
					{
						adventureFilePosition = checkTwoChoices(userChoice, choiceStringOne, choiceStringTwo);
						adventureFile.seek(adventureFilePosition);
					}
					else if(userChoice.equalsIgnoreCase("X"))
					{
						whileNotX = false;
					}
					break;
				case "3":					
					System.out.println(adventureString[0]);
					
					choiceStringOne = adventureFile.readLine().split(":");
					choiceStringTwo = adventureFile.readLine().split(":");
					choiceStringThree = adventureFile.readLine().split(":");
					
					System.out.println(choiceStringOne[0]);
					System.out.println(choiceStringTwo[0]);
					System.out.println(choiceStringThree[0]);
					
					userChoice = userInput.nextLine();
					if(!userChoice.equalsIgnoreCase("X"))
					{
						adventureFilePosition = checkThreeChoices(userChoice, choiceStringOne, choiceStringTwo, choiceStringThree);
						adventureFile.seek(adventureFilePosition);
					}
					else if(userChoice.equalsIgnoreCase("X"))
					{
						whileNotX = false;
					}
					break;
					
			}
			
		}
		
		adventureFile.close();
	}
	
	private long checkTwoChoices(String userChoice, String[] choiceStringOne, String[] choiceStringTwo)
	{
		long adventureFilePosition = 0;
		
		switch(userChoice.toUpperCase())
		{
			case "A":
				adventureFilePosition = Long.parseLong(choiceStringOne[1]);
				break;
			case "B":
				adventureFilePosition = Long.parseLong(choiceStringTwo[1]);
				break;
		}
		
		return adventureFilePosition;
	}
	
	private long checkThreeChoices(String userChoice, String[] choiceStringOne, String[] choiceStringTwo, String[] choiceStringThree)
	{
		long adventureFilePosition = 0;
		
		switch(userChoice.toUpperCase())
		{
			case "A":
				adventureFilePosition = Long.parseLong(choiceStringOne[1]);
				break;
			case "B":
				adventureFilePosition = Long.parseLong(choiceStringTwo[1]);
				break;
			case "C":
				adventureFilePosition = Long.parseLong(choiceStringThree[1]);
				break;
		}
		
		return adventureFilePosition;
	}
	
	public static void main(String[] args) throws IOException
	{
		Adventure myAdventure = new Adventure();
		
		myAdventure.startAdventure();
	}

}
