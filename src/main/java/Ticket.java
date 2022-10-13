public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String arriveAirport;
    private String departureAirport;
    private int timeWay;

    public Ticket(int id, int price, String arriveAirport, String departureAirport, int timeWay) {
        this.id = id;
        this.price = price;
        this.arriveAirport = arriveAirport;
        this.departureAirport = departureAirport;
        this.timeWay = timeWay;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.getPrice() - o.getPrice();
    }
}
