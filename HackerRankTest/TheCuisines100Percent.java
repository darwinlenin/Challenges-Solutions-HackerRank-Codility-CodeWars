import java.util.Scanner;

abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}


/*
 * Create the FoodFactory class and other required classes here.
 */

class FoodFactory extends Cuisine{
    public static Chinese chinese;
    public static Italian italian;
    public static Japanese japanese;
    public static Mexican mexican;
    static final FoodFactory factory = new FoodFactory();

    public static Chinese getChinese() {
        return chinese;
    }

    public static Italian getItalian() {
        return italian;
    }

    public static Japanese getJapanese() {
        return japanese;
    }

    public static Mexican getMexican() {
        return mexican;
    }

    public static FoodFactory getFactory(){
        return factory;
    }

    public Cuisine serveFood(String dish) {
        Chinese chinese = FoodFactory.getChinese();
        return chinese;
    }

    public void registerCuisine(String restorant, Object object){
        if(restorant.equals("Chinese")) {
            chinese = (Chinese) object;
            if(chinese!=null) {
                chinese.serveFood("Lamian");
            }
        }else if(restorant.equals("Italian")) {
            italian = (Italian) object;
            if(italian!=null) {
                italian.serveFood("Lasagne");
            } 
        }else if(restorant.equals("Japanese")) {
            japanese = (Japanese) object;
            if(japanese!=null) {
                japanese.serveFood("Kamameshi");
            } 
        }else if(restorant.equals("Mexican")) {
            mexican = (Mexican) object;
            if(mexican!=null) {
                mexican.serveFood("Machaca");
            } 
        }
    } 

    public Cuisine serveCuisine(String cuisine,String dish) throws UnservableCuisineRequestException{
        Cuisine cuisines = null;
        if(cuisine.equals("Italian")) {
            cuisines = italian;
        }else if(cuisine.equals("Mexican")) {
            cuisines = mexican;
        }else if(cuisine.equals("Japanese")) {
            cuisines = japanese;
        }else if(cuisine.equals("Chinese")) {
            cuisines = chinese;
        }
        if(cuisines!=null) {
            return cuisines.serveFood(dish);
        }else {
            throw new UnservableCuisineRequestException("Unservable cuisine "+cuisine+" for dish "+ dish);
        } 
    }
}

class Chinese extends Cuisine {
    String dish;
    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }

    public Cuisine serveFood(String dish) {
        Chinese chinese = FoodFactory.getChinese();
        chinese.setDish(dish);
        return chinese;
    }
}

class Italian extends Cuisine {
    String dish;
    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }

    public Cuisine serveFood(String dish) {
        Italian italian = FoodFactory.getItalian();
        italian.setDish(dish);
        return italian;
    }
}

class Japanese extends Cuisine {
    String dish;
    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }

    public Cuisine serveFood(String dish) {
        Japanese japanese = FoodFactory.getJapanese();
        japanese.setDish(dish);
        return japanese;
    }
}

class Mexican extends Cuisine {
    String dish;
    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }

    public Cuisine serveFood(String dish) {
        Mexican mexican = FoodFactory.getMexican();
        mexican.setDish(dish);
        return mexican;
    }
}


public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();
    
    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }
    
    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}