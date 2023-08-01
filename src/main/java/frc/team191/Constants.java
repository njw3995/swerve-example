package frc.team191;

import com.pathplanner.lib.PathConstraints;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import java.util.List;
public final class Constants {

    /* Field related constants */
    public static final class FieldConstants {
      // List of possible scoring locations as Pose2d objects
      public static final List<Pose2d> scoringPositions =
          List.of(
              new Pose2d(
                  new Translation2d(0.555, 7.436),
                  Rotation2d.fromRadians(Math.PI)), // Red loading double station
              new Pose2d(new Translation2d(0.555, 6.146), Rotation2d.fromRadians(Math.PI)),
              new Pose2d(
                  new Translation2d(15.03, 5.061),
                  Rotation2d.fromDegrees(0.0)), // Red node scoring locations
              new Pose2d(new Translation2d(15.03, 4.405), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 3.846), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 3.298), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 2.74), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 2.2), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 1.62), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 1.06), Rotation2d.fromDegrees(0.0)),
              new Pose2d(new Translation2d(15.03, 0.52), Rotation2d.fromDegrees(0.0)),
              new Pose2d(
                  new Translation2d(15.64, 7.430),
                  Rotation2d.fromDegrees(0.0)), // Blue loading double substation
              new Pose2d(new Translation2d(15.64, 6.16), Rotation2d.fromDegrees(0.0)),
              new Pose2d(
                  new Translation2d(1.598, 4.996),
                  Rotation2d.fromRadians(-Math.PI)), // Blue node scoring locations
              new Pose2d(new Translation2d(1.598, 4.373), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 3.85), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 3.3), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 2.75), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 2.2), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 1.63), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 1.05), Rotation2d.fromRadians(-Math.PI)),
              new Pose2d(new Translation2d(1.598, 0.5), Rotation2d.fromRadians(-Math.PI)));
    }
  
    /** General robot constants */
    public static final class GeneralConstants {

      // Driver controller port
      public static final int DRIVER_CONTROLLER_ID = 0;

      // Operator controller port
      public static final int OPERATOR_CONTROLLER_ID = 1;

    }
  
    /** Constants revolving around swerve subsystem */
    public static class SwerveConstants {

      // Joystick axis deadband for the swerve drive
      public static final double swerveDeadband = 0.1;
          
      // Hold time on motor brakes when disabled
      public static final double wheelLockTime = 10;

      public static final boolean isFirstOrder = true;

      public static final double dtConstant = 0.1;

      public static final boolean headingCorrection = true;

      public static final boolean chassisVelocityCorrection = true;
    }
  
    /** Constants revolving around the vision subsystem. */
    public static final class VisionConstants {
      // Camera name
      public static final String cameraName = "OV5647";
  
      // Robot to camera transform
      public static final Transform3d robotToCam =
          new Transform3d(
              new Translation3d(0.0, Units.inchesToMeters(1.5), Units.inchesToMeters(39.0)),
              new Rotation3d(0.0, 0.0, 0.0));
    }
  
    /** Constants revolving around auton modes. */
    public static final class AutonConstants {
  
      public static final double maxVelocity = 3.0;
      public static final double maxAcceleration = 2.0;
      public static final PathConstraints constraints =
          new PathConstraints(AutonConstants.maxVelocity, AutonConstants.maxAcceleration);
  
      public static final double xyControllerP = 14;
      public static final double xyControllerD = 0.6851;
      public static final double thetaControllerP = 3.5;
    }
  }
  
