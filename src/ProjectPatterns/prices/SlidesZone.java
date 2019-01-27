package ProjectPatterns.prices;

class SlidesZone extends TicketDecorator {

    public SlidesZone(AquaparkTicket ticket){
        super(ticket);
    }

    public String getter_permissions(){

    return current_ticket.getter_permissions()+"\n\t + Slides Zone";
    }

    public double getter_price(){

    return current_ticket.getter_price()+14.99;
    }
}
