package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("PC");
        Product product2 = new Product("Laptop");
        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal(3000), 2, new BigDecimal(6000));
        Item item2 = new Item(product2, new BigDecimal(2000), 1, new BigDecimal(2000));


        Invoice invoice = new Invoice("ABCD/1/1", Arrays.asList(item1, item2));

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
            productDao.deleteById(product1.getId());
            productDao.deleteById(product2.getId());
        } catch (Exception e) {
            //
        }
    }
}
