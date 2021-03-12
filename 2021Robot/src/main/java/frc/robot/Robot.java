package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.PID.LLTurnPID;

public class Robot extends TimedRobot {
  
  public static ShuffleboardTab tab;
  public static Drive drive;
  public static NetworkTableEntry dirSelected;
  public static LLTurnPID llturnPID;

  @Override
  public void robotInit() {
    drive = new Drive();

    tab = Shuffleboard.getTab("driverTab");
    dirSelected = tab.add("Direction Selector", "").withWidget("DirSelector").withSize(2, 1).withPosition(3, 3).getEntry();

    llturnPID = new LLTurnPID();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    drive.drive(dirSelected.getString(""));
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {
    
  }
}
