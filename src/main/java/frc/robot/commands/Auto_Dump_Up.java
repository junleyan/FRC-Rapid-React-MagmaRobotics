//commands for autonomous dump

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Auto_Dump_Up extends CommandBase{
    public double time;
    public long endTime;

    public Auto_Dump_Up(double timeInMillis){
        this.time = timeInMillis;
        addRequirements(RobotContainer.Cargo);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = (long) (startTime + this.time);
        RobotContainer.Cargo.stopCargo();
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        RobotContainer.Cargo.toggleCargoUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotContainer.Cargo.stopCargo();
    }

    protected void interrupted() {
        end();
    }
}