// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop.hook;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hook;

public class hookDown extends CommandBase {
    private Hook m_hook;

    public hookDown(Hook hook) {
        m_hook = hook;
        addRequirements(m_hook);
    }

    // Called when the command is initially scheduled.
    @Override
        public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_hook.hookDown();
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