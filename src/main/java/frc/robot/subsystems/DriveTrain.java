package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends SubsystemBase {

    private Spark frontLeft;
    private  Spark backLeft;
    private  static MotorControllerGroup leftMotor;
    private  Spark frontRight;
    private  Spark backRight;
    private  static MotorControllerGroup rightMotor;
    public static DifferentialDrive differentialDrive;
    public static double drive_percent = Constants.DRIVE_MOTOR_PERCENTAGE;

    public static Timer m_timer = new Timer();

    public DriveTrain() {

        frontLeft = new Spark(Constants.FRONT_LEFT_MOTOR_PORT);
        addChild("Front Left", frontLeft);
        frontLeft.setInverted(false);

        backLeft = new Spark(Constants.BACK_LEFT_MOTOR_PORT); // 1
        addChild("Back Left", backLeft);
        backLeft.setInverted(false);

        leftMotor = new MotorControllerGroup(frontLeft, backLeft);
        addChild("Left Motor", leftMotor);

        frontRight = new Spark(Constants.FRONT_RIGHT_MOTOR_PORT); // 2
        addChild("Front Right", frontRight);
        frontRight.setInverted(false);

        backRight = new Spark(Constants.BACK_RIGHT_MOTOR_PORT); // 3
        addChild("Back Right", backRight);
        backRight.setInverted(false);

        rightMotor = new MotorControllerGroup(frontRight, backRight);
        addChild("Right Motor", rightMotor);

        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("Differential Drive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        SmartDashboard.putNumber("Left Motor Speed", leftMotor.get());
        SmartDashboard.putNumber("Right Motor Speed", rightMotor.get());        

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static double setLeftMotors(double lstickspeed) {

        return drive_percent * lstickspeed* -1;
    }

    public static double setRightMotors(double rstickspeed) {

        return drive_percent * rstickspeed* -1;
    }

    public void stop() {

        leftMotor.set(0);
        rightMotor.set(0);
    }

    public static void move(double time, double power, boolean finishedMove) {
        System.out.println(m_timer.get());

        if (time > m_timer.get()) {
         
            System.out.println("motor on");
            System.out.println(power);


            leftMotor.set(-Constants.AUTONOMOUS_DRIVE_PERCENTAGE);
            rightMotor.set(Constants.AUTONOMOUS_DRIVE_PERCENTAGE);
            

        }
        else {
            DriveTrain.differentialDrive.stopMotor();
            System.out.println("done");
            finishedMove = true;
        }

        if (finishedMove == true) {
            System.out.println("start shoot");
            autoShoot();
            

        }
    }

    public static void autoShoot() {
        if (m_timer.get() < Constants.SHOOT_TIME) {
            System.out.println(m_timer.get());
            Intake.toggleIntake();
            Pull.setPull();
            Launcher.setLauncher();
        }
       
        else {
            Intake.stop();
            Pull.stop();
            Launcher.stop();
        }

    }
    

}

