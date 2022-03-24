package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    public static Timer m_timer;
// The robot's subsystems
    private final XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER);
  
    public final Pull m_pull = new Pull();
    public final Launcher m_launcher = new Launcher();
    public final Intake m_intake = new Intake();
    public final DriveTrain m_driveTrain = new DriveTrain();

// Joysticks

    
  
    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {

    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    /*
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand(m_driveTrain));
    SmartDashboard.putData("Toggle Intake", new ToggleIntake());
    
    SmartDashboard.putData("Toggle Pull", new TogglePull());
    SmartDashboard.putData("Tank Drive", new TankDrive(m_driveTrain, ()-> xboxController.getLeftY(), ()-> xboxController.getRightY()));

    SmartDashboard.putData("Activate Launcher", new ActivateLauncher(m_launcher));
    SmartDashboard.putData("Launcher2", new ToggleLauncher2(m_launcher));
    SmartDashboard.putData("Launcher3", new ToggleLauncher3(m_launcher));
    */
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_driveTrain.setDefaultCommand(new TankDrive(m_driveTrain, ()-> xboxController.getLeftY(), ()-> xboxController.getRightY()) );
    //m_launcher.setDefaultCommand(new ActivateLauncher() );


    // Configure autonomous sendable chooser
    
    m_chooser.addOption("Autonomous Command", new AutonomousCommand(m_driveTrain));
    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand(m_driveTrain));


    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

// Create some buttons
    
    final JoystickButton Launcher1 = new JoystickButton(xboxController, XboxController.Button.kX.value);        
    Launcher1.toggleWhenPressed(new ActivateLauncher(m_launcher) ,true);
        SmartDashboard.putData("Launcher1",new ActivateLauncher(m_launcher) );
        SmartDashboard.putBoolean("Launcher1 Status", ActivateLauncher.launcherToggle);

    final JoystickButton Launcher2 = new JoystickButton(xboxController, XboxController.Button.kY.value);        
    Launcher2.toggleWhenPressed(new ToggleLauncher2(m_launcher) ,true);
        SmartDashboard.putData("Launcher2",new ToggleLauncher2(m_launcher) );
        SmartDashboard.putBoolean("Launcher2 Status", ToggleLauncher2.launcherToggle);

    final JoystickButton Launcher3 = new JoystickButton(xboxController, XboxController.Button.kB.value);        
    Launcher3.toggleWhenPressed(new ToggleLauncher3(m_launcher) ,true);
        SmartDashboard.putData("Launcher3",new ToggleLauncher3(m_launcher) ); 
        SmartDashboard.putBoolean("Launcher3 Status", ToggleLauncher3.launcherToggle);        
    

    final JoystickButton intake = new JoystickButton(xboxController, XboxController.Button.kLeftBumper.value);        
    intake.toggleWhenPressed(new ToggleIntake() ,true);
        SmartDashboard.putData("Intake",new ToggleIntake() );
        SmartDashboard.putBoolean("Intake Status", ToggleIntake.intakeToggle);

    final JoystickButton pull = new JoystickButton(xboxController, XboxController.Button.kRightBumper.value);        
    pull.toggleWhenPressed(new TogglePull() ,true);
      SmartDashboard.putData("Pull",new TogglePull() );
      SmartDashboard.putBoolean("Pull Status", TogglePull.pullToggle);

  }

public XboxController getXboxController() {
      return xboxController;
    }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

