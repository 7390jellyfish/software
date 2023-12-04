package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TeleOpJelly extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("fl");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("bl");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("fr");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("br");
        DcMotor liftLeft = hardwareMap.dcMotor.get("ll");
        DcMotor liftRight = hardwareMap.dcMotor.get("rl");
        DcMotor intake = hardwareMap.dcMotor.get("intake");
        DcMotor transit = hardwareMap.dcMotor.get("transit");
        Servo claw = hardwareMap.servo.get("claw");
//        Servo ramp = hardwareMap.servo.get("ramp");
        Servo drone = hardwareMap.servo.get("drone");

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        liftLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        liftRight.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        transit.setDirection(DcMotorSimple.Direction.REVERSE);
//        claw.setDirection(Servo.Direction.FORWARD);
//        ramp.setDirection(Servo.Direction.FORWARD);
//        drone.setDirection(Servo.Direction.FORWARD);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // dt
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = -gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            // lift
            double liftPower = gamepad2.right_trigger - gamepad2.left_trigger;
            if (gamepad2.right_trigger != 0 || gamepad2.left_trigger != 0) {
                liftLeft.setPower(liftPower);
                liftRight.setPower(liftPower);
            } else {
                liftLeft.setPower(0);
                liftRight.setPower(0);
            }

            // intake
            double intakeTransitPower = (gamepad2.left_bumper ? 1 : 0) - (gamepad2.right_bumper ? 1 : 0);
            intake.setPower(intakeTransitPower);
            transit.setPower(intakeTransitPower);

            // claw
            if (gamepad2.a && !gamepad2.b) {
                claw.setDirection(Servo.Direction.REVERSE);
                claw.setPosition(5);
            }
            if (gamepad2.b && !gamepad2.a) {
                claw.setDirection(Servo.Direction.FORWARD);
                claw.setPosition(3);
            }

            // drone
            if (gamepad2.dpad_right && !gamepad2.dpad_left) {
                drone.setDirection(Servo.Direction.REVERSE);
                drone.setPosition(5);
            }
            if (gamepad2.dpad_left && !gamepad2.dpad_right) {
                drone.setDirection(Servo.Direction.FORWARD);
                drone.setPosition(3);
            }

            // ramp
//            ramp.setPosition(-1.1);

            telemetry.addData("front left", frontLeftMotor.getCurrentPosition());
            telemetry.addData("back left", backLeftMotor.getCurrentPosition());
            telemetry.addData("back right", backRightMotor.getCurrentPosition());
            telemetry.addData("front right", frontRightMotor.getCurrentPosition());
            telemetry.addData("lift left", liftLeft.getCurrentPosition());
            telemetry.addData("lift right", liftRight.getCurrentPosition());
            telemetry.addData("intake", intake.getCurrentPosition());
            telemetry.addData("transit", transit.getCurrentPosition());
            telemetry.addData("claw", claw.getPosition());
//            telemetry.addData("ramp", ramp.getPosition());
            telemetry.addData("drone", drone.getPosition());
            telemetry.update();
        }
    }
}