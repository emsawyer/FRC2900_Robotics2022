package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Pull;

public class ComplexAuto extends CommandBase {
    
    private final DriveTrain m_driveTrainSubsystem;

    public ComplexAuto(DriveTrain subsystem) {
        
        this.m_driveTrainSubsystem = subsystem;

    }

    @Override
    public void initialize() {
        
        DriveTrain.m_timer.reset();
        DriveTrain.m_timer.start();    

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveTrainSubsystem.stop();
        Intake.stop();
        Pull.stop();
        Launcher.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {

        return false;

    }
}



