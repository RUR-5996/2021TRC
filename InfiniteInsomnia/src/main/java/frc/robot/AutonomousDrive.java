package frc.robot;

public class AutonomousDrive {
    
    private RobotMap robotMap;

    public AutonomousDrive() {
        robotMap = RobotMap.getRobotMap();
    }

    public void autoStart() {
    }

    public void autoDrive() {

        //drive approximately to the middle of the field
        while ((RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm) > 250)
        {
            robotMap.drive.driveCartesian(0, 1.0, 0);
        }

        RobotMap.ultrasonic.resetAccumulator();

        //turn 35 degrees, counter-clockwise towards the flask
        while (RobotMap.gyro.getAngle() > -35)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, -1.0);
        }
        
        RobotMap.gyro.reset();

        //drive until the robot is 90 cm from the flask
        while (RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm > 90)
        {
            robotMap.drive.driveCartesian(0.0, 1.0, 0.0);
        }

        //turn 35 degrees clock-wise so that the robot faces the flask 
        while (RobotMap.gyro.getAngle() < 35)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, 1.0);
        }

    }
}


