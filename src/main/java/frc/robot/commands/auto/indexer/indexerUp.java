package frc.robot.commands.auto.indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class indexerUp extends CommandBase {
    private double time;
    private long endTime;
    private Indexer m_indexer;

    public indexerUp(Indexer indexer, double timeInMillis) {
        m_indexer = indexer;
        this.time = timeInMillis;
        addRequirements(m_indexer);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = (long) (startTime + this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_indexer.indexerOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_indexer.indexerOff();
    }

    protected void interrupted() {
        end();
    }
}