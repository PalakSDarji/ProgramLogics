package com.palak.vending;

import java.util.List;

public interface VendingMachine {
    long selectItemAndGetPrice(Item item) throws SoldOutException;
    void insertCoin(Coin coin);
    List<Coin> refund() throws NotSufficientChangeException;
    Bucket<Item, List<Coin>> collectItemAndChange() throws NotSufficientChangeException, NotFullPaidException;
    void reset();
}
