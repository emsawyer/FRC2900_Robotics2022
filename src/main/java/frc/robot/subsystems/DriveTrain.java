package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class DriveTrain extends SubsystemBase {

    private Spark frontLeft;
    private  Spark backLeft;
    private  static MotorControllerGroup leftMotor;
    private  Spark frontRight;
    private  Spark backRight;
    private  static MotorControllerGroup rightMotor;
    public static DifferentialDrive differentialDrive;
    public static double drive_percent = Constants.DRIVE_MOTOR_PERCENTAGE;

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

        return drive_percent * lstickspeed*-1;
    }

    public static double setRightMotors(double rstickspeed) {

        return drive_percent*rstickspeed*-1;
    }

    public void stop() {

        leftMotor.set(0);
        rightMotor.set(0);
    }

    public static void move(double time, double power) {
        RobotContainer.m_timer.reset();
        RobotContainer.m_timer.start();
        while (RobotContainer.m_timer.get() <= time) {
            DriveTrain.differentialDrive.tankDrive(power, power);
        }
        
        DriveTrain.differentialDrive.tankDrive(0, 0);

    }
    

}

