package com.kodilla.hibernatee.manytomany.dao;

import com.kodilla.hibernatee.manytomany.Company;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query
    List<Company> getACompanyWithLetters (@Param("threeLetters") String threeLetters);
}