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
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        assertEquals(0.60, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHasOneOrange(){
        checkOutSystem.addItem(Fruit.Orange.name(), 0.25);
        assertEquals(0.25, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHas2Apples(){
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        assertEquals(1.20, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHas2Orange(){
        checkOutSystem.addItem(Fruit.Orange.name(), 0.25);
        checkOutSystem.addItem(Fruit.Orange.name(), 0.25);

        assertEquals(0.5, checkOutSystem.totalCost(), 0);

    }
    @Test
    public void calcTotalCostWhenCartHasOneAppleOneOrange(){
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        checkOutSystem.addItem(Fruit.Orange.name(), 0.25);
        assertEquals(0.85, checkOutSystem.totalCost(), 0);
    }

    @Test
    public void calcTotalCostWhenCartHasAppleAppleOrangeApple(){
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        checkOutSystem.addItem(Fruit.Orange.name(), 0.25);
        checkOutSystem.addItem(Fruit.Apple.name(), 0.60);
        assertEquals(2.05, checkOutSystem.totalCost(), 0);
    }

    @After
    public void printItems(){
        System.out.println(checkOutSystem.toString());
    }


}
