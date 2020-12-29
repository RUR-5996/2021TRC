package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;


public class RobotMap {

    private RobotMap() {

    }

    private static RobotMap robotMap;

    public static RobotMap getRobotMap() {
        if(robotMap == null) {
            robotMap = new RobotMap();
        }
        
        return robotMap;
    }

    public static DigitalInput button = new DigitalInput(0);

    public static AnalogInput ultrasonic = new AnalogInput(0);

    public static Talon frontLeft = new Talon(0);
    public static Talon frontRight = new Talon(1);
    public static Talon rearLeft = new Talon(2);
    public static Talon rearRight = new Talon(3);

    public MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    public static final XboxController controller = new XboxController(1);

    public static final Button buttonA = new JoystickButton(controller, 1);
    public static final Button buttonB = new JoystickButton(controller, 2);
    public static final Button buttonX = new JoystickButton(controller, 3);
    public static final Button buttonY = new JoystickButton(controller, 4);
    public static final Button leftBumper = new JoystickButton(controller, 5);
    public static final Button rightBumper = new JoystickButton(controller, 6);
    public static final Button stop = new JoystickButton(controller, 7);
    public static final Button start = new JoystickButton(controller, 8);
    public static final Button leftJoystickButton = new JoystickButton(controller, 9);
    public static final Button rightJoystickButton = new JoystickButton(controller, 10);

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