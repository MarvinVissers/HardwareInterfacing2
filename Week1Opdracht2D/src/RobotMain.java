import TI.BoeBot;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {
        // Variabele aanmaken voor de timer
        Timer tLed1 = new Timer(1300);
        Timer tLed2 = new Timer(700);

        // Timers aanzetten
        tLed1.mark();
        tLed2.mark();

        // Variabele voor de statussen
        boolean bLedStatus1 = false;
        boolean bLedStatus2 = false;

        while (true) {
            /**
             * Opdracht 2 - D
             */
            // Kijken of de timer voor 1 compleet is
            if (tLed1.timeout()) {
                // Status led omdraaien
                bLedStatus1 = !bLedStatus1;
                controlLed(0, bLedStatus1);
            }
            if (tLed2.timeout()){
                // Status led omdraaien
                bLedStatus2 = !bLedStatus2;
                controlLed(10, bLedStatus2);
            }
            // Boebot even laten wachten
            BoeBot.wait(1);
        }
    }

    /**
     * Functie om led aan en uit te zetten
     * @param iLed led die aangepast wordt
     * @param bStatus true om de led aan te zetten en false om deze uit te zetten
     */
    private static void controlLed(int iLed, boolean bStatus) {
        // Led status veranderen
        BoeBot.digitalWrite(iLed, bStatus);
    }
}
