import TI.*;

public class RobotMain {

    // Variabele voor de sensoren
    static int iSensorRechts = 0; 
    static int iSensorMidden = 1;
    static int iSensorLinks = 2;

    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    static int iStandaardSnelheid = 1500;
    static int iRijSnelheid = 50;
    static int iSensorSensitivity = 400;

    public static void main(String[] args) {
        System.out.println("Spoor zoeken...");

        while (true) {
            int iSensor1 = BoeBot.analogRead(iSensorRechts);
            int iSensor2 = BoeBot.analogRead(iSensorMidden);
            int iSensor3 = BoeBot.analogRead(iSensorLinks);
            BoeBot.wait(1);

            // Kijken of de BoeBot te ver naar rechts gaat
            if (((iSensor1 >= iSensorSensitivity) && (iSensor2 <= iSensorSensitivity) && (iSensor3 <= iSensorSensitivity)) || ((iSensor1 >= iSensorSensitivity) && (iSensor2 >= iSensorSensitivity) && (iSensor3 <= iSensorSensitivity))) {
                System.out.println("Ga naar rechts");
                // BoeBot terugzetten naar standaard snelehid
                sLinks.update(iStandaardSnelheid);
                sRechts.update(iStandaardSnelheid);
                // BoeBot naar rechts laten draaien
                sLinks.update(iStandaardSnelheid);
                sRechts.update(iStandaardSnelheid + iRijSnelheid);
            }
            // Kiijken of de BoeBot te ver naar links gaat
            else if (((iSensor1 <= iSensorSensitivity) && (iSensor2 <= iSensorSensitivity) && (iSensor3 >= iSensorSensitivity)) || ((iSensor1 <= iSensorSensitivity) && (iSensor2 >= iSensorSensitivity) && (iSensor3 >= iSensorSensitivity))) {
                System.out.println("Ga naar links");
                // BoeBot terugzetten naar standaard sneleheid
                sLinks.update(iStandaardSnelheid);
                sRechts.update(iStandaardSnelheid);
                // BoeBot naar links laten draaien
                sLinks.update(iStandaardSnelheid - iRijSnelheid);
                sRechts.update(iStandaardSnelheid);
            }
            // Kijken of de BoeBot rechtdoor rijdt
            else if ((iSensor1 <= iSensorSensitivity) && (iSensor2 >= iSensorSensitivity) && (iSensor3 <= iSensorSensitivity)) {
                System.out.println("Gewoon rechtdoor");
                // BoeBot recht door laten rijden
                sLinks.update(iStandaardSnelheid - iRijSnelheid);
                sRechts.update(iStandaardSnelheid + iRijSnelheid);
            } else if ((iSensor1 >= iSensorSensitivity) && (iSensor2 >= iSensorSensitivity) && (iSensor1 >= iSensorSensitivity)) {
                System.out.println("Rechtdoor met een gevonden kruispunt");
                // BoeBot recht door laten rijden
                sLinks.update(iStandaardSnelheid - iRijSnelheid);
                sRechts.update(iStandaardSnelheid + iRijSnelheid);
            }

            // Waarden uitprinten
            System.out.println("Analog waarde links: " + iSensor1);
            System.out.println("Analog waarde midden: " + iSensor2);
            System.out.println("Analog waarde rechts: " + iSensor3);
            System.out.println("---------------------------");
            BoeBot.wait(1);
        }
    }
}
