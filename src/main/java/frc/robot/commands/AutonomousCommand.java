package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Pull;


public class AutonomousCommand extends CommandBase {
 
    public double setpoint;

    private final DriveTrain m_driveTrainSubsystem;

    private static double auto_power;
    private final double auto_time;

    public AutonomousCommand(DriveTrain subsystem) {

   
        this.m_driveTrainSubsystem = subsystem;
        addRequirements(m_driveTrainSubsystem);    

        auto_power = Constants.AUTONOMOUS_DRIVE_PERCENTAGE;
        auto_time = Constants.AUTO_TIME;

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
        DriveTrain.m_timer.reset();
        DriveTrain.m_timer.start();
        SmartDashboard.putNumber("Autonomous Timer", DriveTrain.m_timer.get());    

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        DriveTrain.move(auto_time, auto_power, false);
        
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
