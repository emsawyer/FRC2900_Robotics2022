package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;


public class ToggleLauncher3 extends CommandBase {

    private final Launcher m_launcher;
    public static boolean launcherToggle;

    public ToggleLauncher3(Launcher launcher) {

        this.m_launcher = launcher;
        addRequirements(m_launcher);
   
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Launcher.setLauncher3();
        launcherToggle = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Launcher.stop();
        launcherToggle = false;
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
