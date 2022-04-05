//command to stop the lift from moving

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Hook_Off extends CommandBase {
  public Hook_Off() {
    addRequirements(RobotContainer.Hook);
  }

  @Override
  public void initialize() {
    RobotContainer.Hook.hookOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Hook.hookOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}