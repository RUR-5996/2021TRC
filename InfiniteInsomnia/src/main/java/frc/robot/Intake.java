package frc.robot;

public class Intake {
    
    private RobotMap robotMap;
    
    public Intake() 
    {
        robotMap = RobotMap.getRobotMap();
    }

    public void intake() {
        if(robotMap.leftBumper.get()) {
            RobotMap.intakeMotor.set(0.8);
        }
        else {
            RobotMap.intakeMotor.set(0);
        }  
    }

}
