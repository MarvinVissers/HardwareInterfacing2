import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            /**
             * Opdracht 2 - A
             */
            // Bijde leds aanzetten
            controlLed(0, true);
            controlLed(10, true);
            BoeBot.wait(1000);
            // Bijde leds uitzetten
            controlLed(0, false);
            controlLed(10, false);
            BoeBot.wait(1000);
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
