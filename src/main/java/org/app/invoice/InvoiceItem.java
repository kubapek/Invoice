package org.app.invoice;

import lombok.Getter;
import lombok.Setter;

// Klasa InvoiceItem ma jasno zdefiniowaną odpowiedzialność polegającą na
// przechowywaniu informacji na temat pozycji na fakturze i obliczaniu łącznej kwoty.

@Getter
@Setter
public class InvoiceItem {
    private String productName;
    private int quantity;
    private double price;

    public InvoiceItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return productName + ": " + quantity + " x " + price + " = " + getTotal();
    }
}
