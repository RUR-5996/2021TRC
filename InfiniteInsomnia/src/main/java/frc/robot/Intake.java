package frc.robot;

public class Intake {
    
    private RobotMap robotMap;
    boolean intake = false;
    
    public Intake() 
    {
        robotMap = RobotMap.getRobotMap();
    }

    public void intake() {

        if (robotMap.leftBumper.get() && intake == false) {
            intake = true;
        }

        if (robotMap.leftBumper.get() && intake == true) {
            intake = false;
        }

        if (intake) {
            RobotMap.intakeMotor.set(0.8);
        }
        else {
            RobotMap.intakeMotor.set(0);
        }  
    }

}
