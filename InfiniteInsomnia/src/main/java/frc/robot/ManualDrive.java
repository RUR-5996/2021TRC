package frc.robot;

import frc.robot.PID.LimelightPID;

public class ManualDrive {

    private RobotMap robotMap;
    private LimelightPID limelight;
    private Shooter shooter;

    public ManualDrive() {
        robotMap = RobotMap.getRobotMap();
        limelight = new LimelightPID();
        shooter = new Shooter();
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

        //asisted drive using Limelight
        if (Limelight.pipeline == 0)
        {
            if (Constants.tv == 0)               
            {
                robotMap.drive.driveCartesian(0, 0, 0.5);
            }
            else
            {
                limelight.setTarget(0);
                robotMap.drive.driveCartesian(0, 0, limelight.pidGet());
            }

            //need to figure out how to stop
            if (Autonomous.deadzoneLimelight(Constants.tx, 0) == 0 && Constants.tv == 1)
            {
                shooter.shootAuto(); 
            }
        }
        
    }

}
