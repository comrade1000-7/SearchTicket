import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    private Repository repository;
    public Manager (Repository repository) {
        this.repository = repository;
    }

    public void addProduct (Ticket ticket) {
        repository.saveProduct(ticket);
    }

    public Ticket[] findAll (String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getArriveAirport().equals(from) && ticket.getDepartureAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        if (result.length > 0) {
            Arrays.sort(result);
            return result;
        }
        return null;
    }

    public Ticket findAll (String from, String to, Comparator<Ticket> comparator) {
        Ticket[] tmp = findAll(from, to);
        Arrays.sort(tmp, comparator);
        return tmp[0];
    }
}
