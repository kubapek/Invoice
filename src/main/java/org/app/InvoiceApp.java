package org.app;

import org.app.invoice.InvoiceService;

import java.util.Scanner;

public class InvoiceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceService invoiceService = new InvoiceService(scanner);

        boolean continueCreatingInvoices = true;
        while (continueCreatingInvoices) {
            System.out.print("Do you want to create, show, or close an invoice? (create/show/close): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            switch (answer) {
                case "create" -> invoiceService.newInvoice();
                case "show" -> {
                    System.out.println("Give invoice ID: ");
                    int i;
                    if (scanner.hasNextInt()) {
                        i = scanner.nextInt();
                        scanner.nextLine();
                        invoiceService.showInvoices(i);
                    } else {
                        System.out.println("Invalid input. Please enter a valid invoice ID.");
                        scanner.nextLine();
                    }
                }
                case "close" -> continueCreatingInvoices = false;
                default -> System.out.println("Invalid option. Please choose 'create', 'show', or 'close'.");
            }
        }

        scanner.close();
    }
}
