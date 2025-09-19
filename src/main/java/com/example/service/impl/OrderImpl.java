package com.example.service.impl;

import com.example.entity.OrderItem;
import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.service.OrderOperations;

public class OrderImpl implements OrderOperations {
    public OrderItem[] items;
    public int size;

    public OrderImpl(int capacity) {
        items = new OrderItem[capacity];
        size = 0;
    }

    @Override
    public void addItems(OrderItem item) throws DuplicateItemException {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItemName().equals(item.getItemName())) {
                throw new DuplicateItemException(item.getItemName());
            }
        }
        if (size < items.length) {
            items[size++] = item;

        }
        else {
            IO.println("There is already an order item with the name " + item.getItemName());
        }

    }

    @Override
    public void viewItems() {
        if(size == 0) {
            IO.println("There is no order items in the system");
        }
        else {
            for (int i = 0; i < size; i++) {
                IO.println("Item " + items[i].toString());
            }
        }
        }


    @Override
    public void updateItems(int Itemid, String newName, double newPrice) throws ItemNotFoundException {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItemName().equals(items[i].getItemName())) {
                items[i].setItemName(newName);
                items[i].setPrice(newPrice);
                return;

            } else {
                throw new ItemNotFoundException("Item not found with ID: " + Itemid);
            }
        }
    }

        @Override
        public void deleteItems (int Itemid) throws ItemNotFoundException{
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItemName().equals(items[i].getItemName())) {
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--size] = null;
                return;
            }

        }
        throw new ItemNotFoundException("Item not found with ID:" + Itemid);
    }

        @Override
        public void searchItems (String itemName) throws ItemNotFoundException{
            for (int i = 0; i < size; i++) {
                if (items[i].getItemName().equals(itemName)) {
                    IO.println("Item is: "+ items[i].toString());
                }
            }
            throw new ItemNotFoundException("Item with name '" + itemName + "' not found!");
        }

        }
