import java.util.Random;

public class Mastermind {
    public int getRandomNumber(){
        Random r = new Random();
        return 1000 + r.nextInt(9000);
    }

    public int correctPosition(int nrToGuess, int userNr){
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if(nrToGuess % 10 == userNr % 10){
                counter++;
            }
            nrToGuess /= 10;
            userNr/= 10;
        }
        return counter;
    }

    public int wrongPosition(int nrToGuess, int userNr){
        int[] nrToGuess1 = new int[4];
        int[] userNr1 = new int[4];
        int counter = 0;
        boolean[] found = new boolean[4];
        for (int i = 3; i >= 0; i--) {
            nrToGuess1[i] = nrToGuess % 10;
            userNr1[i] = userNr & 10;
            nrToGuess /= 10;
            userNr/= 10;
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(!found[i] && nrToGuess1[i] == userNr1[j] && i != j){
                    found[i] = true;
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}
