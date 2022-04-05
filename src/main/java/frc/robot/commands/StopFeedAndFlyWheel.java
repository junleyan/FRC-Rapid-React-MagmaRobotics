package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class StopFeedAndFlyWheel extends CommandBase {

    public StopFeedAndFlyWheel() {
        addRequirements(RobotContainer.Flywheel);
        addRequirements(RobotContainer.Feed);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        RobotContainer.Flywheel.flywheelOff();
        RobotContainer.Feed.feedOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotContainer.Flywheel.flywheelOff();
        RobotContainer.Feed.feedOff();
    }

    protected void interrupted() {
        end();
    }
}