import java.util.Scanner;
import java.io.*;



public class FileManager {
    private Scanner in = new Scanner(System.in);
    private Scanner fileInput;
    private File file;

    public void openFile(String filename) throws FileNotFoundException {
        file = new File(filename);
        fileInput = new Scanner(file);
    }

    public void closeFile() {
        if (fileInput != null) {
            fileInput.close();
        }
        file = null;
        fileInput = null;
    }
    
    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        }else {
            return fileInput.hasNextLine();
        }
        }
    
        public String getNextLine() {
            if (fileHasNextLine()) {
                return fileInput.nextLine();
            }else {
                return "";
            }
            
        }
    
        public void output(String s) {
            System.out.println(s);
        }
    
        public String input() {
            return in.nextLine();
        }


        //tomas helped me a bit with this code but it is basicly just the same as the regular ouput but onto a file
        //I still used info from the sources below (before next method)
          public void saveGroupsToFile(Group[] groups, int numGroups) {
        try {
            PrintWriter writer = new PrintWriter("lastgroups.txt"); 

            for (int i = 0; i < numGroups; i++) {
                Group g = groups[i];
                writer.println("Group " + (i + 1) + ":");

                for (int j = 0; j < g.getNumStudents(); j++) {
                    writer.println("- " + g.getStudent(j));
                }

                writer.println(); 
            }

            writer.close();
            output("Groups successfully saved to lastgroups.txt.");

        } catch (FileNotFoundException e) {
            output("Error saving to file: " + e.getMessage());
        }
    }
//this is the code used to save it to a custom file. It was fairly simple once I learned how to write to a file 
// these were the sources I uses:
//https://www.programiz.com/java-programming/printwriter
//https://docs.oracle.com/javase/tutorial/essential/io/file.html
    public void saveGroupsToCustomFile(String filename, Group[] groups, int numGroups) {
        try {
            PrintWriter writer = new PrintWriter(filename); // its basicly the same code above with the exception it uses a custom file
    
            for (int i = 0; i < numGroups; i++) {
                Group g = groups[i];
                writer.println("Group " + (i + 1) + ":");
    
                for (int j = 0; j < g.getNumStudents(); j++) {
                    writer.println("- " + g.getStudent(j));
                }
    
                writer.println(); 
            }
    
            writer.close();
            output("Groups successfully saved to: " + filename);
        } catch (FileNotFoundException e) {
            output("Error saving to file: " + e.getMessage());
        }
    }
    

}
