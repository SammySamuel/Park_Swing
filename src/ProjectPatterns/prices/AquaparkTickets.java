package ProjectPatterns.prices;

import java.util.Scanner;

public class AquaparkTickets {
    public static boolean loop=true;
    public static void main(){
        Scanner in = new Scanner(System.in);

        System.out.println("Nowy bilet");
        AquaparkTicket ticket =new StandardAquaparkTicket();

        System.out.println("***");

        while(loop){
            System.out.println("Opis biletu: "+ ticket.getter_permissions());
            System.out.println("Cena biletu: "+ ticket.getter_price());

            printChoiceMenu();

            int choice = in.nextInt();

            switch (choice){
                case 1:
                    ticket = new FunZone(ticket);
                    break;
                case 2:
                    ticket = new SaunasZone(ticket);
                    break;
                case 3:
                    ticket = new SlidesZone(ticket);
                    break;
                case 4:
                    ticket = new Discount(ticket);
                    break;
                case 5:
                    loop=false;
                    break;


            }




        }


    }




    public static void printChoiceMenu()
    {
        System.out.println();
        System.out.println("[1] Dodaj dostęp do FunZone");
        System.out.println("[2] Dodaj dostęp do SaunasZone");
        System.out.println("[3] Dodaj dostęp do SlidesZone");
        System.out.println("[4] Dodaj zniżkę");
        System.out.println("[5] Zakoncz");
        System.out.println();
    }

}
