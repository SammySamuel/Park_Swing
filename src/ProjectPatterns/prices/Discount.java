package ProjectPatterns.prices;

public class Discount extends TicketDecorator {

    public Discount(AquaparkTicket ticket){
        super(ticket);
        System.out.println("25% discount for kids which are under 18 years old");
    }

    public String getter_permissions(){

        return current_ticket.getter_permissions()+"\n\t + 25% discount";
    }

    public double getter_price(){

        return current_ticket.getter_price()*0.75;
    }
}
