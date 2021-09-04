package com.kodilla.hibernatee.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


    @Entity
    @Table(name = "PODUCTS")
    public class Product {

        private int id;
        private String name;
        private List<Item> itemms = new ArrayList<>();

        public Product() {
        }

        public Product(String name) {
            this.name = name;
        }

        @OneToMany(
                targetEntity = Item.class ,
                mappedBy = "product",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY
        )
        public List<Item> getItemms() {
            return itemms;
        }


        public void setItemms(List<Item> items) {
            this.itemms = items;
        }

        @Id
        @GeneratedValue
        @NotNull
        @Column(name = "id", unique = true)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Column(name = "NAME")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }