package org.app.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceService {
    private Scanner scanner;
    private List<Invoice> invoices = new ArrayList<>();
    private int nextInvoiceNumber = 1;

    public InvoiceService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Invoice newInvoice() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        Invoice invoice = new Invoice(nextInvoiceNumber, customerName);
        nextInvoiceNumber++;

        boolean continueAddingItems = true;
        while (continueAddingItems) {
            try {
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                InvoiceItem item = new InvoiceItem(productName, quantity, price);
                invoice.addItem(item);

                System.out.print("Do you want to add another item? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("yes")) {
                    continueAddingItems = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        invoices.add(invoice);
        return invoice;
    }

    public void showInvoices(int i) {
        if (i >= 1 && i <= invoices.size()) {
            System.out.println(invoices.get(i - 1));
        } else {
            System.out.println("Invalid invoice ID. Please enter a valid ID.");
        }
    }
}