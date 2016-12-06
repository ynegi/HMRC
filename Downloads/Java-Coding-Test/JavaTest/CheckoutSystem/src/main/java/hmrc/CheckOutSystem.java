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

        totalCost = cart
                .stream()
                .mapToDouble(Item::getItemPrice)
                .sum();

        return totalCost;
    }

    @Override
    public String toString() {
        return "CheckOutSystem{" +
                "cart=" + cart +
                " Total of Cart=" + totalCost +
                '}';
    }
}
