import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            // Status knop lezen
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

                // Led 1 aanzetten, 1.3 seconde wachten en daarna uitzetten
                BoeBot.digitalWrite(0, true);
                BoeBot.wait(1300);
                BoeBot.digitalWrite(0, false);
                BoeBot.wait(700);
            }
        }
    }
}
