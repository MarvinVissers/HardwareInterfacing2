import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        // Oneindige loop
        while (true) {
            /**
             * Opdracht 1 - C
             */
            // Led aanzetten en dan 0.1 seconde wachten
            controlLed(100, true);
            // Led uitzetten en dan 2 seconde wachten
            controlLed(100, false);
        }
    }

    /**
     * Functie om led aan en uit te zetten
     * @param iWait tijd die de tijd aan of uit staat
     * @param bStatus true om de led aan te zetten en false om deze uit te zetten
     */
    private static void controlLed(int iWait, boolean bStatus) {
        // Led status veranderen en wachten tot timer is afgelopen
        BoeBot.digitalWrite(10, bStatus);
        BoeBot.wait(iWait);
    }
}
