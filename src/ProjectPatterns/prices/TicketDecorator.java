package ProjectPatterns.prices;

abstract class TicketDecorator implements AquaparkTicket {

    protected AquaparkTicket current_ticket;

    public TicketDecorator(AquaparkTicket ticket){

        current_ticket = ticket;
    }

    public String getter_permissions(){

        return current_ticket.getter_permissions();
    }

    public double getter_price(){

        return current_ticket.getter_price();
    }
}
