//turns out intake mechanism

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Rotate_Intake_Out extends CommandBase {
  public Rotate_Intake_Out() {
    addRequirements(RobotContainer.RotIntk);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.RotIntk.rotIntkOut();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.RotIntk.rotIntkOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.RotIntk.top_limit.get();
  }
}