package ProjectPatterns.prices;

public class SaunasZone extends TicketDecorator {

        public SaunasZone(AquaparkTicket ticket){
            super(ticket);
        }

        public String getter_permissions(){

            return current_ticket.getter_permissions()+"\n\t + Saunas Zone";
        }

        public double getter_price(){

            return current_ticket.getter_price()+9.99;
        }
    }

