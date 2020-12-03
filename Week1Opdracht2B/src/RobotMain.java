import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            /**
             * Opdracht 2 - B
             */
            // Led 1 aanzetten, Led 2 uit en even wachten
            controlLed(0, 0, true);
            controlLed(10, 1000, false);
            // Led 1 uitzetten, Led 2 aanzetten en even wachten
            controlLed(0, 0, false);
            controlLed(10, 1000, true);
        }
    }

    /**
     * Functie om led aan en uit te zetten
     * @param iLed led die aangepast wordt
     * @param iWait tijd die de tijd aan of uit staat
     * @param bStatus true om de led aan te zetten en false om deze uit te zetten
     */
    private static void controlLed(int iLed, int iWait, boolean bStatus) {
        // Led status veranderen en wachten tot timer is afgelopen
        BoeBot.digitalWrite(iLed, bStatus);
        BoeBot.wait(iWait);
    }
}
