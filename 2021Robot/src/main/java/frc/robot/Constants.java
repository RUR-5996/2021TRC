package frc.robot;

public class Constants {

    //Constants needed for setting up smart controllers
    public static final int timeoutMs = 10;

    //speed coefficients for driving
    public static final double fastSpeed = 0.9;
    public static final double normalSpeed = 0.7;

    //IDs for RobotMap
    public static final int flVictor = 0;
    public static final int frVictor = 1;
    public static final int blVictor = 2;
    public static final int brVictor = 3;

    //Limelight
    public static final double llDefault = 0;

    //Limelight turning with PID
    public static final double lltP = 0.1;
    public static final double lltI = 0.0;
    public static final double lltD = 0.0;
    public static final double llturnSpeed = 0.8;

    public static double tx, ty, ta, tv;

}