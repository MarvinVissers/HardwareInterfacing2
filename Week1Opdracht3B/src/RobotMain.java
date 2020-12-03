import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        while (true) {
            // Status knop lezen
            boolean bStatus = BoeBot.digitalRead(4);

            // Kijken wat de stauts van de knop is
            if (bStatus) {
                // Led uitlaten
                BoeBot.digitalWrite(1, false);
            } else {
                // Led aanzetten, 1 seconde wachten en daarna uitzetten
                BoeBot.digitalWrite(1, true);
                BoeBot.wait(1000);
                BoeBot.digitalWrite(1, false);
                BoeBot.wait(1000);
            }
        }
    }
}
