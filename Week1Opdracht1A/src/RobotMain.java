import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        // Oneindige loop
        while (true) {
            /**
             * Opdracht 1 - A
             */
            // Led aanzetten en dan 1 seconde wachten
            controlLed(1000, true);
            // Led uitzetten en dan 1 seconde wachten
            controlLed(1000, false);
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
