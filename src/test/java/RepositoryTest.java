import org.junit.jupiter.api.*;

public class RepositoryTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 3299, "LED", "SVO", 45);
    Ticket ticket4 = new Ticket(4, 999, "SVO", "KZN", 165);
    Ticket ticket5 = new Ticket(5, 13299, "LED", "DXB", 345);

    @BeforeEach
    public void setup() {
        repo.saveProduct(ticket1);
        repo.saveProduct(ticket2);
        repo.saveProduct(ticket3);
        repo.saveProduct(ticket4);
        repo.saveProduct(ticket5);
    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        repo.removeTicket(2);
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchById () {
        Ticket expected = ticket3;
        Ticket actual = repo.searchById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullSearchById () {
        Ticket actual = repo.searchById(10);

        Assertions.assertEquals(null, actual);
    }
}
