import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager();
        Scanner scanner = new Scanner(System.in); // For some reason this is getting underlined but the code works and if I delete it the code breaks so I just didn't try to fix it
        GroupManager gm = new GroupManager();  

        String filename = "class.txt";
// I still dont quite understand this try command I just kind of used the madlibs as a reference
        try {
            fm.openFile(filename);
            while (fm.fileHasNextLine()) {
                String line = fm.getNextLine(); // This took a while to figure out. I had to keep looking at mr griswolds code until I realized that I needed to actually add the students inside the try inorder to print out something
                if (!line.isEmpty()) {
                    gm.addStudent(line); 

                }
            }
            fm.closeFile();
        } catch (Exception e) {
            fm.output(e.toString());
        }
        System.out.print("How many groups would you like? ");
        int numberOfGroups = scanner.nextInt();

        gm.shuffleStudents();
        gm.createGroups(numberOfGroups);


        fm.output("\nHere are the groups:");
        for (int i = 0; i < gm.getNumGroups(); i++) {
            Group g = gm.getGroup(i);
            fm.output("Group " + (i + 1) + ":");
        
            for (int j = 0; j < g.getNumStudents(); j++) {
                fm.output("- " + g.getStudent(j));
            }
        
            fm.output(""); 
        }
//For some reason it took me a while to figure this code out. I was trying to use println then remembered I could just use out put
        fm.output("Do you want to save the groups to a file? (yes/no)");
        String choice = fm.input().toLowerCase();

        if (choice.equals("yes")) {
             fm.saveGroupsToFile(gm.getAllGroups(), gm.getNumGroups());
        } else {
            fm.output("Groups were not saved.");
                }   

                fm.output("Would you like to save the groups to a custom file? (yes/no)");
                String answer = fm.input().toLowerCase();


//this code is very simlar to the one above
        if (answer.equals("yes")) {
             fm.output("Enter the filename (example mygroups.txt):");
            String customFilename = fm.input();
            fm.saveGroupsToCustomFile(customFilename, gm.getAllGroups(), gm.getNumGroups());
        } else {
           fm.output("Groups were not saved.");
}




        
        
}

    


     
 }

