package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {

    //controllers
    public static final int CONTROLLER = 1;
    public static final double DEADZONE = 0.2;
    public static final int ButtonA = 1;
    public static final int ButtonB = 2;
    public static final int ButtonX = 3;
    public static final int ButtonY = 4;
    public static final int LeftBumper = 5;
    public static final int RightBumper = 6;
    public static final int Stop = 7;
    public static final int Start = 8;
    public static final int LeftJoystickButton = 9;
    public static final int RightJoystickButton = 10;

}

protected void execute() {
    SmartDashboard.putNumber("Swerve Angle", drivetrain.getSwerveAngle());
    SmartDashboard.putNumber("Left Drive Encoder", drivetrain.getLeftEncoder());
    SmartDashboard.putNumber("Right Drive Encoder", drivetrain.getRightEncoder());
    SmartDashboard.putNumber("RPM", shooter.getRPM());
    SmartDashboard.putNumber("Distance in CM", ultrasonic.getDistanceCM());
    SmartDashboard.putNumber("Gyro angle", rotate.getAngle());
}
