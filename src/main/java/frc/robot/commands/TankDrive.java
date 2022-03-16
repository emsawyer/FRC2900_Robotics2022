package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {

    private final DriveTrain m_driveTrainSubsystem;

    private Supplier<Double> Left, Right;

    public TankDrive(DriveTrain subsystem, Supplier<Double> L, Supplier<Double> R) {
        this.Left = L;
        this.Right =R;
        this.m_driveTrainSubsystem = subsystem;


        addRequirements(m_driveTrainSubsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        DriveTrain.differentialDrive.tankDrive(DriveTrain.setLeftMotors(Left.get()), DriveTrain.setRightMotors(Right.get()*-1));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DriveTrain.differentialDrive.tankDrive(0,0);
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
