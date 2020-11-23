import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            /**
             * Opdracht 3 - A
             */
//            // Status lezen
//            boolean bStatus = BoeBot.digitalRead(4);
//            // Kijken wat de stauts van de knop is
//            if (state) {
//                BoeBot.digitalWrite(1, false);
//            } else {
//                BoeBot.digitalWrite(1, true);
//            }

            /**
             * Opdracht 3 - B
             */
//            // Status lezen
//            boolean bStatus = BoeBot.digitalRead(4);
//
//            // Kijken wat de stauts van de knop is
//            if (bStatus) {
//                // Led uitlaten
//                BoeBot.digitalWrite(1, false);
//            } else {
//                // Led aanzetten
//                BoeBot.digitalWrite(1, true);
//                BoeBot.wait(1000);
//                BoeBot.digitalWrite(1, false);
//                BoeBot.wait(1000);
//            }

            /**
             * Opdracht 3 - C
             */
            // Status lezen
            boolean bStatus = BoeBot.digitalRead(4);
            // Kijken wat de stauts van de knop is
            if (bStatus) {
                // Led 2 aanzetten
                BoeBot.digitalWrite(1, true);
                // Led 1 uitzetten
                BoeBot.digitalWrite(0, false);
            } else {
                // Led 2 uitzetten
                BoeBot.digitalWrite(1, false);

                // Led 1 aanzetten
                BoeBot.digitalWrite(0, true);
                BoeBot.wait(1300);
                BoeBot.digitalWrite(0, false);
                BoeBot.wait(700);
            }
        }
    }
}