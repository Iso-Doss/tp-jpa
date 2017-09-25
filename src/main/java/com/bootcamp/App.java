package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Persistence.generateSchema("tpJpa", new Properties());
    }
}
