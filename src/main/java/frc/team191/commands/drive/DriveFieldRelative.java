package frc.team191.commands.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.lib.swervelib.SwerveController;
import frc.team191.Constants;
import frc.team191.RobotContainer;
import frc.team191.subsystems.SwerveSubsystem;

public class DriveFieldRelative extends CommandBase{
    private final SwerveSubsystem  swerve;
    private final DoubleSupplier   vX;
    private final DoubleSupplier   vY;
    private final DoubleSupplier   vOmega;
    private final SwerveController controller;
    private final SlewRateLimiter translationLimiter;
    private final SlewRateLimiter strafeLimiter;
    private final SlewRateLimiter rotationLimiter;
    /**
     * Creates a new DriveFieldRelative command.
     * @param isVeloMode If velocity mode should be used.
     */
    public DriveFieldRelative (SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier vOmega) {
        addRequirements(RobotContainer.swerve);
        this.swerve = swerve;
        this.vX = vX;
        this.vY = vY;
        this.vOmega = vOmega;
        controller = swerve.getSwerveController();
        translationLimiter = new SlewRateLimiter(controller.config.maxSpeed);
        strafeLimiter = new SlewRateLimiter(controller.config.maxSpeed);
        rotationLimiter = new SlewRateLimiter(controller.config.maxAngularVelocity);

    }

    @Override
    public void execute () {
        double xVelocity   = translationLimiter.calculate(MathUtil.applyDeadband(
                                                                vX.getAsDouble(), Constants.SwerveConstants.swerveDeadband));
        double yVelocity   = strafeLimiter.calculate(MathUtil.applyDeadband(
                                                                vY.getAsDouble(), Constants.SwerveConstants.swerveDeadband));
        double angVelocity = rotationLimiter.calculate(MathUtil.applyDeadband(
                                                                vOmega.getAsDouble(), Constants.SwerveConstants.swerveDeadband));
          // Drive using raw values.
          swerve.drive(new Translation2d(xVelocity, yVelocity)
                                        .times(controller.config.maxSpeed),
                       angVelocity * controller.config.maxAngularVelocity,
                       true, true);
    }

    @Override
    public boolean isFinished () {
        // Run continuously.
        return false;
    }
}