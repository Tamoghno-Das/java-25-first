package com.example.service;

import com.example.entity.OrderItem;
import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;

import java.util.Set;

public interface OrderOperations {
    void addItems(OrderItem item) throws DuplicateItemException;
    void viewItems();
    void updateItems(int Itemid,String newName,double newPrice) throws ItemNotFoundException;
    void deleteItems(int Itemid) throws ItemNotFoundException;
    void searchItems(String itemName) throws ItemNotFoundException;
}
