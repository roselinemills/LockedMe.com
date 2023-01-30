package lockedMe;
import java.io.IOException;
import java.util.Scanner;

public class SecondLevelMenu {
	public void displayMenu() {
		System.out.println("\n"+"Select the operation to perform:" +"\n"
				+ "Option 1: Add a file to the existing directory list"+"\n"
				+ "Option 2: Delete a file from the existing directory list. Please note, file names are case sensitive"+"\n"
				+ "Option 3: Search a file from the existing directory list Please note, file names are case sensitive" +"\n"
				+ "Option 4: Go back to main menu");
	}
	
	
	 FileOperations fileOperations = new FileOperations();
	public void selectOperations() throws IOException {
		int operation = 0;
		try (Scanner sc = new Scanner(System.in)) {
				do {
					displayMenu();
						while (sc.hasNextInt()==false){
							System.out.println("Input is invalid. Choose from the options below"+"\n");
							displayMenu();
			                sc.next();
						 }
						try {
						operation = sc.nextInt();
						switch (operation) {
							case 1:
								System.out.println("Enter name of file:");
								String filename = sc.next();
								fileOperations.addFile("dir",filename);
							break;
							case 2:
								System.out.println("Enter name of file:");
								filename = sc.next();					
								fileOperations.deleteFile("dir",filename);
							break;
							case 3:
								System.out.println("Enter name of file");
								filename = sc.next();
								fileOperations.searchFile("dir",filename);
							break;
							case 4:
								System.out.println("Returning to main menu"+"\n");
								ClientInterface.mainMenu();
							break;
							default:
							System.out.println("Option is invalid"+"\n");
						}
						}catch(Exception e) {
							System.out.println("Something went wrong. Please try again");
						}
				}while (operation!=4);
			} 
		}
	}

