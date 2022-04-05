package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class FeedOn extends CommandBase {
    public double time;
    public long endTime;
    public double power;

    public FeedOn(double timeInMillis) {
        this.time = timeInMillis;
        addRequirements(RobotContainer.Feed);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = (long) (startTime + this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        RobotContainer.Feed.feedIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotContainer.Feed.feedOff();
    }

    protected void interrupted() {
        end();
    }
}