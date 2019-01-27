package ProjectPatterns.prices;

class FunZone extends TicketDecorator {

    public FunZone(AquaparkTicket ticket){
        super(ticket);
    }

    public String getter_permissions(){

        return current_ticket.getter_permissions()+"\n\t + Fun Zone";
    }

    public double getter_price(){

        return current_ticket.getter_price()+24.99;
    }
}
