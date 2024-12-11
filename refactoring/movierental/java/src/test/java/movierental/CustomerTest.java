package movierental;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tony on 1/15/2016.
 */
public class CustomerTest {

    @Test
    public void sampleTest() throws Exception {
        Assert.assertTrue("First dummy test", true);
    }

    @Test
    public void testStatement() {
        Customer customer = new Customer("John Doe");
        Movie movie1 = new Movie("Movie 1", Movie.REGULAR);
        Movie movie2 = new Movie("Movie 2", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("Movie 3", Movie.CHILDRENS);

        Rental rental1 = new Rental(movie1, 3); // applies rates for REGULAR movies
        Rental rental2 = new Rental(movie2, 5); // applies rates for NEW_RELEASE movies
        Rental rental3 = new Rental(movie3, 7); // applies rates for CHILDRENS movies

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String customerStatement = customer.statement();

        String expectedStatement = "Rental Record for John Doe\n" +
                "\tMovie 1\t3.5\n" +
                "\tMovie 2\t15.0\n" +
                "\tMovie 3\t7.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points";

        assertEquals(expectedStatement, customerStatement);
    }
}