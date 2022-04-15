package frc.robot.commands.auto.flywheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;

public class stopFlywheel extends CommandBase {
    private Flywheel m_flywheel;

    public stopFlywheel(Flywheel flywheel) {
        m_flywheel = flywheel;
        addRequirements(flywheel);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_flywheel.flywheelOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_flywheel.flywheelOff();
    }

    protected void interrupted() {
        end();
    }
}