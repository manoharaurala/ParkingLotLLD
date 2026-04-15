package repositories;

import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private static int previousId = 0;
    private final Map<Integer, Ticket> tickets = new TreeMap<>();

    public Ticket save(Ticket ticket) {
        previousId += 1;
        ticket.setId(previousId);
        tickets.put(previousId, ticket);
        return ticket;
    }
}
