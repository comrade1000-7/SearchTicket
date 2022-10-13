public class Repository {
    protected Ticket[] repo = new Ticket[0];

    public void saveProduct (Ticket product) {
        Ticket[] tmp = new Ticket[repo.length + 1];
        System.arraycopy(repo, 0, tmp, 0, repo.length);
        tmp[tmp.length - 1] = product;
        repo = tmp;
    }

    public Ticket searchById (int id) {
        for (Ticket ticket : repo) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] getAll () {
        return repo;
    }

    public void removeTicket (int id) {
        int index = 0;
        Ticket[] tmp = new Ticket[repo.length - 1];
        for (Ticket ticket : repo) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }

        }
        repo = tmp;
    }
}
