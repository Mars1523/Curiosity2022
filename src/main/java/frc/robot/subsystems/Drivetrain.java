// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private static WPI_TalonSRX frontLeft = new WPI_TalonSRX(10);
  private static WPI_TalonSRX frontRight = new WPI_TalonSRX(11);
  private static WPI_TalonSRX rearLeft = new WPI_TalonSRX(12);
  private static WPI_TalonSRX rearRight = new WPI_TalonSRX(13);

  private static MecanumDrive drivetrain = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  private XboxController controller;

  /** Creates a new Drivetrain. */
  public Drivetrain(XboxController controller) {
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    this.controller = controller;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double x, double y, double z) {
    drivetrain.driveCartesian(-x, y, z);
  }
}
