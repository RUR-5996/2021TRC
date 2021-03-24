package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class Limelight {

    RobotMap robotMap;
    NetworkTable table;
    NetworkTableEntry tv, tx, ty, ta;
    int pipeline = 1; //pipeline 0 - vision processing, pipeline 1 - driver pipeline
    Timer timer;

    public Limelight() {
        robotMap = RobotMap.getRobotMap(); 

        timer = new Timer();

        table = NetworkTableInstance.getDefault().getTable("limelight");
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        table.getEntry("camMode").setNumber(0);
        table.getEntry("pipeline").setNumber(pipeline);
    }

    //insert all the sensor data gathering here

    public void limelightPeriodic() {
        Constants.tv = tv.getDouble(0);
        Constants.tx = tx.getDouble(0);
        Constants.ty = ty.getDouble(0);
        Constants.ta = ta.getDouble(0);
        table.getEntry("pipeline").setNumber(pipeline);
    }

    public void setLimelighMode() {
        if(robotMap.buttonA.get() && timer.get() >= 0.25) {
            timer.reset();
            if(pipeline == 1) {pipeline = 0;}
            else {pipeline = 1;}
        }
    }

    //method for changing pipeline in autonomous without pressing button
    public void changeModeAuto()
    {
        if(pipeline == 1) {pipeline = 0;}
        else {pipeline = 1;}
    }

    public int getPipeline() {
        return pipeline;
    }

}
