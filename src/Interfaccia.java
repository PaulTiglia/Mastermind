import java.util.Scanner;
public class Interfaccia {
    Mastermind m = new Mastermind();

    public void stampaInterfaccia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n******* INDOVINA IL NUMERO *******");
        System.out.println("Il gioco consiste nell'indovinare il numero di 4 cifre entro 15 tentativi");
        int nrToGuess = m.getRandomNumber();
        int userNumber;
        int difficolta;
        System.out.println("\n1) 30 Tentativi   2) 20 Tentativi   3) 10 Tentativi");
        System.out.print("Inserisci il numero di tentativi: ");
        difficolta = sc.nextInt();
        for (int i = 0; i < difficolta; i++) {
            System.out.print("\nNumero da indovinare: ");
            userNumber = sc.nextInt();
            int wrongDigits = m.wrongPosition(nrToGuess, userNumber);
            int correctDigits = m.correctPosition(nrToGuess, userNumber);
            if(correctDigits == 4){
                System.out.println("HAI VINTO!!");
                return;
            }
            else{
                System.out.println("Hai indovinato " + correctDigits + " numeri");
                System.out.println("Ci sono " + wrongDigits + " numeri nella posizione sbagliata");
            }
        }
        System.out.println("\nNon hai indovinato il numero!!");
        System.out.println("Il numero da indovinare era: " + nrToGuess);
    }
}
