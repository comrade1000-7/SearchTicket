import org.junit.jupiter.api.*;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 3299, "LED", "SVO", 45);
    Ticket ticket4 = new Ticket(4, 999, "SVO", "KZN", 165);
    Ticket ticket5 = new Ticket(5, 13299, "LED", "DXB", 345);
    Ticket ticket6 = new Ticket(6, 35299, "LED", "LHR", 245);

    @BeforeEach
    public void setup() {
        repo.saveProduct(ticket1);
        repo.saveProduct(ticket2);
        repo.saveProduct(ticket3);
        repo.saveProduct(ticket4);
        repo.saveProduct(ticket5);
    }

    @Test
    public void shouldSearchAll() {
        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullSearchAll() {
        Ticket[] actual = manager.findAll("SVO", "DXB");

        Assertions.assertArrayEquals(null, actual);
    }

    @Test
    public void shouldAddProduct() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        manager.addProduct(ticket6);
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
