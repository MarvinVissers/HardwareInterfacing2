import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class RobotMain {
    /**
     * Opdracht 2
     */
    public static void main(String[] args) {

        // Variabele aanmaken voor de led en de felheid van de led
        int iLed1 = 10;
        int iLed2 = 15;
        int iFelheid1 = 4;
        int iFelheid2 = 200;

        // Variabele of de teller omhoog of omlaag moet
        Boolean bFeller1 = true;
        Boolean bFeller2 = false;

        // Dimmers aanmaken en starten
        PWM pwmLed1 = new PWM(iLed1, iFelheid1);
        PWM pwmLed2 = new PWM(iLed2, iFelheid2);
        pwmLed1.start();
        pwmLed2.start();

        while (true) {
            // Led felheid updaten
            bFeller1 = controlLed(pwmLed1, iFelheid1, bFeller1);
            bFeller2 = controlLed(pwmLed2, iFelheid2, bFeller2);

            // Kijken om er omhoog of omlaag geteld moet worden
            if (bFeller1) {
                // Felheid led 1 omhoog doen
                iFelheid1++;
                // Felheid led 2 omlaag doen
                iFelheid2--;
            } else {
                // Felheid led 1 omlaag doen
                iFelheid1--;
                // Felheid led 2 omhoog doen
                iFelheid2++;
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
        if (bFeller && iFelheid == 200) {
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
