package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // The robot's subsystems
    public final Pull m_pull = new Pull();
    public final Launcher m_launcher = new Launcher();
    public final Intake m_intake = new Intake();
    public final DriveTrain m_driveTrain = new DriveTrain();

    // Joysticks
    private final static XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER);


    public final static Timer m_timer = new Timer();

    
  
    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {

    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Drive Command", new DriveCommand());
    SmartDashboard.putData("Toggle Intake", new ToggleIntake());
    SmartDashboard.putData("Activate Launcher", new ActivateLauncher(m_launcher));
    SmartDashboard.putData("Toggle Pull", new TogglePull());
   // SmartDashboard.putData("Tank Drive", new TankDrive(m_driveTrain,));

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands

    m_driveTrain.setDefaultCommand(new DriveCommand() );
    m_launcher.setDefaultCommand(new ActivateLauncher(m_launcher) );


    // Configure autonomous sendable chooser

    m_chooser.addOption("Autonomous Command", new AutonomousCommand());
    m_chooser.addOption("Drive Command", new DriveCommand());
    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());


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


    //right bumper - launcher
    final JoystickButton launcher = new JoystickButton(xboxController, XboxController.Button.kRightBumper.value);        
    launcher.whileHeld(new ActivateLauncher(m_launcher) ,true);
    SmartDashboard.putData("Right Bumper",new ActivateLauncher(m_launcher) );

    //x - intake
    final JoystickButton intake = new JoystickButton(xboxController, XboxController.Button.kX.value);        
    intake.whenPressed(new ToggleIntake());
    SmartDashboard.putData("Intake",new ToggleIntake() );

    //y - pull
    final JoystickButton pull = new JoystickButton(xboxController, XboxController.Button.kY.value);        
    pull.toggleWhenPressed(new TogglePull() ,true);
    SmartDashboard.putData("Pull",new TogglePull() );

    //doesn't actually do anything i think
    final JoystickButton leftStick = new JoystickButton(xboxController, XboxController.Button.kLeftStick.value);        
    leftStick.whileHeld(new TankDrive(m_driveTrain) ,true);
    SmartDashboard.putData("LeftStick",new DriveCommand() );

    final JoystickButton rightStick = new JoystickButton(xboxController, XboxController.Button.kRightStick.value);        
    rightStick.whileHeld(new TankDrive(m_driveTrain) ,true);
    SmartDashboard.putData("RightStick",new DriveCommand() );
    
  }

public static XboxController getXboxController() {
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

