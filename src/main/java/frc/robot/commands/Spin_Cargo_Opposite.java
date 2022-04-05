//command to pull dump down towards chassis

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Spin_Cargo_Opposite extends CommandBase {
  public Spin_Cargo_Opposite() {
    addRequirements(RobotContainer.Cargo);
  }

  @Override
  public void initialize() {
    RobotContainer.Cargo.stopCargo();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Cargo.toggleCargoDown();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.Cargo.stopCargo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; //!RobotContainer.Cargo.bot_limit.get();
  }
}