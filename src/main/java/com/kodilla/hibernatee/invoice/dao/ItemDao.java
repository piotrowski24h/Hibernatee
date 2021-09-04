package com.kodilla.hibernatee.invoice.dao;


import com.kodilla.hibernatee.invoice.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, String> {

    List<Item> findByQuantity(int quantity);
}
