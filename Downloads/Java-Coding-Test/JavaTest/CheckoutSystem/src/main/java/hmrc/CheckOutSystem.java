package hmrc;
import java.util.ArrayList;
import java.util.List;

public class CheckOutSystem {
    private List<Item> cart;
    private double totalCost;

    public CheckOutSystem() {

        cart =  new ArrayList<>();
        totalCost = 0.0;
    }

    public void addItem(String name, double price) {

        cart.add(new Item(name,price));
    }

    public double totalCost() {

        if(cart.isEmpty()) {
            return totalCost;
        }

/*        totalCost = cart
                .stream()
                .mapToDouble(Item::getItemPrice)
                .sum();*/

        totalCost = applyDiscount();

        return totalCost;
    }

    private double applyDiscount() {

        long amountOfApple = getItemCount(Fruit.Apple.name());

        long amountOfOrange =  getItemCount(Fruit.Orange.name());

        if ( amountOfOrange > 0  )
            totalCost  = apply3For2Discount(amountOfOrange);


        if ( amountOfApple > 0  )
            totalCost = totalCost+ apply2For1Discount(amountOfApple);


        return totalCost;

    }

    private long getItemCount(String itemNameToCount) {
        return cart.stream().filter(item -> itemNameToCount.equals(item.getItemName())).count();
    }

    private double apply3For2Discount(long amountOfOrange) {
        return (amountOfOrange /3)* 2 * Fruit.Orange.getPrice()  +(amountOfOrange % 3) * Fruit.Orange.getPrice();

    }

    private double apply2For1Discount(long amountOfApple) {
        return (amountOfApple /2) * Fruit.Apple.getPrice() + (amountOfApple % 2) * Fruit.Apple.getPrice();
    }

    @Override
    public String toString() {
        return "CheckOutSystem{" +
                "cart=" + cart +
                " Total of Cart=" + totalCost +
                '}';
    }
}
