package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class Drive {

    private RobotMap robotMap;
    Timer buttonTimer;
    String type;

    public Drive() {
        robotMap = RobotMap.getRobotMap();
        buttonTimer = new Timer();
        type = "manual";
    }

    //it's a mess for now, we will take a look at how to make this a little cleaner. Also all button mapping is random to serve as an exapmle.
    public void drive(String dir) {
        if(robotMap.leftOne.get() && buttonTimer.get() >= 0.25) {
            if(type.equals("manual")) { 
                type = "assisted"; 
                Robot.llturnPID.setTarget(0); //whenever we want to start turning the robot automatically, we set the Target to 0 (the robot will be facing directly the target every time the automatic turning is enabled).
            }
            if(type.equals("assisted")) { type = "manual"; }
        }

        if(type.equals("manual")) {manualDrive(dir);}
        if(type.equals("assisted")) {assistedDrive(dir);}

    }

    public void manualDrive(String dir) {
        if(robotMap.leftOne.get() || robotMap.rightOne.get()) {
            if(dir.equals("Ball")) { //might want to change to Gear if the SB thing fails
                robotMap.drive.driveCartesian(Constants.fastSpeed*robotMap.getLeftY(), Constants.fastSpeed*robotMap.getLeftX(), Constants.fastSpeed*robotMap.getRightX());
            } else {
                robotMap.drive.driveCartesian(-Constants.fastSpeed*robotMap.getLeftY(), -Constants.fastSpeed*robotMap.getLeftX(), -Constants.fastSpeed*robotMap.getRightX());
            }
        } else {
            if(dir.equals("Ball")) { //same over here
                robotMap.drive.driveCartesian(Constants.normalSpeed*robotMap.getLeftY(), Constants.normalSpeed*robotMap.getLeftX(), Constants.normalSpeed*robotMap.getRightX());
            } else {
                robotMap.drive.driveCartesian(-Constants.normalSpeed*robotMap.getLeftY(), -Constants.normalSpeed*robotMap.getLeftX(), -Constants.normalSpeed*robotMap.getRightX());
            }
        }
    }

    //this is here for simplicity, I will redo this in the future to make it more clean.
    public void assistedDrive(String dir) {
        if(robotMap.leftOne.get() || robotMap.rightOne.get()) {
            if(dir.equals("Ball")) { //might want to change to Gear if the SB thing fails
                robotMap.drive.driveCartesian(Constants.fastSpeed*robotMap.getLeftY(), Constants.fastSpeed*robotMap.getLeftX(), Robot.llturnPID.pidGet());
            } else {
                robotMap.drive.driveCartesian(-Constants.fastSpeed*robotMap.getLeftY(), -Constants.fastSpeed*robotMap.getLeftX(), Robot.llturnPID.pidGet());
            }
        } else {
            if(dir.equals("Ball")) { //same over here
                robotMap.drive.driveCartesian(Constants.normalSpeed*robotMap.getLeftY(), Constants.normalSpeed*robotMap.getLeftX(), Robot.llturnPID.pidGet());
            } else {
                robotMap.drive.driveCartesian(-Constants.normalSpeed*robotMap.getLeftY(), -Constants.normalSpeed*robotMap.getLeftX(), Robot.llturnPID.pidGet());
            }
        }
    }
}