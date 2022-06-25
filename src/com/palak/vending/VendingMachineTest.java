package com.palak.vending;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class VendingMachineTest {
    private static VendingMachine vm;

    @BeforeClass
    public static void setup(){
        vm = VendingMachineFactory.createVendingMachine();
    }

    @AfterClass
    public static void tearDown(){
        vm = null;
    }

    @Test
    public void testBuyItemWithExcatPrice() throws SoldOutException, NotSufficientChangeException, NotFullPaidException {

        long price = vm.selectItemAndGetPrice(Item.COKE);

        Assert.assertEquals(Item.COKE.getPrice(), price);

        vm.insertCoin(Coin.QUARTER);

        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();

        Assert.assertEquals(Item.COKE, bucket.getFirst());
        Assert.assertTrue(bucket.getSecond().isEmpty());
    }

    @Test
    public void testBuyItemWithMorePrice() throws SoldOutException, NotSufficientChangeException, NotFullPaidException {
        long price = vm.selectItemAndGetPrice(Item.PEPSI);

        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.DIME);

        Bucket<Item,List<Coin>> bucket = vm.collectItemAndChange();

        long totalChange = 0;

        for(Coin c : bucket.getSecond()){
            totalChange += c.getDenomination();
        }

        Assert.assertEquals(5,totalChange);
    }

    @Test(expected = SoldOutException.class)
    public void testReset() throws SoldOutException {
        VendingMachine vendingMachine = VendingMachineFactory.createVendingMachine();
        vendingMachine.reset();

        vendingMachine.selectItemAndGetPrice(Item.SODA);
    }
}
