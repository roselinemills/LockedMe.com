package lockedMe;

import java.io.IOException;
import java.util.Scanner;

public class ClientInterface {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println ("Application name: LockedMe.com"+"\n"
							+"Developer name: Roseline Ayitey"+"\n"
							+"----------------------------------------"+"\n");
		mainMenu();
	}
	
	public static void displayOptions() {
		System.out.println("Welcome! What would you like to do?" +"\n"
				+ "Option 1:Display the current file names in ascending order"+ "\n"
				+ "Option 2:Perform Add/Delete/Search operations on a file"+ "\n"
				+ "Option 3:Exit program");
	}
		
	static Scanner sc = new Scanner (System.in);
	public static void mainMenu() throws IOException {
			 
		FileOperations fileOperations = new FileOperations();
		SecondLevelMenu secondLevelMenu = new SecondLevelMenu();
		fileOperations.createDirectory();
			
			int option = 0;
			do	{	 
				displayOptions();
				 while (sc.hasNextInt()==false){
					 System.out.println("Input is invalid. Choose from the options below"+"\n");
					 displayOptions();
	                 sc.next();
				 }
				 try {
				 option = sc.nextInt(); 
					 switch (option){
						case 1:
							fileOperations.displayFiles("dir");
						break;
						case 2:
							secondLevelMenu.selectOperations();
						break;
						case 3:
							System.out.println("Thank you for using LockedMe. Goodbye!");
							System.exit(option);
						break;
						default:
							System.out.println("Option is invalid"+"\n");
						break;
					}
				 }catch(Exception e){
					 System.out.println("Something went wrong, try again");
				 }
			}while (option!=3);
		}
}