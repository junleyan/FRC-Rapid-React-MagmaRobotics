//command to shoot out ball with flywheel

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Flywheel_Out extends CommandBase {
  public Flywheel_Out() {
    addRequirements(RobotContainer.Flywheel);
  }

  @Override
  public void initialize() {
    RobotContainer.Flywheel.flywheelOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.Flywheel.flywheelOut();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.Flywheel.flywheelOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}