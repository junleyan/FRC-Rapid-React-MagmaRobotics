package frc.robot.commands.auto.indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class stopIndexer extends CommandBase {
    private Indexer m_indexer;

    public stopIndexer(Indexer indexer) {
        m_indexer = indexer;
        addRequirements(m_indexer);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_indexer.indexerOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_indexer.indexerOff();
    }

    protected void interrupted() {
        end();
    }
}