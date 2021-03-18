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

    public double deadzoneDistance(double input, double aim) {
        if(Math.abs(input - aim) <= 5.0) {
            return 0;
        } else {
            return input;
        }
    }

    public double deadzoneLimelight(double input, double aim) {
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
        
        /** will deal with the second variation later
        
        int i = 0;
        //drive 90cm
        if ((Constants.ultrasonicFrontDistance) > 90.0 && i == 0)
        {
            ultrasonicFront.setTarget(90);
            robotMap.drive.driveCartesian(0, ultrasonicFront.pidGet(), 0);
        }

        //when finished, increase index to 1
        if (deadzoneDistance(Constants.ultrasonicFrontDistance, 90.0) == 0)
        {
            i = 1;
        }

        //drive until the robot is in front of the flask
        if ((Constants.ultrasonicDistance) > 175.0 && i == 2)
        {
            robotMap.drive.driveCartesian(0.0, 1.0, 0.0);
        }

        //when finished, increase index to 3
        if (deadzoneDistance(Constants.ultrasonicDistance, 175.0) == 0)
        {
            i = 3;
        }

        //turn 90 degrees counter-clockwise so that the robot faces the flask 
        if (RobotMap.gyro.getAngle() > -180 && i == 3)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, -1.0);
        }
        */

    }
}


