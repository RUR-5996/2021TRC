package frc.robot.PID;
    
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants; 

public class UltrasonicFrontPID {

    PIDController ultrasonicController;
    double setpoint;

    public void ultrasonicPID() {
        ultrasonicController = new PIDController(Constants.usP, Constants.usI, Constants.usD);
        ultrasonicController.setTolerance(1); 
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint; 
    }

    public double pidGet() {
        return MathUtil.clamp(ultrasonicController.calculate(Constants.ultrasonicFrontDistance, setpoint), 0, 1);
    }
}
