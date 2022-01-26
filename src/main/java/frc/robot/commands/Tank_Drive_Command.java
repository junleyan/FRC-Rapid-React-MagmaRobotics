// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Tank_Drive_Command extends CommandBase {
  
  public double stickL, stickR;
  public Tank_Drive_Command() {
    addRequirements(RobotContainer.TankDrive);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    stickL = RobotContainer.getLeftStickY();
    stickR = RobotContainer.getRightStickY();
    RobotContainer.TankDrive.tankDrive(stickL, stickR);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
