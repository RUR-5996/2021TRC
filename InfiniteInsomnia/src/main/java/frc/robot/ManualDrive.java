package frc.robot;

import frc.robot.PID.LimelightPID;

public class ManualDrive {

    private RobotMap robotMap;
    private LimelightPID limelight;
    private Shooter shooter;
    private Limelight limelightMode;

    public ManualDrive() {
        robotMap = RobotMap.getRobotMap();
        limelight = new LimelightPID();
        shooter = new Shooter();
        limelightMode = new Limelight();
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
        if (limelightMode.getPipeline() == 0)
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

            //once the target is found and focused, start the shooting sequence automatically
            if (Autonomous.deadzoneLimelight(Constants.tx, 0) == 0 && Constants.tv == 1)
            {
                shooter.shootAuto(); 
            }
        }
        
    }

}
