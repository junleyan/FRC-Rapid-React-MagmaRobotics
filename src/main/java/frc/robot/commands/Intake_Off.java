//intake stop

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Intake_Off extends CommandBase{
    public Intake_Off() {
      addRequirements(RobotContainer.Intake);
    }

    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      RobotContainer.Intake.intakeOff();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
