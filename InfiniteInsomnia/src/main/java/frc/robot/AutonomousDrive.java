package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousDrive {
    
    private RobotMap robotMap;
    private Timer timer;

    public AutonomousDrive() {
        robotMap = RobotMap.getRobotMap();
        timer = new Timer();
        timer.stop();
    }

    public void autoStart() {
        timer.start();
    }

    public void autoDrive() {
        //Jede doleva 0.5 sekundy (a pak rovně, aby se mohl otočit)
        if (timer.get() < 0.5) {
            robotMap.drive.driveCartesian(0, 0.75, 0);
        }
        //Jede rovně 0.5 sekundy
        else if (timer.get() < 1) {
            robotMap.drive.driveCartesian(0.75, 0, 0);
        }
        //Otočka o 45°, aby objel Brick
        else if (timer.get() < 1.5) {
            robotMap.drive.driveCartesian(0, 0, 0.75);
        }
        //Rovně před Flask
        else if (timer.get() < 2) {
            robotMap.drive.driveCartesian(0.75, 0, 0);
        }
        //Otočka o 135° na střelbu
        else if (timer.get() < 2.5) {
            robotMap.drive.driveCartesian(0, 0, 0.75);
        }
     }

}
