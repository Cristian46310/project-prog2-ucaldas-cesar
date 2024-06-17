/**
 * The Dietitian class represents a dietitian with their professional details.
 */
public class Dietitian {
    // Attributes of the Dietitian class
private int dietitianId=0;
private String name=null;
private String Speciality=null;

//Constructor for creating a new Dietitian with specified details.

public Dietitian(int dietitianId, String name, String Speciality){
    this.dietitianId=dietitianId;
    this.name=name;
    this.Speciality=Speciality;
}

//Default constructor for Dietitian.
public Dietitian() {
}

//Here are the setters and getters to use in the main methods

public int getDietitianId() {
    return dietitianId;
}
public void setDietitianId(int newdietitianId) {
    dietitianId = newdietitianId;
}
public String getName() {
    return name;
}
public void setName(String newname) {
    name = newname;
}
public String getSpeciality() {
    return Speciality;
}
public void setSpeciality(String newspeciality) {
    Speciality = newspeciality;
  }
}
