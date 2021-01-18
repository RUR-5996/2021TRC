package frc.robot;

public class Drive {

    private RobotMap robotMap;

    public Drive() {
        robotMap = RobotMap.getRobotMap();
    }

    public void drive(String dir) {
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


}