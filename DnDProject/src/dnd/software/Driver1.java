package dnd.software;

import java.util.ArrayList;
import java.util.Scanner;

import dnd.resources.*;
import dnd.players.*;
import dnd.character.*;
import dnd.skills.*;
import dnd.transactions.*;

public class Driver1 {
	//TODO: Create Driver1
	//TODOs: 
//1.) Create a DM 
//2.) Create a Player 
//3.) Create the Player�s character 
//4.) Create a NPC for the DM
//5.) Execute a resource transaction between the NPC and the Player
//6.) Execute an XP transaction between DM and the Player
//7.) Test all functions (?)
//8.) Instantiating Armor and Weapons
	public static void main(String[] args) 
	{
		//1.) DM Creation and Logging In
		DungeonMaster myDM = new DungeonMaster();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a username for the DM: ");
		String dMInput = keyboard.nextLine();
		myDM.setUsername(dMInput);
		System.out.println("Enter a password for the DM: ");
		dMInput = keyboard.nextLine();
		myDM.setPassword(dMInput);

		//Have them keep logging in until they get it right
		while(!myDM.isLoggedIn()) 
		{
			System.out.println("Please log in for the DM. Enter the username: ");
			String dMUsername = keyboard.nextLine();
			System.out.println("Enter the password: ");
			String dMPassword = keyboard.nextLine();
			myDM.logIn(dMUsername, dMPassword);
		}

		// Constructing armor and weapon objects for Player and NPC
		Armor aPlayer = new Armor(100, 100, "Generic Armor 1", "Torso");
		Armor aNpc = new Armor(1, 100, "Generic Armor 2", "Head");
		Weapon wPlayer = new Weapon(100, 100, "Generic Weapon 1", "One-Handed Sword");
		Weapon wNpc = new Weapon(1, 100, "Generic Weapon 2", "Axe");
		
		ArrayList<Resource> rListPlayer = new ArrayList<Resource>();
		rListPlayer.add(aPlayer);
		rListPlayer.add(wPlayer);

		ArrayList<Resource> rListNpc = new ArrayList<Resource>();
		rListNpc.add(aNpc);
		rListNpc.add(wNpc);

		//2.) Create Player
		// Player creation and logging in
		Player myPlayer = new Player();
		System.out.println("Enter a username for a Player: ");
		String playerInput = keyboard.nextLine();
		myPlayer.setUsername(playerInput);
		System.out.println("Enter a password for the Player: ");
		playerInput = keyboard.nextLine();
		myPlayer.setPassword(playerInput);

		//Have them keep logging in until they get it right
		while(!myPlayer.isLoggedIn()) 
		{
			System.out.println("Please log in for the Player. Enter the username: ");
			String playerUsername = keyboard.nextLine();
			System.out.println("Enter the password: ");
			String playerPassword = keyboard.nextLine();
			myPlayer.logIn(playerUsername, playerPassword);
		}

		//3.) Create the Player�s character
		//Have the player create their character
		System.out.println("Enter the character�s name for Player: " + myPlayer.getUsername());	
		String gameCharName = keyboard.nextLine();
		System.out.println("Enter the character�s race for Player: " + myPlayer.getUsername());
		String gameCharRace = keyboard.nextLine();
		System.out.println("Creating character�");
		GameChar myGameCharacter = new GameChar(gameCharName, gameCharRace);
		PrimaryProfile myPrimaryProfile = new PrimaryProfile(40,35,30,40,37,20,30,22);
		SecondaryProfile mySecondaryProfile = new SecondaryProfile(3,0,2,4,5,2,1);
		myGameCharacter.setPrimary(myPrimaryProfile);
		myGameCharacter.setSecondary(mySecondaryProfile);
		myPlayer.setTheCharacter(myGameCharacter);
		System.out.println("Your character will start with 100 coins, 0 experience, Generic Armor 1, and Generic Weapon 1.");
		myGameCharacter.addResource(aPlayer);
		myGameCharacter.setMoney(100);
		myGameCharacter.addResource(wPlayer);
		myGameCharacter.setEquippedArmor(aPlayer);
		myPlayer.changeArmor(aPlayer);
		myPlayer.changeWeapon(wPlayer);

		//4.) Create NPC
		GameChar npc1 = new GameChar("Curtis Basil", "Orc");
		npc1.setMoney(1000000);
		npc1.setResources(rListNpc);
		myDM.createNPC(npc1);
		
		
		//5.) Execute a resource transaction between the NPC and the Player
		System.out.println("Testing resource transaction with NPC�");
		System.out.println("Choose which resource you would like to buy from the NPC: ");
		for (int i = 0; i < npc1.getResources().size(); i++)
		{
			System.out.println(i + ": " + npc1.getResources().get(i).getName() + ", " + npc1.getResources().get(i).getPrice());
		}
		int choice = keyboard.nextInt();
		while (choice < 0 || choice >= npc1.getResources().size())
		{
			System.out.println("Invalid input. Please choose a number between 0 and " + (npc1.getResources().size() - 1));
			choice = keyboard.nextInt();
		}
		Resource rToTransact = npc1.getResources().get(0);
		ResourceTransaction transaction1 = new ResourceTransaction();
		transaction1.MakeNPCTransaction(myPlayer, npc1, rToTransact, rToTransact.getPrice());
		
		//6.) Execute an XP transaction between DM and the Player
		System.out.println("\nTesting XP/Skill transaction with DM� (will intentionally fail)");
		
		Skill coding = new Skill("Coding", "Magic", 20);
		XPSkillTransaction transaction2 = new XPSkillTransaction();
		transaction2.MakeTransaction(myPlayer, coding, coding.getPoints());
		
		//7.) Test all functions (?)

	}

}


