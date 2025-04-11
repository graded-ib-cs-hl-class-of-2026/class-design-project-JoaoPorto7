
public class Group {
    private String[] students = new String[100];        
    private int numStudents = 0;  

    public void addStudent(String s) {
        students[numStudents] = s;
        numStudents++;
    }
    
    public String getStudent(int i) {
        if (i >= 0 && i < numStudents) {
            return students[i];
        } else {
            return null;
        }

        
    }

    public int getNumStudents() {
        return numStudents;
    }
    
}