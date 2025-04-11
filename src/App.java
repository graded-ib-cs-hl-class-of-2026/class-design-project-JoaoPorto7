public class App {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager();
        Group group = new Group();

        String filename = "class.txt";

        try {
            fm.openFile(filename);
            while (fm.fileHasNextLine()) {
                String line = fm.getNextLine(); // This took a while to figure out. I had to keep looking at mr griswolds code until I realized that I needed to actually add the students inside the try inorder to print out something
                if (!line.isEmpty()) {
                    group.addStudent(line);
                }
            }
            fm.closeFile();
        } catch (Exception e) {
            fm.output(e.toString());
        }

    fm.output("Here are the groups");
    for (int i = 0; i < group.getNumStudents(); i++) {
    String student = group.getStudent(i);
    fm.output("- " + student);
}

    


     
 }
}
