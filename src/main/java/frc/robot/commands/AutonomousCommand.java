package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;


public class AutonomousCommand extends CommandBase {
 
    public double setpoint;

    private final DriveTrain m_driveTrainSubsystem;

    public AutonomousCommand(DriveTrain subsystem) {

   
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

        DriveTrain.move(Constants.DRIVE_TIME, Constants.AUTONOMOUS_DRIVE_PERCENTAGE);
        
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

    @Override
    public boolean runsWhenDisabled() {

        return false;

    }
}
