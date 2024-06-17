
/**
 * The Patient class represents a patient with their medical details.
 */
public class Patient {
    private int patientId=0;
    private String name=null;
    private int age=0;
    private int weight=0;
    private int height=0;
    private String preexistingConditions=null;
    
    /**
     * Constructor to initialize a Patient object with given parameters.
     */
    public Patient(int patientId,String name,int age, int weight, int height, String preexistingConditions){
        this.patientId=patientId;
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.height=height;
        this.preexistingConditions=preexistingConditions;
    }

    public Patient() {
    }

    //Here are the setters and getters to use in the main methods
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int newpatientId) {
        patientId = newpatientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String newname) {
        name = newname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int newage) {
        age = newage;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int newweight) {
        weight = newweight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int newheight) {
        height = newheight;
    }
    public String getPreexistingConditions() {
        return preexistingConditions;
    }
    public void setPreexistingConditions(String newpreexistingConditions) {
        preexistingConditions = newpreexistingConditions;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age + ", weight=" + weight
                + ", height=" + height + ", preexistingConditions=" + preexistingConditions + "]";
    }
    
}    
 
        

