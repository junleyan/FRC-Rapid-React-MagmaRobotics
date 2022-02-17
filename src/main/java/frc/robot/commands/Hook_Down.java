package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Hook_Down extends CommandBase {
  public Hook_Down() {
    addRequirements(RobotContainer.Hook);
  }

  @Override
  public void initialize() {
    RobotContainer.Hook.hookOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Hook.hookDown();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}