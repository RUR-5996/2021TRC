package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Victor;


public class RobotMap {

    private static RobotMap robotMap;

    private RobotMap() {
        setupDrive(frontLeft);
        setupDrive(frontRight);
        setupDrive(rearLeft);
        setupDrive(rearRight);
    }

    public static RobotMap getRobotMap() {
        if(robotMap == null) {
            robotMap = new RobotMap();
        }
        
        return robotMap;
    }

    public static DigitalInput button = new DigitalInput(0);

    public static AnalogInput ultrasonic = new AnalogInput(1);

    public static AHRS gyro = new AHRS(SPI.Port.kMXP);

    //drive controllers
    public static WPI_VictorSPX frontLeft = new WPI_VictorSPX(0);
    public static WPI_VictorSPX frontRight = new WPI_VictorSPX(1);
    public static WPI_VictorSPX rearLeft = new WPI_VictorSPX(2);
    public static WPI_VictorSPX rearRight = new WPI_VictorSPX(3);

    public MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

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

    //intake + shooter
    public static Victor intakeMotor = new Victor(4);
    public static Victor wheel = new Victor(5);
    public static WPI_TalonSRX shooterMotor = new WPI_TalonSRX(6);

    public static final XboxController controller = new XboxController(1);

    public final Button buttonA = new JoystickButton(controller, 1);
    public final Button buttonB = new JoystickButton(controller, 2);
    public final Button buttonX = new JoystickButton(controller, 3);
    public final Button buttonY = new JoystickButton(controller, 4);
    public final Button leftBumper = new JoystickButton(controller, 5);
    public final Button rightBumper = new JoystickButton(controller, 6);
    public final Button stop = new JoystickButton(controller, 7);
    public final Button start = new JoystickButton(controller, 8);
    public final Button leftJoystickButton = new JoystickButton(controller, 9);
    public final Button rightJoystickButton = new JoystickButton(controller, 10);

    public double deadzone(double input) {
        if(Math.abs(input) <= 0.2) {
            return 0;
        } else {
            return input;
        }
    }

    public double getLeftY() { return -deadzone(controller.getY(GenericHID.Hand.kLeft)); }
    public double getLeftX() { return deadzone(controller.getX(GenericHID.Hand.kLeft)); }
    public double getRightY() { return -deadzone(controller.getY(GenericHID.Hand.kRight)); }
    public double getRightX() { return deadzone(controller.getX(GenericHID.Hand.kRight)); }

    public double getTrigger() {
        if(controller.getTriggerAxis(GenericHID.Hand.kRight) > 0) {
			return deadzone(controller.getTriggerAxis(GenericHID.Hand.kRight));
		} else if(controller.getTriggerAxis(GenericHID.Hand.kLeft) > 0) {
			return -deadzone(controller.getTriggerAxis(GenericHID.Hand.kLeft));
		} else {
			return 0.0;
        }
    }
}