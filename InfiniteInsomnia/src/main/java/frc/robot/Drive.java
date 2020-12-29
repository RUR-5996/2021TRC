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
        if(timer.get() <= 2.00) {
            robotMap.drive.driveCartesian(0.75, 0, 0);
        } else {
            robotMap.drive.driveCartesian(0, 0, 0);
        }
    }

}