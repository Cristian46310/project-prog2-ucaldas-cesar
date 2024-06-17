import java.util.ArrayList;
import java.util.List;

/**
 * The Read class provides methods to display various categories of food items.
 */
public class Read {
    Main2 main2=new Main2();

    /**
     * Displays a list of different types of milk products.
     */    
    public void showMilk(){
        String[]Milk={"Leche liquida","Semidescremada","Leche en polvo","Kumis dietetico","Yogurt dietetico","Helado dietetico"};
        for (String milk : Milk) {
            System.out.println(milk);
            System.out.println();
        }
        
    }
    /**
     * Displays a list of different types of legumes.
     */
    public void showLegum(){
        String[]Legums={"Arvejas","Frijol cocido","Frijol verde","Garbanzos","Lentejas"};
        for (String legum : Legums) {
            System.out.println(legum);       
        }
    }
     /**
     * Displays a list of different types of cheeses and their derivatives.
     */
    public void showCheesesandderivatives(){
        String[]Cheesesandderivatives={"Queso","Quesito","Cuajada","Queso en loncha"};
        for (String chese : Cheesesandderivatives) {
            System.out.println(chese);      
        }
    }
    /**
     * Displays a list of different types of nuts and seeds.
     */

    public void showNutsanSeeds(){
        String[]nutsAndSeeds={"Ajonjoli","Girasol","Chia","Soya","Linaza","Mani","Nueces","almendras"};
        for (String nuts : nutsAndSeeds) {
            System.out.println(nuts);     
        }
    }
     /**
     * Displays a list of different types of meats.
     */
    public void showMeats(){
        String[]meats={"Cerdo","Conejo","Pescado","Pollo","Ternera","Atun"};
        for (String meat : meats) {
            System.out.println(meat);        
        }
    }
     /**
     * Displays a list of different types of fats.
     */
    public void showFats(){
        String[]fats={"Aceite vegetal","Mantequilla","Mayonesa","Aguacate","Aceite de oliva"};
        for (String fat : fats) {
            System.out.println(fat);  
        }
    }
    /**
     * Displays a list of different types of vegetables.
     */
    public void showVegetables(){
        String[]Vegetables={"Aceigas","Ahuyama","Apio","Berenjena","Brocoli","Calabacin","Cebolla","Cidra","Champiñiones","Col","Coles de bruselas","Coliflor","Esparragos","Espinaca","Habichuela","Habichuela","Lechuga","Nabo","Pepino","Pimientos","Puerro","Rabano","Remolacha","Repollo","Rugula,","Tomate","Zanahorias"};
        for (String vegetable : Vegetables) {
            System.out.println(vegetable);  
        }
    }
     /**
     * Displays a list of different types of fruits.
     */
    public void showFruits(){
        String[]fruits={"Manzana","Pera","Banano","Sandia","Piña","Maracuya","Mango","Papaya","Tomate de arbol"};
        for(String fruit:fruits){
            System.out.println(fruit);
        }
    }
     /**
     * Displays a list of different types of flours and flour-based foods.
     */
    public void showFlours(){
        String[]flours={"Arepa","Pan integral","Pan blanco","Tostada","Papa criolla","Yuca","Buñuelo","Papa comun","Galletas"};
        for (String flour : flours) {
            System.out.println(flour);
            
        }
    }
}