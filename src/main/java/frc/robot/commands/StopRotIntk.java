package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class StopRotIntk extends CommandBase {

    public StopRotIntk() {
        addRequirements(RobotContainer.RotIntk);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        RobotContainer.RotIntk.rotIntkOff();
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        RobotContainer.RotIntk.rotIntkOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotContainer.RotIntk.rotIntkOff();
    }

    protected void interrupted() {
        RobotContainer.RotIntk.rotIntkOff();
        end();
    }
}