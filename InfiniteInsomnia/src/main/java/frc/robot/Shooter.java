package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class Shooter {
    
    private RobotMap robotMap;
    private Timer timer;
    boolean shoot = false;
    
    public Shooter() 
    {
        robotMap = RobotMap.getRobotMap();
        timer = new Timer();
    }

    public void shooter() {
        if((robotMap.rightBumper.get()) && (shoot == false) && (timer.get() >= 0.2)) {
            shoot = true;
            timer.reset();
        }

        if ((robotMap.rightBumper.get()) && (shoot == true) && (timer.get() >= 0.2)) {
            shoot = false;
            timer.reset();
        }

        if (shoot) {  
            RobotMap.wheel.set(0.8);
            RobotMap.shooterMotor.set(0.8);
        } else {
            RobotMap.wheel.set(0);
            RobotMap.shooterMotor.set(0);
        }
    }

}
