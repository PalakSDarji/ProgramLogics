package com.palak.vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class VendingMachineImpl implements VendingMachine{

    private Inventory<Coin> cashInventory = new Inventory();
    private Inventory<Item> itemInventory = new Inventory();
    private long totalSales;
    private long currentBalance;
    private Item currentItem;

    VendingMachineImpl(){
        init();
    }

    private void init() {
        for(Coin c: Coin.values()){
            cashInventory.put(c,5);
        }

        for(Item i: Item.values()){
            itemInventory.put(i,5);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) throws SoldOutException {
        if(itemInventory.hasItem(item)){
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Item sold out, Please buy another item.");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() throws NotSufficientChangeException {
        return releaseCoinsAndClearOrder(currentBalance);
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() throws NotSufficientChangeException, NotFullPaidException {

        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<>(item, change);
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {

        if(isFullPaid()){
            if(hasSufficientChange()){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not sufficient change in inventory.");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : " + remainingBalance);
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;

        try{
            getChange(amount);
        }
        catch (NotSufficientChangeException e){
            e.printStackTrace();
            hasChange = false;
        }

        return hasChange;
    }

    private List<Coin> releaseCoinsAndClearOrder(long amount) throws NotSufficientChangeException {
        List<Coin> changes = getChange(amount);
        updateCashInventory(changes);
        currentItem = null;
        currentBalance = 0;
        return changes;
    }

    private List<Coin> collectChange() throws NotSufficientChangeException {
        long changeAmount = currentBalance - currentItem.getPrice();
        return releaseCoinsAndClearOrder(changeAmount);
    }

    private void updateCashInventory(List<Coin> changes) {
        for(Coin c: changes){
            cashInventory.deduct(c);
        }
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException{

        List<Coin> changes = Collections.emptyList();

        if(amount > 0) {
            changes = new ArrayList<>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)){
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                }
                else if(balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                }
                else if(balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)){
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                }
                else if(balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                }
                else {
                    throw new NotSufficientChangeException("Not sufficient Change. Please try another product.");
                }
            }
        }

        return changes;
    }

    private boolean isFullPaid() {
        return currentBalance >= currentItem.getPrice();
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentBalance = 0;
        currentItem = null;
    }

    public long getTotalSales(){
        return totalSales;
    }
}
