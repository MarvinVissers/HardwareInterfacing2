import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {

        // Variabele voor de Servo motoren aanmaken
        Servo sLinks = new Servo(12);
        Servo sRechts = new Servo(13);

        while (true) {
            // Maximale snelheid van de Servo motoren
            sLinks.update(1300);
            sRechts.update(1700);
            
            BoeBot.wait(1);
        }
    }
}
