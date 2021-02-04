package frc.robot;

public class AutonomousDrive {
    
    private RobotMap robotMap;

    public AutonomousDrive() {
        robotMap = RobotMap.getRobotMap();
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

    public double deadzoneAngle(double input, double aim) {
        if(Math.abs(input - aim) <= 1.0) {
            return 0;
        } else {
            return input;
        }
    }


    public void autoDrive() {

        int i = 0;
        //drive approximately to the middle of the field
        if ((RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm) > 250.0 && i == 0)
        {
            robotMap.drive.driveCartesian(0, 1.0, 0);
        }

        //when finished, increase index to 1
        if (deadzoneDistance(RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm, 250.0) == 0)
        {
            i = 1;
        }

        //turn 35 degrees, counter-clockwise towards the flask
        if (RobotMap.gyro.getAngle() > -35 && i == 1)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, -1.0);
        }

        //when finished, increase index to 2
        if (deadzoneAngle(RobotMap.gyro.getAngle(), -35) == 0)
        {
            i = 2;
        }

        //drive until the robot is 90 cm from the flask
        if (RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm > 90.0 && i == 2)
        {
            robotMap.drive.driveCartesian(0.0, 1.0, 0.0);
        }

        //when finished, increase index to 3
        if (deadzoneDistance(RobotMap.ultrasonic.getVoltage() / Constants.voltsPerCm, 90.0) == 0)
        {
            i = 3;
        }

        //turn 35 degrees clock-wise so that the robot faces the flask 
        if (RobotMap.gyro.getAngle() < 35 && i == 3)
        {
            robotMap.drive.driveCartesian(0.0, 0.0, 1.0);
        }

    }
}


