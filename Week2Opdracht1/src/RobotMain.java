import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class RobotMain {

//    /**
//     * Opdracht 1 - A/B
//     */
//    public static void main(String[] args) {
//
//        int iLed = 10;
//
//        PWM pwm = new PWM(iLed, 4);
//        pwm.start();
//
//        while (true) {
//            BoeBot.wait(100);
//        }
//    }

    /**
     * Opdracht 1 - C
     */
    public static void main(String[] args) {

        // Variabele aanmaken voor de led en de felheid van de led
        int iLed = 10;
        int iFelheid = 4;

        // Variabele of de teller omhoog of omlaag moet
        Boolean bFeller = true;

        // Dimmer aanmaken en starten
        PWM pwm = new PWM(iLed, iFelheid);
        pwm.start();

        while (true) {
            // Led felheid updaten
            bFeller = controlLed(pwm, iFelheid, bFeller);

            // Kijken om er omhoog of omlaag geteld moet worden
            if (bFeller) {
                // Felheid omhoog doen
                iFelheid++;
            } else {
                // Felheid omlaag doen
                iFelheid--;
            }

            // Boeboet even laten wachten
            BoeBot.wait(8);
        }
    }

    /**
     * Functie om de led van felheid te laten veranderen
     * @param pwm de dimmer
     * @param iFelheid de felheid van de lamp
     * @param bFeller of de teller omhoog of omlaag is
     * @return de nieuwe waarde van bFeller
     */
    private static boolean controlLed(PWM pwm, int iFelheid, boolean bFeller) {
        // Felheid updaten
        pwm.update(iFelheid);

        // Kijken of de led op max felheid zit
        if (bFeller && iFelheid == 255) {
            // Teller omlaag laten gaan
           bFeller = false;
        } else if (!bFeller && iFelheid == 4) {
            // Teller omhoog laten gaan
            bFeller = true;
        }

        // Teller terug geven
        return bFeller;
    }
}
