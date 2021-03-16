package frc.robot;

public class Constants {
    
     public static final int timeoutMs = 10;
     
     //controllers
     public static final int CONTROLLER = 1;
     public static final double DEADZONE = 0.2;
     public static final int buttonA = 1;
     public static final int buttonB = 2;
     public static final int buttonX = 3;
     public static final int buttonY = 4;
     public static final int leftBumper = 5;
     public static final int rightBumper = 6;
     public static final int stop = 7;
     public static final int start = 8;
     public static final int leftJoystickButton = 9;
     public static final int rightJoystickButton = 10;

     //ultrasonic convert voltage to distance - exact values depending on the sensor are needed here, this is just an example
     public static final double suppliedVoltage = 5.0;
     public static final double scalingFactor = 1024.0;
     public static final double voltsPerCm = suppliedVoltage / scalingFactor;
     public static double ultrasonicDistance = RobotMap.ultrasonic.getVoltage() / voltsPerCm;

     //shooter speed
     public static final double shootSpeed = Robot.shooterSpeed.getDouble(0.8);

     //ultrasonic PID
     public static final double usP = 0.0;
     public static final double usI = 0.0;
     public static final double usD = 0.0;

     //limelight PID
     public static final double llP = 0.0;
     public static final double llI = 0.0;
     public static final double llD = 0.0;
     public static final double llTurnSpeed = 0.8;

     public static double tx, ty, ta, tv;





}
