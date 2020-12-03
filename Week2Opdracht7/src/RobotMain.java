import TI.*;
public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            // Loop om de frequentie op te laten lopen in 1 seconde
            for (int i = 1000; i < 2000; i++) {
                // Frequentie op de Boebot zetten
                BoeBot.freqOut(0 , i, 1);
            }

            // Loop om de frequentie af te laten lopen in 1 seconde
            for (int i = 2000; i > 1000; i--) {
                // Frequentie op de Boebot zetten
                BoeBot.freqOut(0 , i, 1);
            }
        }
    }
}
