/**
 * The Meal class represents a meal with its nutritional details.
 */
public class Meal {
    private String name=null;
    private String macronutrients=null;
    private int calories=0;
    private String timeOfDay=null;
    private int id=0;


    public Meal(){
    }

    /**
     * Constructor to initialize a Meal object with given parameters.
     */
public Meal(int id,String name, String macronutrients, int calories, String timeOfDay){
    this.name=name;
    this.macronutrients=macronutrients;
    this.calories=calories;
    this.timeOfDay=timeOfDay; 
    this.id=id;
   } 

   //Here are the setters and getters to use in the main methods
    public String getName() {
        return name;
    }
    public void setName(String newname) {
        name = newname;
    }
    public String getMacronutrients() {
        return macronutrients;
    }
    public void setMacronutrients(String newmacronutrients) {
        macronutrients = newmacronutrients;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int newcalories) {
        calories = newcalories;
    }
    public String getTimeOfDay() {
        return timeOfDay;
    }
    public void setTimeOfDay(String newtimeOfDay) {
        timeOfDay = newtimeOfDay;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Meal [name=" + name + ", macronutrients=" + macronutrients + ", calories=" + calories + ", timeOfDay="
        
        + timeOfDay + ", id=" +"]";
    }
}


