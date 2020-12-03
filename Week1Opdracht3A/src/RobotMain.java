import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            /**
             * Opdracht 3 - A
             */
            // Status knop lezen
            boolean bStatus = BoeBot.digitalRead(4);

            // Kijken wat de stauts van de knop is
            if (bStatus) {
                // Led uitlaten
                BoeBot.digitalWrite(1, false);
            } else {
                // Led aanzetten
                BoeBot.digitalWrite(1, true);
            }
        }
    }
}