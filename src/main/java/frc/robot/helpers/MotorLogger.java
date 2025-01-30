package frc.robot.helpers;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/** logs motor data to a logger */
public class MotorLogger {
  // DoubleLogEntry voltage;
  // DoubleLogEntry current;
  // DoubleLogEntry velocity;

  NetworkTable loggingTable;

  NetworkTableEntry voltageEntry;
  NetworkTableEntry currentEntry;
  NetworkTableEntry velocityEntry;
  NetworkTableEntry temperatureEntry;

  public MotorLogger(String path) {
    // voltage = new DoubleLogEntry(log, path + "/voltage");
    // current = new DoubleLogEntry(log, path + "/current");
    // velocity = new DoubleLogEntry(log, path + "/velocity");

    loggingTable = NetworkTableInstance.getDefault().getTable("MotorData");

    voltageEntry = loggingTable.getEntry(path + "/voltage");
    currentEntry = loggingTable.getEntry(path + "/current");
    velocityEntry = loggingTable.getEntry(path + "/velocity");
    temperatureEntry = loggingTable.getEntry(path + "/temperature");
  }

  public void log(TalonFX motor) {
    // current.append(motor.getStatorCurrent().getValueAsDouble());
    // voltage.append(motor.getMotorVoltage().getValueAsDouble());
    // velocity.append(motor.getVelocity().getValueAsDouble());

    currentEntry.setDouble(motor.getStatorCurrent().getValueAsDouble());
    voltageEntry.setDouble(motor.getMotorVoltage().getValueAsDouble());
    velocityEntry.setDouble(motor.getVelocity().getValueAsDouble());
    temperatureEntry.setDouble(motor.getDeviceTemp().getValueAsDouble());
  }
}
