package com.kodilla.hibernatee.invoice.dao;

import com.kodilla.hibernatee.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface InvoiceDao {


    void save(Invoice invoice1);

    @Transactional
    @Repository
    interface InvoicesDao extends CrudRepository<Invoice, String> {
        List<Invoice> findByNumber(String number);
    }
}
