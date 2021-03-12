package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class Diagnostics {

    RobotMap robotMap;
    NetworkTable table;
    NetworkTableEntry tv, tx, ty, ta;
    int pipeline = 1; //pipeline 0 - vision processing, pipeline 1 - driver pipeline
    Timer buttonTimer;

    public Diagnostics() {
        robotMap = RobotMap.getRobotMap(); //I will get all my sensors here

        buttonTimer = new Timer();

        //limelight definition
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
        Constants.tv = tv.getDouble(Constants.llDefault);
        Constants.tx = tx.getDouble(Constants.llDefault);
        Constants.ty = ty.getDouble(Constants.llDefault);
        Constants.ta = ta.getDouble(Constants.llDefault);
        table.getEntry("pipeline").setNumber(pipeline);
    }

    public void setLimelighMode() {
        if(robotMap.coTwelve.get() && buttonTimer.get() >= 0.25) {
            buttonTimer.reset();
            if(pipeline == 1) {pipeline = 0;}
            if(pipeline == 2) {pipeline = 1;}
        }
    }

}