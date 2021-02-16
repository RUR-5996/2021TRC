package frc.robot;

public class Shooter {
    
    private RobotMap robotMap;
    boolean shoot = false;
    
    public Shooter() 
    {
        robotMap = RobotMap.getRobotMap();
    }

    public void shooter() {
        if(robotMap.rightBumper.get() && shoot == false) {
            shoot = true;
        }

        if (robotMap.rightBumper.get() && shoot == true) {
            shoot = false;
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
