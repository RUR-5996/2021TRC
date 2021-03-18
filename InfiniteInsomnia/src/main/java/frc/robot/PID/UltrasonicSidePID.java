package frc.robot.PID;
    
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants; 

public class UltrasonicSidePID {

    PIDController ultrasonicController;
    double setpoint;

    public UltrasonicSidePID() {
        ultrasonicController = new PIDController(Constants.usP, Constants.usI, Constants.usD);
        ultrasonicController.setTolerance(1); 
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint; 
    }

    public double pidGet() {
        return MathUtil.clamp(ultrasonicController.calculate(Constants.ultrasonicSideDistance, setpoint), -1, 1);
    }
}