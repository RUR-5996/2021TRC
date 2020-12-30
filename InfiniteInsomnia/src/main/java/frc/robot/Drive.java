package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class Drive {

    private RobotMap robotMap;
    private Timer timer;

    public Drive() {
        robotMap = RobotMap.getRobotMap();
        timer = new Timer();
        timer.stop();
    }

    public void drive() {
        //joystick input
        //motor output
        if(robotMap.leftJoystickButton.get() || robotMap.rightJoystickButton.get()) 
        {
            robotMap.drive.driveCartesian(robotMap.getLeftY() * 0.5, robotMap.getLeftX() * 0.5, robotMap.getRightX() * 0.5);
        }
        else 
        {
            robotMap.drive.driveCartesian(robotMap.getLeftY(), robotMap.getLeftX(), robotMap.getRightX());
        }
        
    }

    public void autoStart() {
        timer.start();
    }

    //Proč je tady autodrive pouze na první 2 sekundy?
    public void autoDrive() {
        //Jede doleva 0.5 sekundy (a pak rovně, aby se mohl otočit)
        if(timer.get() >= 0 AND < 0.5) {
            robotMap.drive.driveCartesian(0, 0.75, 0);
            timer.read = Constants.Left;
        }
        //Jede rovně 0.5 sekundy
        if(timer.get() >= 0.5)) {
            robotMap.drive.driveCartesian(0.75, 0, 0);
            timer.read = Constants.Straight;
        }
        //Otočka o 45°, aby objel Brick
        if(timer.get() >= 1)) {
            robotMap.drive.driveCartesian(0, 0, 0);
            timer.read = Constants.FirstTurn;
        }
        //Rovně před Flask
        if(timer.get() >= 1.5)) {
            robotMap.drive.driveCartesian(0.75, 0, 0);
            timer.read = Constants.Straight;
        }
        //Otočka o 135° na střelbu
        if(timer.get() >= 2)) {
            robotMap.drive.driveCartesian(0, 0, 0);
            timer.read = Constants.SecondTurn;
        }
     }
}
