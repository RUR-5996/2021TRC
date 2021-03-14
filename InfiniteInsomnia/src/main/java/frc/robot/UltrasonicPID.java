package frc.robot.PID;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants; // You MUST import Constants in order to acces them

public class UltrasonicPID {

    PIDController usturnController;
    double setpoint;

    public void USTurnPID() {
        usturnController = new PIDController(Constants.ustP, Constants.ustI, Constants.ustD);
        usturnController.setTolerance(1); //1 degree tolerance
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint; //the 'this' is specifying the class-based object to differentiate it from the function input
        //the setpoint should be between -27 and 27 (degrees), which is the field of view of the camera
    }

    public static final Ultrasonic.Unit kMillimeters;

    public double pidGet() {
        return MathUtil.clamp(usturnController.calculate(Constants.tx, setpoint), -Constants.usturnSpeed, Constants.usturnSpeed);
    }
}