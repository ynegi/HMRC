package hmrc;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckOutSystemTest {

    CheckOutSystem checkOutSystem;

    @Before
    public void setUp(){

        checkOutSystem = new CheckOutSystem();
    }

    @Test
    public void calcTotalCostWhenCartIsEmpty(){

        assertEquals(0, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHasOneApple(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        assertEquals(0.60, checkOutSystem.totalCost(), 0);
    }

    private double getApplePrice() {
        return Fruit.Apple.getPrice();
    }

    @Test
    public void calcTotalCostWhenCartHasOneOrange(){
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        assertEquals(0.25, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHas2Apples(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        assertEquals(1.20, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHas2Orange(){
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());

        assertEquals(0.5, checkOutSystem.totalCost(), 0);

    }
    @Test
    public void calcTotalCostWhenCartHasOneAppleOneOrange(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        assertEquals(0.85, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHasAppleAppleOrangeApple(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        assertEquals(2.05, checkOutSystem.totalCost(), 0);
    }

    private String getOrange() {
        return Fruit.Orange.name();
    }

    @Test
    public void calcTotalAfterApplyAppleDiscountBuyOneGetOneFreeOnTwoApples(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        assertEquals(.60, checkOutSystem.totalCost(), 0);

    }

    private String getApple() {
        return Fruit.Apple.name();
    }

    @Test
    public void calcTotalAfterApplyAppleDiscountBuyOneGetOneFreeOnThreeApples(){
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        checkOutSystem.addItem(getApple(), getApplePrice());
        assertEquals(1.20, checkOutSystem.totalCost(), 0.0);

    }

    @Test
    public void calcTotalAfterApplyOrangeDiscountThreeForTwoPriceOnThreeOranges(){
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        assertEquals(0.50, checkOutSystem.totalCost(), 0);
    }

    private double getOrangePrice() {
        return Fruit.Orange.getPrice();
    }

    @Test
    public void calcTotalAfterApplyOrangeDiscountThreeForTwoPriceOnFourOranges(){
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        assertEquals(0.75, checkOutSystem.totalCost(), 0);

    }

    @Test
    public void calcTotalAfterApplyOrangeDiscountThreeForTwoPriceOnFiveOranges(){
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        checkOutSystem.addItem(getOrange(), getOrangePrice());
        assertEquals(1.00, checkOutSystem.totalCost(), 0);

    }
    @After
    public void printItems(){

        System.out.println(checkOutSystem.toString());
    }

}
