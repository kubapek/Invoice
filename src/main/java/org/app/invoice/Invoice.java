package org.app.invoice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Klasa Invoice spełnia zasadę "High Cohesion",
// ponieważ ma jasno zdefiniowaną odpowiedzialność związaną z obsługą faktur.
// Przechowuje informacje o fakturze i zarządza jej pozycjami.

@Getter
@Setter
public class Invoice {
    private List<InvoiceItem> items;
    private int invoiceNumber;
    private String customerName;

    public Invoice(int invoiceNumber, String customerName) {
        this.items = new ArrayList<>();
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (InvoiceItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice for ").append(customerName).append("with ID: ").append(invoiceNumber).append("\n");
        for (InvoiceItem item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total Amount: ").append(getTotalAmount());
        return sb.toString();
    }
}
