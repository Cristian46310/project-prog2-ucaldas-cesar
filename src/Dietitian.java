import java.util.ArrayList;

public class Dietitian {
private int dietitianId=0;
private String name=null;
private String Speciality=null;
// private ArrayList<Dietitian> dietitians=null;


// public Dietitian(){
//  dietitians=new ArrayList<>();

// }
public Dietitian(int dietitianId, String name, String Speciality){
    this.dietitianId=dietitianId;
    this.name=name;
    this.Speciality=Speciality;
}

public Dietitian() {
    //TODO Auto-generated constructor stub
}

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
// public ArrayList<Dietitian> getDietitians() {
//     return dietitians;
// }
// public void setDietitians(ArrayList<Dietitian> dietitians) {
//     this.dietitians = dietitians;
// }

// public boolean registerDietitian(Dietitian newdietitian){
//     Dietitian dietitian=getDietitian(newdietitian.getDietitianId());
//     if(dietitian == null){
//         dietitians.add(newdietitian);
//         return true;
//     }
//     return false;

// }

// public Dietitian getDietitian(int anId){
//     for(Dietitian dietitian: dietitians){
//         if(dietitian.getDietitianId()==anId){
//             return dietitian;
//         }
//     }
//     return null;
// }
}
