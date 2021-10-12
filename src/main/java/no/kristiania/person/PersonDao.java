package no.kristiania.person;

import javax.sql.DataSource;

public class PersonDao {

    private Person person;

    public PersonDao(DataSource dataSource) {
        
    }

    public void save(Person person) {
        this.person = person;
    }

    //Long id kan settes til = null
    //long kan ikke
    public Object retrieve(Long id) {
        return person;
    }
}
