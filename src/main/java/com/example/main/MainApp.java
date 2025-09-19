package com.example.main;

import com.example.entity.OrderItem;
import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.service.impl.OrderImpl;

public class MainApp {
    static int choice;
   public static void main(String[] args) {
        OrderImpl orders = new OrderImpl(10);


        try {
            orders.addItems(new OrderItem(101, "TeleVision", 70000));
            orders.addItems(new OrderItem(201, "Home-Theater", 60000));
            orders.addItems(new OrderItem(301, "Mobiles", 30000));
            orders.addItems(new OrderItem(101, "HeadPhones", 50000));
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }

        do {
            IO.println("""
                    ==== Flipkart Order Management ====
                    1. Add Item
                    2. View All Items
                    3. Update Item
                    4. Delete Item
                    5. Search Item by Name
                    6. Exit
                    """);
            IO.println("Enter Choice: ");
            int choice = Integer.parseInt(IO.readln());

            try {
                switch (choice) {
                    case 1 -> {
                        IO.print("Enter Item ID: ");
                        int id = Integer.parseInt(IO.readln());
                        IO.print("Enter Item Name: ");
                        String name = IO.readln();
                        IO.print("Enter Price: ");
                        double price = Double.parseDouble(IO.readln());
                        orders.addItems(new OrderItem(id, name, price));
                        IO.println("Item added successfully.");
                    }
                    case 2 -> orders.viewItems();

                    case 3 -> {
                        IO.print("Enter Item ID to update: ");
                        int uid = Integer.parseInt(IO.readln());
                        IO.print("Enter new Name: ");
                        String newName = IO.readln();
                        IO.print("Enter new Price: ");
                        double newPrice = Double.parseDouble(IO.readln());
                        orders.updateItems(uid, newName, newPrice);
                        IO.println("Item updated.");
                    }
                    case 4 -> {
                        IO.print("Enter Item ID to delete: ");
                        int did = Integer.parseInt(IO.readln());
                        orders.deleteItems(did);
                        IO.println("Item deleted.");
                    }
                    case 5 -> {
                        IO.print("Enter Item Name to search: ");
                        String sname = IO.readln();
                        IO.println("Found: ");
                    }

                    case 6 -> IO.println("Exiting...");
                    default -> IO.println("Invalid choice!");
                }
            } catch (ItemNotFoundException | DuplicateItemException e) {
                IO.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }
}