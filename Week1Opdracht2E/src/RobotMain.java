import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {

        // Variabele aanmaken voor de timer
        Timer tLed1Aan = new Timer(500);
        Timer tLed1uit = new Timer(1300);
        Timer tLed2Aan = new Timer(800);
        Timer tLed2uit = new Timer(1700);

        // Variabele voor de statussen
        boolean bLedStatus1 = false;
        boolean bLedStatus2 = false;

        // Timers aanzetten
        tLed1Aan.mark();
        tLed1uit.mark();
        tLed2Aan.mark();
        tLed2uit.mark();

        while (true) {
            /**
             * Opdracht 2 - E
             */
            // Kijken of de timer voor led 1 compleet is
            if (bLedStatus1 == false && tLed1Aan.timeout()) {
                // Status van de led op aan zetten
                bLedStatus1 = true;
                // Led aanzetten
                controlLed(0, true);
                // Timer voor uitzetten beginnen
                tLed1uit.mark();
            }
            // Kijken of de timer voor led 2 compleet is
            if (bLedStatus2 == false && tLed2Aan.timeout()){
                // Status van de led op aan zetten
                bLedStatus2 = true;
                // Led aanzetten
                controlLed(10, true);
                // Timer voor uitzetten beginnen
                tLed2uit.mark();
            }

            // Als de led aanstaat en de timeout voor uitzetten led 1 is compleet
            if (bLedStatus1 == true && tLed1uit.timeout()) {
                // Status van de Led op uit zetten
                bLedStatus1 = false;
                // Led uitzetten
                controlLed(0, false);
                // Timers opnieuw beginnen
                tLed1Aan.mark();
                tLed1uit.mark();
            }

            // Als de led aanstaat en de timeout voor uitzetten led 2 is compleet
            if (bLedStatus2 == true && tLed2uit.timeout()) {
                // Status van de Led op uit zetten
                bLedStatus2 = false;
                // Led uitzetten
                controlLed(10, false);
                // Timers opnieuw beginnen
                tLed2Aan.mark();
                tLed2uit.mark();
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
