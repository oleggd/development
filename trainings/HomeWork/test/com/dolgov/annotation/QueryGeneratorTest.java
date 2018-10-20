package com.dolgov.annotation;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueryGeneratorTest {

    @Test
    public void testGetAll() {
        QueryGenerator queryGenerator = new QueryGenerator();
        String expectedSql = "SELECT person_id, person_name, salary FROM Persons;";

        String actualSql = queryGenerator.getAll(Person.class);

        assertEquals(expectedSql, actualSql);
    }
    //@Ignore
    @Test
    public void insert() throws IllegalAccessException {
        QueryGenerator queryGenerator = new QueryGenerator();
        String expectedSql = "INSERT INTO Persons ( person_id, person_name, salary )" +
                " VALUES ( 1, 'Oleg', 1000.0 );";
        Person person = new Person();
        person.id = 1;
        person.name = "Oleg";
        person.salary = 1000;

        String actualSql = queryGenerator.insert(person);

        assertEquals(expectedSql, actualSql);

    }
    @Test
    public void getById() throws NoSuchFieldException, IllegalAccessException {
        QueryGenerator queryGenerator = new QueryGenerator();
        String expectedSql = "SELECT person_id, person_name, salary FROM Persons WHERE person_id = 10;";

        String actualSql = queryGenerator.getById(Person.class,10);

        assertEquals(expectedSql, actualSql);
    }

    @Test
    public void delete() {
        QueryGenerator queryGenerator = new QueryGenerator();
        String expectedSql = "DELETE FROM Persons WHERE person_id = 20;";

        String actualSql = queryGenerator.delete(Person.class, 20);

        assertEquals(expectedSql, actualSql);
    }
}