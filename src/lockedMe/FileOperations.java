package lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileOperations {
	
	public FileOperations() {
	}
	
	public void createDirectory() {
		
		String path = "C:/Users/roseline.mills/eclipse-workspace/LockedMe.com/dir";
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();
	}
	public void displayFiles(String directory) {
		//createDirectory();
		File file = new File(directory);
	    String absolutePath = file.getAbsolutePath();
	    File dir = new File(absolutePath);
	    if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("Directory doesn't exist"+"\n");
		}else {
			System.out.println("Listing files in directory"+"\n");
			File[] listOfFiles = dir.listFiles();
				if(listOfFiles.length<1) {
					System.out.println("Directory is empty. Please add some files first"+"\n");
				}else {
					Arrays.sort(listOfFiles);
					for (File f : listOfFiles) {
						System.out.println(f.getName());
					}
				}
			System.out.println("\n");
		}
	}

	public void addFile(String directory,String filename) throws IOException {
		 
			File file = new File(directory,filename);
		    String absolutePath = file.getAbsolutePath();
		    File dir = new File(absolutePath);
		    if (!file.exists()) {
		        try{
		            dir.createNewFile();
		            System.out.println(filename + " has been added to directory");
		        } catch (IOException e){
		            e.printStackTrace();
		        }
		    }else {
		        System.out.println("File already exists");
		    }		
		}

	public void deleteFile(String directory,String filename) throws IOException{
		File file = new File (directory);
	    String absolutePath = file.getAbsolutePath();
	    File dir = new File(absolutePath);
		File[] listOfFiles = dir.listFiles();
		
		  boolean found = false; 
		  if (!dir.exists() || !dir.isDirectory()) {
				System.out.println("Directory doesn't exist"+"\n");
		  }else {
			  for (int i = 0; i < listOfFiles.length; i++){ 
				  if
					  (listOfFiles[i].getName().equals(filename)) { 
						  found = true;
						  listOfFiles[i].delete();
					  System.out.println("File deleted successfully"); 
					  break; 
				  } 
			  } if (found==false)
		  		System.out.println("File not found");
		  }	 
	}

	public void searchFile(String directory,String filename) {
		File file = new File(directory);
	    String absolutePath = file.getAbsolutePath();
	    File dir = new File(absolutePath);
	    
		File[] listOfFiles = dir.listFiles();
		boolean found = false;
		for (int i = 0; i < listOfFiles.length; i++) {
			listOfFiles[i].getName();
			if (listOfFiles[i].getName().equals(filename)) {
				found = true;
				System.out.println(filename+ " File found");
				break;
			}
		}
		if (found == false) {
			System.out.println("File not found");
		}
	}
}