    package com.kodilla.hibernatee.manytomany.dao;

import com.kodilla.hibernatee.manytomany.Company;
import com.kodilla.hibernatee.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    class CompanyDaoTestSuite {

        @Autowired
        private CompanyDao companyDao;

        @Test
        void testSaveManyToMany() {
            //Given
            Employee CarlaBruni = new Employee("Carla", "Bruni");
            Employee MarineLePen = new Employee("Marine", "LePen");
            Employee JulieGayet= new Employee("Julie", "Gayet");

            Company franceMusic = new Company("france Music");
            Company franceGovi = new Company("france Govi");
            Company franceFilm = new Company("france Film");

            franceMusic.getEmployees().add(CarlaBruni);
            franceGovi.getEmployees().add(MarineLePen);
            franceGovi.getEmployees().add(JulieGayet);
            franceFilm.getEmployees().add(CarlaBruni);
            franceFilm.getEmployees().add(JulieGayet);

            CarlaBruni.getCompanies().add(franceMusic);
            CarlaBruni.getCompanies().add(franceGovi);
            MarineLePen.getCompanies().add(franceGovi);
            JulieGayet.getCompanies().add(franceGovi);
            JulieGayet.getCompanies().add(franceFilm);

            //When
            companyDao.save(franceMusic);
            int franceMusicId = franceMusic.getId();
            companyDao.save(franceGovi);
            int franceGoviId = franceGovi.getId();
            companyDao.save(franceFilm);
            int franceFilmId = franceFilm.getId();

            //Then
            assertNotEquals(0, franceMusic);
            assertNotEquals(0, franceGovi);
            assertNotEquals(0, franceFilm);

            //CleanUp
            //try {
            //    companyDao.deleteById(softwareMachineId);
            //    companyDao.deleteById(franceGoviId);
            //    companyDao.deleteById(franceFilmId);
            //} catch (Exception e) {
            //    //do nothing
            //}
        }
    }

