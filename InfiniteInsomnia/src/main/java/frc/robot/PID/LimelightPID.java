package frc.robot.PID;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class LimelightPID {
    
    PIDController llturnController;
    double setpoint;

    public LimelightPID() {
        llturnController = new PIDController(Constants.llP, Constants.llI, Constants.llD);
        llturnController.setTolerance(1); //1 degree tolerance
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint;
        //the setpoint should be between -27 and 27 (degrees), which is the field of view of the camera
    }

    public double pidGet() {
        return MathUtil.clamp(llturnController.calculate(Constants.tx, setpoint), -Constants.llTurnSpeed, Constants.llTurnSpeed);
    }

}
