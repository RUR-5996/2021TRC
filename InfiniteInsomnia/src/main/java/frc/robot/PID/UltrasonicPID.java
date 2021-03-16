package frc.robot.PID;
    
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants; 

public class UltrasonicPID {

    PIDController ultrasonicController;
    double setpoint;

    public void ultrasonicPID() {
        ultrasonicController = new PIDController(Constants.usP, Constants.usI, Constants.usD);
        ultrasonicController.setTolerance(1); // 1 degree tolerance
    }

    public void setTarget(double setpoint) {
        this.setpoint = setpoint; 
        //the setpoint should be between -27 and 27 (degrees), which is the field of view of the camera
    }

    public double pidGet() {
        return MathUtil.clamp(ultrasonicController.calculate(Constants.ultrasonicDistance, setpoint), 0, 1);
    }
}
