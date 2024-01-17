package com.example.demo.view;

import com.example.demo.services.CustomerService;
import com.example.demo.services.DeliveryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ShopMenu {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private DeliveryService deliveryService;
    public void menu(Scanner scanner){
        System.out.println("----------Menu----------");

        System.out.println("1 - Insert Customer");
        System.out.println("2 - Insert Product");
        System.out.println("3 - Insert Shipper");
        System.out.println("4 - Insert Delivery");
        System.out.println("5 - Show Delivery Status");
        System.out.println("6 - Update Deliveries Status");
        System.out.println("0 - Exits");

        int input = Integer.parseInt(new Scanner(System.in).nextLine());

        switch (input){
            case 1:
                insertCustomer(scanner);
                break;
            case 2:
                insertProduct(scanner);
                break;
            case 3:
                insertShipper(scanner);
                break;
            case 4:
                insertDelivery(scanner);
                break;
            case 5:
                deliveryStatus(scanner);
                break;
            case 6:
                updateStatus(scanner);
                break;
            case 0:
                System.exit(0);
        }
    }

    public void insertCustomer(Scanner scanner){
        System.out.println("Insert a Customer: ");

        System.out.println("Customer's Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Customer's Email: ");
        String email = new Scanner(System.in).nextLine();

        System.out.println("Customer's Phone Number: ");
        String phone = new Scanner(System.in).nextLine();

        customerService.insertCustomer(name, email, phone);

        System.out.println("Do you want to keep adding(y/n)");

        String check = new Scanner(System.in).nextLine();

        if (check.equals("y")){
            insertCustomer(scanner);
        } else if (check.equals("n")){
            menu(scanner);
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }

    public void insertProduct(Scanner scanner){
        System.out.println("Insert Product: ");

        System.out.println("Product's Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Product's quantity: ");
        int quantity = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println("Product's price: ");
        int price = Integer.parseInt(new Scanner(System.in).nextLine());

        productService.insertProduct(name, quantity, price);

        System.out.println("Do you want to keep adding(y/n)");

        String check = new Scanner(System.in).nextLine();

        if (check.equals("y")){
            insertProduct(scanner);
        } else if (check.equals("n")){
            menu(scanner);
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }

    public void insertShipper(Scanner scanner){
        System.out.println("Insert a Shipper: ");

        System.out.println("Shipper's Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Shipper's Phone Number: ");
        String phone = new Scanner(System.in).nextLine();

        shipperService.insertShipper(name,phone);

        System.out.println("Do you want to keep adding(y/n)");

        String check = new Scanner(System.in).nextLine();

        if (check.equals("y")){
            insertShipper(scanner);
        } else if (check.equals("n")){
            menu(scanner);
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }

    public void insertDelivery(Scanner scanner){
        System.out.println("Insert Order: ");

        System.out.println("Product's id: ");
        int product_id = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println("Product's quantity: ");
        int order_quantity = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println("Date of Order(DD/MM/YYYY): ");//DD/MM/YYYY
        String order_date = new Scanner(System.in).nextLine();

        System.out.println("Order's status(Delivered/Waiting Confirmation/Cancelled): ");
        String status = new Scanner(System.in).nextLine();

        deliveryService.insertDelivery(product_id, order_quantity, order_date, status);

        System.out.println("Do you want to keep adding(y/n)");
        String check = new Scanner(System.in).nextLine();
        if (check.equals("y")){
            insertDelivery(scanner);
        } else if (check.equals("n")){
            menu(scanner);
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }

//    public void deliveryStatus (Scanner scanner){
//        System.out.println("Which delivery's status that you want to check");
//
//        System.out.println("1-Order is Waiting Confirmation");
//        System.out.println("2-Order is Delivered");
//
//        int check = Integer.parseInt(new Scanner(System.in).nextLine());
//        String status = "";
//
//        switch (check){
//            case 1:
//                status = "Waiting Confirmation";
//                break;
//            case 2:
//                status = "Delivered";
//                break;
//            default:
//                System.out.println("Wrong input");
//                deliveryStatus(scanner);
//        }
//        deliveryService.deliveryStatus(status);
//    }

    public void deliveryStatus(Scanner scanner){
        deliveryService.findDeliveryStatus();

        System.out.println("Do you want to return to Menu(y/n)");

        String check = new Scanner(System.in).nextLine();

        if (check.equals("y")){
            menu(scanner);
        } else if (check.equals("n")){
            System.exit(0);
        } else {
            System.out.println("Wrong Input");
            deliveryStatus(scanner);
        }
    }

    public void updateStatus(Scanner scanner){
        System.out.println("Select a status: ");
        System.out.println("1-Is Waiting Confirmation");
        System.out.println("2-Is Delivered");
        System.out.println("3-Is Cancelled");

        int check = Integer.parseInt(new Scanner(System.in).nextLine());

        switch (check){
            case 1:
                deliveryService.updateDeliveriesToWaitingConfirmation();
                break;
            case 2:
                deliveryService.updateDeliveriesToDelivered();
                break;
            case 3:
                deliveryService.updateDeliveriesToCancelled();
                break;
            default:
                System.out.println("Wrong Input");
                updateStatus(scanner);
        }

        System.out.println("Do you want to continue(y/n)");

        String continuing = new Scanner(System.in).nextLine();

        if (continuing.equals("y")){
            updateStatus(scanner);
        } else if (continuing.equals("n")){
            menu(scanner);
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }
}
