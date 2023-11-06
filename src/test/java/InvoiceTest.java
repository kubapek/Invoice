import org.app.invoice.Invoice;
import org.app.invoice.InvoiceItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {

    @Test
    void testTotalAmountCalculation() {
        Invoice invoice = new Invoice(1, "Customer A");
        InvoiceItem item1 = new InvoiceItem("Product 1", 2, 10.0);
        InvoiceItem item2 = new InvoiceItem("Product 2", 3, 15.0);

        invoice.addItem(item1);
        invoice.addItem(item2);

        assertEquals(2 * 10.0 + 3 * 15.0, invoice.getTotalAmount(), 0.001);
    }

    @Test
    void testInvoiceItemTotalCalculation() {
        InvoiceItem item = new InvoiceItem("Product X", 5, 7.5);
        assertEquals(5 * 7.5, item.getTotal(), 0.001);
    }

    @Test
    void testInvoiceToString() {
        Invoice invoice = new Invoice(1, "Customer B");
        InvoiceItem item1 = new InvoiceItem("Product Y", 2, 20.0);
        InvoiceItem item2 = new InvoiceItem("Product Z", 1, 15.0);

        invoice.addItem(item1);
        invoice.addItem(item2);

        String expected = "Invoice for Customer B\n" +
                "Product Y: 2 x 20.0 = 40.0\n" +
                "Product Z: 1 x 15.0 = 15.0\n" +
                "Total Amount: 55.0";

        assertEquals(expected, invoice.toString());
    }
}
