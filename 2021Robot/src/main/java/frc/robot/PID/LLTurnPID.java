package frc.robot.PID;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants; // You MUST import Constants in order to acces them

public class LLTurnPID {

    PIDController llturnController;
    double setpoint;

    public LLTurnPID() {
        llturnController = new PIDController(Constants.lltP, Constants.lltI, Constants.lltD);
        llturnController.setTolerance(1); //1 degree tolerance
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint; //the this is specifying the class-based object to differentiate it from the function input
        //the setpoint should be between -27 and 27 (degrees), which is the field of view of the camera
    }

    public double pidGet() {
        return MathUtil.clamp(llturnController.calculate(Constants.tx, setpoint), -Constants.llturnSpeed, Constants.llturnSpeed);
    }
}