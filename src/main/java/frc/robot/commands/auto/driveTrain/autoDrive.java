package frc.robot.commands.auto.driveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class autoDrive extends CommandBase {
    private double time;
    private long endTime;
    private double leftPower;
    private double rightPower;
    private DriveTrain m_driveTrain;

    public autoDrive(DriveTrain driveTrain, double timeInMillis, double leftPower, double rightPower) {
        m_driveTrain = driveTrain;
        this.time = timeInMillis;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
        addRequirements(driveTrain);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        long startTime = System.currentTimeMillis();
        endTime = (long) (startTime + this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_driveTrain.tankDrive(this.leftPower, this.rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_driveTrain.tankDrive(0.0, 0.0);
    }

    protected void interrupted() {
        end();
    }
}