//pushes cargo dump tray upwards

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Spin_Cargo extends CommandBase {
  public Spin_Cargo() {
    addRequirements(RobotContainer.Cargo);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Cargo.toggleCargoUp();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.Cargo.stopCargo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.Cargo.top_limit.get();
  }
}