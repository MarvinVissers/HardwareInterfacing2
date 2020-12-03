import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {

        Servo sLinks = new Servo(12);
        Servo sRechts = new Servo(13);

//        sLinks.update(1399);
//        sRechts.update(1591);

        while (true) {
            sLinks.update(1400);
            sRechts.update(1675);
            BoeBot.wait(1);
        }
    }
}
