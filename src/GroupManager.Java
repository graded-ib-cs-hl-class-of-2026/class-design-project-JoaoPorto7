import java.util.Random;

public class GroupManager{
    private String[] allStudents = new String[100]; 
    private int numStudents = 0;
    private Group[] groups = new Group[20]; 
    private int numGroups = 0;


    //It took me some time to realize I needed to rewrite this code in this method so it adds the students to the array and keeps track of how many
    public void addStudent(String name) {
            allStudents[numStudents] = name;
            numStudents++;
    }

    public Group[] getAllGroups() {          
        return groups;
    }

    // Gets the total number of students added
    public int getNumStudents() {
        return numStudents;
    }

    public int getNumGroups() {
        return numGroups;
    }


//the name of this shuffle is fisher-yates https://stackoverflow.com/questions/47450305/fisher-yates-java-vs-collections-shuffle
    public void shuffleStudents() {
        Random r = new Random(); // I used this stle of random on my Madlibs project I believe
        for (int i = numStudents - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            String temp = allStudents[i]; // I used temps on one of my projects I just re did the same structure I used there
            allStudents[i] = allStudents[j];
            allStudents[j] = temp;
        }
    }

    public void createGroups(int numberOfGroups) {
        numGroups = numberOfGroups;

        // Create new empty groups
        for (int i = 0; i < numberOfGroups; i++) {
            groups[i] = new Group();
        }

        // This is a round-robin distribution I had to use a couple of different sources for it https://www.baeldung.com/java-atomicinteger-load-balancer and https://stackoverflow.com/questions/26563522/implementing-round-robin-scheduling-algorithm-in-java
        for (int i = 0; i < numStudents; i++) {
            int groupIndex = i % numberOfGroups;
            groups[groupIndex].addStudent(allStudents[i]);
        }
    }

    //Getter to get the specific group by index
    public Group getGroup(int index) {
        if (index >= 0 && index < numGroups) {
            return groups[index];
        } else {
            return null;
        }
    }

}