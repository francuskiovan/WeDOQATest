package tests;

import helpers.Cheese;
import helpers.DemoQA;
import helpers.OrangeHRM;
import helpers.TestListener;
import org.junit.Assert;
import org.junit.Test;
//import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class WeDoQATests extends BaseTest{

    @Test
    public void firstTest() {
        DemoQA.goToDemoQA();
        DemoQA.droppableLink();
        DemoQA.toolTips();
    }

    @Test
    public void secondTest() {
        Assert.assertEquals("There is too much cheese on the internet",777, Cheese.countCheese());
    	//Assert.assertEquals(777, Cheese.countCheese());
    }

    @Test
    public void thirdTest(){
        OrangeHRM.logInOrangeHRM();
        OrangeHRM.addCandidate();
        Assert.assertEquals(OrangeHRM.rowCount + 1, OrangeHRM.newRowCount);
        OrangeHRM.deleteCandidate();
        Assert.assertEquals(OrangeHRM.rowCount - 1, OrangeHRM.newRowCount);
        OrangeHRM.logOut();
    }
}
