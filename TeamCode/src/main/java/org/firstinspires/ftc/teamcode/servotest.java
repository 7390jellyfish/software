//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.Servo;
//
//@TeleOp
//public class servotest extends LinearOpMode {
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//        Servo claw = hardwareMap.servo.get("claw");
//        DcMotor intake = null;
//        DcMotor transfer = null;
//        Servo claw = null;
//        Servo ramp = null;
//        // Reverse the right side motors. This may be wrong for your setup.
//        // If your robot moves backwards when commanded to go forwards,
//        // reverse the left side instead.
//        // See the note about this earlier on this page.
//        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
////        transfer.setDirection(DcMotorSimple.Direction.FORWARD);
////        intake.setDirection(DcMotorSimple.Direction.REVERSE);
//
//
//        // lift motors
////        leftLift = hardwareMap.get(DcMotor.class, "lift");
//        leftLift = null;
//
////        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//
//        waitForStart();
////        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        System.out.println("Set reset motor");
//
//        if (isStopRequested()) return;
//        double claws = 0;
//
//        while (opModeIsActive()) {
//            double y =  -gamepad2.left_stick_y; // Remember, Y stick value is reversed
//            double x =  gamepad2.left_stick_x * 1.1; // Counteract imperfect strafing
//            double rx = -gamepad2.right_stick_x;
//
//            // Denominator is the largest motor power (absolute value) or 1
//            // This ensures all the powers maintain the same ratio,
//            // but only if at least one is out o
//
//            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
//            double frontLeftPower = (y + x + rx) / denominator;
//            double backLeftPower = (y - x + rx) / denominator;
//            double frontRightPower = (y - x - rx) / denominator;
//            double backRightPower = (y + x - rx) / denominator;
//
//            frontLeftMotor.setPower(frontLeftPower);
//            backLeftMotor.setPower(backLeftPower);
//            frontRightMotor.setPower(frontRightPower);
//            backRightMotor.setPower(backRightPower);
//
////
////            double lifttower = gamepad1.right_trigger - gamepad1.left_trigger;
////            telemetry.addData("Liftpower", lifttower);
//////            telemetry.addData("Liftpos", leftLift.getCurrentPosition());
//////            leftLift.setPower(lifttower);
////            telemetry.addData("claw", claw.getPosition());
////            telemetry.addData("Ramo", ramp.getPosition());
////            telemetry.update();
////
////            if(Math.abs(leftLift.getCurrentPosition()-leftLift.getTargetPosition())<15){
////                leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
////                System.out.println("MET REQS!");
////            }
//
//            if (gamepad1.dpad_left) {
//                lift(700);
//            } else if (gamepad1.dpad_up) {
//                lift(1420);
//            } else if (gamepad1.dpad_right) {
//                lift(350);
//            } else if (gamepad1.dpad_down) {
//                lift(20
//                );
//            }
////            while (gamepad1.left_bumper && leftLift.getCurrentPosition() <= liftMax) {
////                leftLift.setPower(lifttower);
////            }
////            while (gamepad1.right_bumper && leftLift.getCurrentPosition() >= liftMax) {
////                leftLift.setPower(lifttower);
////            }
////            if(gamepad1.right_bumper){
////                transfer.setPower(0.812);
////                intake.setPower(1);
////            } else if (!gamepad1.left_bumper) {
////                transfer.setPower(0);
////                intake.setPower(0);
////            }
////
////            if(gamepad1.left_bumper){
////                transfer.setPower(-1);
////                intake.setPower(-1);
////            }
////            if(gamepad1.x){
////                claw.setPosition(0.45);
////                System.out.println("Triggered.");
////            }
////            if(gamepad1.y){
////                System.out.println("triggered y");
////                claw.setPosition(0.6);
////            }
////            // Closing the claw
////            if (gamepad1.a && clawDone == true && clawClosed == false) {
////                clawDone = false;
////                claw.setPosition(CLAW_HOLD);
////                clawDone = true;
////            }
////            // Opening the claw
////            else if (gamepad1.a && clawDone == true && clawClosed == true) {
////                clawDone = false;
////                claw.setPosition(CLAW_OPEN);
////                clawDone = true;
////            }
//        }
//    }
//}