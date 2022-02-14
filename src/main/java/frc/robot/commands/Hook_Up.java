

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Hook_Up extends CommandBase {
  public Hook_Up() {
    addRequirements(RobotContainer.Hook);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Hook.hookUp();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.Hook.hookOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.Hook.top_limit.get();
  }
}