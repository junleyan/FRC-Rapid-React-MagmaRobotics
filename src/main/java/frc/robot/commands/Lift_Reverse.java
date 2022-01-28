package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Lift_Reverse extends CommandBase{
    public Lift_Reverse() {
        addRequirements(RobotContainer.Lift);
    }

    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      RobotContainer.Lift.liftReverse(); 
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}