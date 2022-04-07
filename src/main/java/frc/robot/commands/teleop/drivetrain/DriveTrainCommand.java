// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveTrainCommand extends CommandBase {
    // Reference to the constructed drive train from RobotContainer to be 
    // used to drive our robot
    private final DriveTrain m_driveTrain;
    private final XboxController m_driver_controller;

    /**
     * Creates a new DefaultDriveTrainCommand.
     */
    public DriveTrainCommand(DriveTrain driveTrain, XboxController driverController) {
        m_driveTrain = driveTrain;
        m_driver_controller = driverController;

        addRequirements(m_driveTrain);
    }

    // Called when the command is initially scheduled.
    @Override
        public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveTrain.tankDrive(
            m_driver_controller.getRawAxis(Constants.JoystickAxis.left), 
            m_driver_controller.getRawAxis(Constants.JoystickAxis.right));
    }

    // Called once the command ends or is interrupted.
    @Override
        public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}