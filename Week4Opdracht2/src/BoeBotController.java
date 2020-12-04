import TI.BoeBot;
import TI.Servo;

public class BoeBotController {

    private Servo sLinks, sRechts;
    private int iDefaultSpeed, iNormalSpeed;

    public BoeBotController(int iNormalSpeed) {
        sLinks = new Servo(12);
        sRechts = new Servo(13);
        iDefaultSpeed = 1500;
        this.iNormalSpeed = iNormalSpeed;
    }

    public void keepSpeed() {
        sLinks.update(1475);
        sRechts.update(1525);
    }

    /**
     * BoeBot op snelheid laten komen
     * @param iSpeed snelheid van de BoeBot
     */
    public void toSpeed(int iSpeed) {
        // Als de snelheid hoger is dan 0
        if (iSpeed > 0) {
            // Loopen door de snelheid en de Boebot langzaam sneller laten gaan
            for (int i = 0; i < iSpeed; i++) {
                // Nieuwe snelheid op de Boebot zetten
                sLinks.update(iDefaultSpeed - i);
                sRechts.update(iDefaultSpeed + i);
                BoeBot.wait(10);
            }
        } else if (iSpeed < 0) {
            // De Boebot achteruit laten rijden
            for (int i = 0; i > iSpeed; i--) {
                // Snelheid op de Boebot
                sLinks.update(iDefaultSpeed - i);
                sRechts.update(iDefaultSpeed + i);
                BoeBot.wait(10);
            }
        } else {
            // Boebot stil laten staan
            sLinks.update(iDefaultSpeed);
            sRechts.update(iDefaultSpeed);
        }
    }

    /**
     * BoeBot laten draaien
     * @param iTurningspeed de snelheid waarmee de BoeBot draait
     */
    public void turn(int iTurningspeed) {
        sLinks.update(iDefaultSpeed);
        sRechts.update(iDefaultSpeed);

        // Als de snelheid hoger is dan 0
        if (iTurningspeed > 0) {
            sLinks.update(iNormalSpeed - 25);
            sRechts.update(iNormalSpeed + 25);
        } else if (iTurningspeed < 0) {
            sLinks.update(iNormalSpeed + 25);
            sRechts.update(iNormalSpeed - 25);
        } else {
            // Boebot stil laten staan
            sLinks.update(iDefaultSpeed);
            sRechts.update(iDefaultSpeed);
        }
    }

    /**
     * BoeBot een bocht laten maken
     * @param iDegrees the graden van de bocht
     * @param iTurningspeed the snelheid waarmee de BoeBot draait
     */
    public void turnDegrees(int iDegrees, int iTurningspeed) {
        sLinks.update(iDefaultSpeed);
        sRechts.update(iDefaultSpeed);

        // kijken of het getal groter is dan 0
        if (iTurningspeed > 0){
            // Tijd om te draaien bereken
            int timePerDegree = 400 / iTurningspeed;

            // Boebot laten draaien
            sLinks.update(1500 + iTurningspeed);
            sRechts.update(1500 + iTurningspeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * iDegrees);
        } else if (iTurningspeed < 0) {
            // Negatieve snelheid omdraaien naar positieve snelheid
            iTurningspeed = Math.abs(iTurningspeed);

            // Tijd om te draaien bereken
            int timePerDegree = 400 / iTurningspeed;

            // Boebot laten draaien
            sLinks.update(1500 - iTurningspeed);
            sRechts.update(1500 - iTurningspeed);
            // Boebot de berekende tijd laten wachten
            BoeBot.wait(timePerDegree * iDegrees);
        }
    }

    /**
     * Stopping the Boebot
     */
    public void emergencyBrake() {
        // De Boebot eerst een beetje afremmen
        sLinks.update(1600);
        sRechts.update(1400);

        // Boebot volledig afremmen
        sLinks.update(iDefaultSpeed);
        sRechts.update(iDefaultSpeed);
    }
}
