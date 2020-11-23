import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {
        while (true) {
            // Variabele voor de status aanmaken
            boolean bStatusKnop1 = BoeBot.digitalRead(5);
            boolean bStatusKnop2 = BoeBot.digitalRead(10);

            // Als knop 1 is ingedrukt
            if (!bStatusKnop1) {
                // Led 1s aanzetten, dan 1 seconde uit
                controlLed(1, 0, false);
                controlLed(0, 1000, true);
                controlLed(0, 1000, false);
            } else if (!bStatusKnop2) {
                // Led 0.7s aanzetten, dan 0.7s seconde uit
                controlLed(0, 0, false);
                controlLed(1, 700, true);
                controlLed(1, 700, false);
            } else if(bStatusKnop1 && bStatusKnop2) {
                // Led 1 1.3s aanzetten en led 2 1.3s uitzetten
                controlLed(0, 0, true);
                controlLed(1, 1300, false);
                // Led 1 0.7s uitzetten en led 2 0.7s aanzetten
                controlLed(0, 0, false);
                controlLed(1, 700, true);
            }
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
