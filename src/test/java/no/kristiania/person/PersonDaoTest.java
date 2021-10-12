package no.kristiania.person;

import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonDaoTest {

    @Test
    void shouldRetrieveSavedPersonFromDatabase() throws SQLException {
        PersonDao dao = new PersonDao(createDataSource());

        Person person = examplePerson();
        dao.save(person);

        assertThat(dao.retrieve(person.getId()))
                .usingRecursiveComparison()
                .isEqualTo(person);
                //TODO
    }

    private Person examplePerson() {
        Person person = new Person();
        person.setFirstName(pickOne("Johannes", "Julie", "Josephine", "Jamie"));
        person.setLastName(pickOne("Persson", "Kristoffersen", "Jada", "Blabla"));
        return person;
    }

    public static String pickOne(String... alternatives) {
        return alternatives[new Random().nextInt(alternatives.length)];
    }

    private DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/person_db");
        dataSource.setUser("person_dbuser");
        dataSource.setPassword("z=jNE9MY=f5^$WfK5/");
        return dataSource;
    }
}
