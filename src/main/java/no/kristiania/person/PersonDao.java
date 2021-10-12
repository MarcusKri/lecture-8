package no.kristiania.person;

import javax.sql.DataSource;

public class PersonDao {

    public PersonDao(DataSource dataSource) {
        
    }

    public void save(Person person) {

    }

    //Long id kan settes til = null
    //long kan ikke
    public Object retrieve(long id) {
        return null;
    }
}
