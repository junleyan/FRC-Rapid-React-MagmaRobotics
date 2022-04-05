//command to spit feed out

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Feed_Out extends CommandBase{
    public Feed_Out() {
      addRequirements(RobotContainer.Feed);
    }

    @Override
    public void initialize() {
      RobotContainer.Feed.feedOff();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      RobotContainer.Feed.feedOut();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
