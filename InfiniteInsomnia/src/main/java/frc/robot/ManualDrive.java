package frc.robot;

public class ManualDrive {

    private RobotMap robotMap;

    public ManualDrive() {
        robotMap = RobotMap.getRobotMap();
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

}
