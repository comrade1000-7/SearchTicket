import java.util.Comparator;

public class TicketByTimeWay implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTimeWay() - o2.getTimeWay();
    }
}
