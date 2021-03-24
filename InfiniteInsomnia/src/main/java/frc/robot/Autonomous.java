package frc.robot;

import frc.robot.PID.LimelightPID;
import frc.robot.PID.UltrasonicFrontPID;
import frc.robot.PID.UltrasonicSidePID;

public class Autonomous {
    
    private RobotMap robotMap;
    private UltrasonicFrontPID ultrasonicFront;
    private UltrasonicSidePID ultrasonicSide;
    private Limelight limelightMode;
    private LimelightPID limelight;
    private Shooter shooter;

    public Autonomous() {
        robotMap = RobotMap.getRobotMap();
        ultrasonicFront = new UltrasonicFrontPID();
        ultrasonicSide = new UltrasonicSidePID();
        limelightMode = new Limelight();
        limelight = new LimelightPID();
        shooter = new Shooter();
    }

    public void autoStart() {
    }

    public static double deadzoneDistance(double input, double aim) {
        if(Math.abs(input - aim) <= 5.0) {
            return 0;
        } else {
            return input;
        }
    }

    public static double deadzoneLimelight(double input, double aim) {
        if(Math.abs(input - aim) <= 1.0) {
            return 0;
        } else {
            return input;
        }
    }

    public void autoDrive() {

        int i = 0;
        //drive approximately to the middle of the field
        if ((Constants.ultrasonicFrontDistance) != 250.0 && i == 0)
        {
            ultrasonicFront.setTarget(250);
            robotMap.drive.driveCartesian(0, ultrasonicFront.pidGet(), 0);
        }

        //when finished, increase index to 1
        if (deadzoneDistance(Constants.ultrasonicFrontDistance, 250.0) == 0)
        {
            i = 1;
        }

        //drive until the robot is 90 cm from the flask
        if (Constants.ultrasonicFrontDistance != 90.0 && i == 1)
        {
            ultrasonicFront.setTarget(90);
            ultrasonicSide.setTarget(170);
            robotMap.drive.driveCartesian(ultrasonicSide.pidGet(), ultrasonicFront.pidGet(), 0.0);
        }

        //when finished, increase index to 2
        if (deadzoneDistance(Constants.ultrasonicFrontDistance, 90.0) == 0)
        {
            i = 2;
        }

        if (i == 2)
        {
            //change pipeline to vision processing
            limelightMode.changeModeAuto();
            //spin if target was not found
            if (Constants.tv == 0)
            {
                robotMap.drive.driveCartesian(0, 0, 0.5);
            }
            else
            {
                limelight.setTarget(0);
                robotMap.drive.driveCartesian(0, 0, limelight.pidGet());
            }
            //need to figure out how to stop the shooter once finished
            if (deadzoneLimelight(Constants.tx, 0) == 0 && Constants.tv == 1)
            {
                shooter.shootAuto(); 
            }
        }

    }

    public void autoDriveTwo() {
        
        int i = 0;
        //drive 50 cm (approx. 450 cm from the opposite side)
        if ((Constants.ultrasonicFrontDistance) != 450.0 && i == 0)
        {
            ultrasonicFront.setTarget(450);
            robotMap.drive.driveCartesian(0, ultrasonicFront.pidGet(), 0);
        }
        //when finished, increase index to 1
        if (deadzoneDistance(Constants.ultrasonicFrontDistance, 50.0) == 0)
        {
            i = 1;
        }
        //drive until the robot is in front of the flask
        if ((Constants.ultrasonicSideDistance) != 175.0 && i == 1)
        {
            ultrasonicSide.setTarget(175);
            robotMap.drive.driveCartesian(ultrasonicSide.pidGet(), 0.0, 0.0);
        }
        //when finished, increase index to 2
        if (deadzoneDistance(Constants.ultrasonicFrontDistance, 50.0) == 0)
        {
            i = 2;
        }
        if (i == 2)
        {
            //change pipeline to vision processing
            limelightMode.changeModeAuto();
            //spin if target was not found
            if (Constants.tv == 0)               
            {
                robotMap.drive.driveCartesian(0, 0, 0.5);
            }
            else
            {
                limelight.setTarget(0);
                robotMap.drive.driveCartesian(0, 0, limelight.pidGet());
            }
            //need to figure out how to stop the shooter once finished
            if (deadzoneLimelight(Constants.tx, 0) == 0 && Constants.tv == 1)
            {
                shooter.shootAuto(); 
            }
        }
    }
}


