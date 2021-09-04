package com.kodilla.hibernatee.invoice.dao;


import com.kodilla.hibernatee.invoice.Invoice;
import com.kodilla.hibernatee.invoice.Item;
import com.kodilla.hibernatee.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.testng.AssertJUnit.assertNotNull;

@SpringBootTest
public class InvoiceDaoTestSuite {

    private InvoiceDao invoiceDao;
    private static final BigDecimal VALUE_1 = new BigDecimal("13.99");
    private static final BigDecimal VALUE_2 = new BigDecimal("3.99");
    private static final BigDecimal VALUE_3 = new BigDecimal("4.33");
    private static final int QUANTITY_1 = 1;
    private static final int QUANTITY_2 = 5;
    private static final int QUANTITY_3 = 10;
    private static final String NUMBER = "1111";


    @Transactional
    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("apple");
        Product product2 = new Product("lemon");
        Product product3 = new Product("bananas");

        Item item1 = new Item(new BigDecimal("2222"), 1, new BigDecimal("9"));
        Item item2 = new Item(new BigDecimal("1111"), QUANTITY_2, VALUE_2);
        Item item3 = new Item(new BigDecimal("3333"), QUANTITY_3, VALUE_3);

        Invoice invoice1 = new Invoice("1234");

        item1.setProduct(product1);
        item1.setInvoice(invoice1);
        item2.setProduct(product2);
        item2.setInvoice(invoice1);
        item3.setProduct(product3);
        item3.setInvoice(invoice1);

        product1.getItemms().add(item1);
        product2.getItemms().add(item2);
        product3.getItemms().add(item3);

        invoice1.getItemms().add(item1);
        invoice1.getItemms().add(item2);
        invoice1.getItemms().add(item3);

        //When
        invoiceDao.save(invoice1);
        Integer id = invoice1.getId();


        //Then
        assertNotNull(id);
        assertNotNull(product1.getId());
        assertNotNull(product2.getId());
        assertNotNull(product3.getId());
        assertNotNull(item1.getId());
        assertNotNull(item2.getId());
        assertNotNull(item3.getId());
    }
}
