//command to move lift up (out of chassis)

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Hook_Up extends CommandBase {
  public Hook_Up() {
    addRequirements(RobotContainer.Hook);
  }

  @Override
  public void initialize() {
    RobotContainer.Hook.hookOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Hook.hookUp();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}