package frc.robot;

public class Shooter {
    
    private RobotMap robotMap;
    
    public Shooter() 
    {
        robotMap = RobotMap.getRobotMap();
    }

    public void wheel() {
        if(robotMap.rightBumper.get()) {
            RobotMap.wheel.set(0.8);
        } else {
            RobotMap.wheel.set(0);
        }
    }


    public void shooter() {
        if(robotMap.rightBumper.get()) {
            RobotMap.shooterMotor.set(0.8);
        } else {
            RobotMap.shooterMotor.set(0);
        }
    }


}
