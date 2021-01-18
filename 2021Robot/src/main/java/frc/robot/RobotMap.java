package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class RobotMap {

    private static RobotMap robotMap;

    private RobotMap() {
        setupDrive(frontLeft);
        setupDrive(frontRight);
        setupDrive(backLeft);
        setupDrive(backRight);
    }

    public static final WPI_VictorSPX frontLeft = new WPI_VictorSPX(Constants.flVictor);
    public static final WPI_VictorSPX frontRight = new WPI_VictorSPX(Constants.frVictor);
    public static final WPI_VictorSPX backLeft = new WPI_VictorSPX(Constants.blVictor);
    public static final WPI_VictorSPX backRight = new WPI_VictorSPX(Constants.brVictor);

    public MecanumDrive drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    private void setupDrive(WPI_VictorSPX driveVictor) {
        driveVictor.configNominalOutputForward(0, Constants.timeoutMs);
        driveVictor.configNominalOutputReverse(0, Constants.timeoutMs);
        driveVictor.configPeakOutputForward(1, Constants.timeoutMs);
        driveVictor.configPeakOutputReverse(-1, Constants.timeoutMs);
        driveVictor.configAllowableClosedloopError(0, 0, Constants.timeoutMs);
        driveVictor.configNeutralDeadband(0.05, Constants.timeoutMs);
        driveVictor.configOpenloopRamp(0.25);
        driveVictor.setNeutralMode(NeutralMode.Brake);
    }

    public static RobotMap getRobotMap() {
        if(robotMap == null) {
            robotMap = new RobotMap();
        }
        return robotMap;
    }

    public static final Joystick controllerL = new Joystick(0);
    public static final Joystick controllerR = new Joystick(1);
    public static final Joystick coController = new Joystick(2);

    public final Button leftOne = new JoystickButton(controllerL, 1);
    public final Button leftTwo = new JoystickButton(controllerL, 2);
    public final Button leftThree = new JoystickButton(controllerL, 3);
    public final Button leftFour = new JoystickButton(controllerL, 4);
    public final Button leftFive = new JoystickButton(controllerL, 5);
    public final Button leftSix = new JoystickButton(controllerL, 6);
    public final Button leftSeven = new JoystickButton(controllerL, 7);
    public final Button leftEight = new JoystickButton(controllerL, 8);
    public final Button leftNine = new JoystickButton(controllerL, 9);
    public final Button leftTen = new JoystickButton(controllerL, 10);
    public final Button leftEleven = new JoystickButton(controllerL, 11);

    public final Button rightOne = new JoystickButton(controllerR, 1);
    public final Button rightTwo = new JoystickButton(controllerR, 2);
    public final Button rightThree = new JoystickButton(controllerR, 3);
    public final Button rightFour = new JoystickButton(controllerR, 4);
    public final Button rightFive = new JoystickButton(controllerR, 5);
    public final Button rightSix = new JoystickButton(controllerR, 6);
    public final Button rightSeven = new JoystickButton(controllerR, 7);
    public final Button rightEight = new JoystickButton(controllerR, 8);
    public final Button rightNine = new JoystickButton(controllerR, 9);
    public final Button rightTen = new JoystickButton(controllerR, 10);
    public final Button rightEleven = new JoystickButton(controllerR, 11);

    public final Button coOne = new JoystickButton(coController, 1);
    public final Button coTwo = new JoystickButton(coController, 2);
    public final Button coThree = new JoystickButton(coController, 3);
    public final Button coFour = new JoystickButton(coController, 4);
    public final Button coFive = new JoystickButton(coController, 5);
    public final Button coSix = new JoystickButton(coController, 6);
    public final Button coSeven = new JoystickButton(coController, 7);
    public final Button coEight = new JoystickButton(coController, 8);
    public final Button coNine = new JoystickButton(coController, 9);
    public final Button coTen = new JoystickButton(coController, 10);
    public final Button coEleven = new JoystickButton(coController, 11);
    public final Button coTwelve = new JoystickButton(coController, 12);

    public double deadzone(double input) {
        if(Math.abs(input) <= 0.2) {
            return 0;
        } else {
            return input;
        }
    }

    public double getLeftY() { return -deadzone(controllerL.getY()); }
    public double getLeftX() { return deadzone(controllerL.getX()); }
    public double getLeftZ() {return deadzone(controllerL.getZ()); }
    public double getRightY() { return -deadzone(controllerR.getY()); }
    public double getRightX() { return deadzone(controllerR.getX()); }
    public double getRightZ() {return deadzone(controllerR.getZ()); }
    public double getCoY() {return deadzone(coController.getY()); }
    public double getCoX() {return deadzone(coController.getX()); }
    public double getCoZ() {return deadzone(coController.getZ()); }

}