package frc.robot.commands.auto.flywheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;

public class accelerateFlywheel extends CommandBase {
    private double time;
    private long endTime;
    private Flywheel m_flywheel;

    public accelerateFlywheel(Flywheel flywheel, double timeInMillis) {
        m_flywheel = flywheel;
        this.time = timeInMillis;
        addRequirements(flywheel);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = (long) (startTime + this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_flywheel.flywheelOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}