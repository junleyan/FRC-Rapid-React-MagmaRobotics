//command to make intake flipper pull into chassis

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Rotate_Intake_In extends CommandBase {
  public Rotate_Intake_In() {
    addRequirements(RobotContainer.RotIntk);
  }

  @Override
  public void initialize() {
    RobotContainer.RotIntk.rotIntkOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.RotIntk.rotIntkIn();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.RotIntk.rotIntkOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}