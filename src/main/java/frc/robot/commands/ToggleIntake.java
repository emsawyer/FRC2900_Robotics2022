package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends CommandBase {

    public static boolean intakeToggle;

    public ToggleIntake() {

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Intake.toggleIntake();
        intakeToggle = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Intake.stop();
        intakeToggle = false;
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
