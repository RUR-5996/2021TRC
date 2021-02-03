package frc.robot;

public class AutonomousDrive {
    
    private RobotMap robotMap;

    public AutonomousDrive() {
        robotMap = RobotMap.getRobotMap();
    }

    public void autoStart() {
    }

    public void autoDrive() {

        while ((RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm) > 250)
        {
            robotMap.drive.driveCartesian(0, 1.0, 0);
        }

        RobotMap.ultrasonic.resetAccumulator();

        while (RobotMap.gyro.getAngle() > -35)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, -1.0);
        }
        
        RobotMap.gyro.reset();

        while (RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm > 90)
        {
            robotMap.drive.driveCartesian(0.0, 1.0, 0.0);
        }

        while (RobotMap.gyro.getAngle() < 35)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, 1.0);
        }

    }
}


