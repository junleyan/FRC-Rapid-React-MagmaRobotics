//intake pull inwards

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Intake_On extends CommandBase{
    public Intake_On() {
      addRequirements(RobotContainer.Intake);
    }

    @Override
    public void initialize() {
      RobotContainer.Intake.intakeOff();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      RobotContainer.Intake.intakeOn();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
