package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product firstProduct = new Product("First product");
        Product secondProduct = new Product("Second product");
        Product thirdProduct = new Product("First product");

        Item firstItem = new Item(new BigDecimal(100), 10, new BigDecimal(1000));
        Item secondItem = new Item(new BigDecimal(200), 20, new BigDecimal(4000));
        Item thirdItem = new Item(new BigDecimal(300), 30, new BigDecimal(9000));

        firstItem.setProduct(firstProduct);
        firstItem.setProduct(secondProduct);
        secondItem.setProduct(thirdProduct);
        secondItem.setProduct(firstProduct);
        thirdItem.setProduct(secondProduct);

        Invoice firstInvoice = new Invoice("1");
        firstInvoice.getItems().add(firstItem);
        firstInvoice.getItems().add(secondItem);
        firstInvoice.getItems().add(thirdItem);

        //When
        productDao.save(firstProduct);
        productDao.save(secondProduct);
        productDao.save(thirdProduct);
        invoiceDao.save(firstInvoice);
        int id = firstInvoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //invoiceDao.deleteById(id);
    }
}
