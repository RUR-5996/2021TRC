package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class Intake {
    
    private RobotMap robotMap;
    private Timer timer;
    boolean intake = false;
    
    public Intake() 
    {
        robotMap = RobotMap.getRobotMap();
        timer = new Timer();
    }

    public void intake() {

        if ((robotMap.leftBumper.get()) && (intake == false) && (timer.get() >= 0.2)) {
            intake = true;
            timer.reset();
        }

        if ((robotMap.leftBumper.get()) && (intake == true) && (timer.get() >= 0.2)) {
            intake = false;
            timer.reset();
        }

        if (intake) {
            RobotMap.intakeMotor.set(0.8);
        }
        else {
            RobotMap.intakeMotor.set(0);
        }  
    }

}
