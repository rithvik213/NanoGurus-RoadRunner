package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@Config
@Autonomous
public class BlueNear extends LinearOpMode {
    HardwareBot robot;
    ElapsedTime timer;
    int pattern  = 0;

    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    //sleep
    public static int sleep = 200;

    public static double straightPower = 0.5;

    //Path1
    public static double MOVE_DISTANCE_STEP1_PATH1 = 7;
    public static double TURN_IMU_STEP2_PATH1 = 6;
    public static double MOVE_DISTANCE_STEP3_PATH1 = 21;
    public static double TURN_IMU_STEP4_PATH1 = 5;
    public static double MOVE_DISTANCE_STEP5_PATH1 = 26;
    public static double CURVE_TURN_ANGLE_STEP6_PATH1 = 88;
    public static double MOVE_DISTANCE_STEP7_PATH1 = 56;
    public static double MOVE_DISTANCE_STEP8_PATH1 = 58;
    public static double TURN_ONESIDE_STEP9_PATH1 = 90;
    public static double MOVE_DISTANCE_STEP10_PATH1 = 5;
    public static double MOVE_DISTANCE_STEP11_PATH1 = 19;
    public static double TURN_IMU_STEP12_PATH1 = 85;
    public static double MOVE_DISTANCE_STEP13_PATH1 = 45;
    public static double MOVE_DISTANCE_STEP14_PATH1 = 6;
    public static double TURN_IMUONESIDE_STEP15_PATH1 = 90;
    public static double MOVE_DISTANCE_STEP16_PATH1 = 10;
    public static double TURN_IMU_STEP17_PATH1 = 85;


    //Path 2
    public static double MOVE_DISTANCE_STEP1_PATH2 = 7;
    public static double TURN_IMU_STEP2_PATH2 = 38;
    public static double MOVE_DISTANCE_STEP3_PATH2 = 24;
    public static double TURN_IMU_STEP4_PATH2 = 38;
    public static double MOVE_DISTANCE_STEP5_PATH2 = 2;
    public static double MOVE_DISTANCE_STEP6_PATH2 = 16;
    public static double CURVE_TURN_ANGLE_STEP7_PATH2 = 88;
    public static double MOVE_DISTANCE_STEP8_PATH2 = 66;
    public static double MOVE_DISTANCE_STEP9_PATH2 = 62;
    public static double TURN_ONESIDE_STEP10_PATH2 = 90;
    public static double MOVE_DISTANCE_STEP11_PATH2 = 2;
    public static double MOVE_DISTANCE_STEP12_PATH2 = 28;
    public static double TURN_IMU_STEP13_PATH2 = 88;
    public static double MOVE_DISTANCE_STEP14_PATH2 = 56;
    public static double MOVE_DISTANCE_STEP15_PATH2 = 6;

    //Path3
    public static double MOVE_DISTANCE_STEP1_PATH3 = 9;
    public static double TURN_IMU_STEP2_PATH3 = 20;
    public static double MOVE_DISTANCE_STEP3_PATH3 = 18;
    public static double TURN_IMU_STEP4_PATH3 = 14;
    public static double MOVE_DISTANCE_STEP5_PATH3 = 2;
    public static double MOVE_DISTANCE_STEP6_PATH3 = 22;
    public static double CURVE_TURN_ANGLE_STEP7_PATH3 = 90;
    public static double MOVE_DISTANCE_STEP8_PATH3 = 56;
    public static double MOVE_DISTANCE_STEP9_PATH3 = 52;
    public static double TURN_ONESIDE_STEP10_PATH3 = 87;
    public static double MOVE_DISTANCE_STEP11_PATH3 = 4;
    public static double MOVE_DISTANCE_STEP12_PATH3 = 15;
    public static double TURN_IMU_STEP13_PATH3 = 86;
    public static double MOVE_DISTANCE_STEP14_PATH3 = 45;
    public static double MOVE_DISTANCE_STEP15_PATH3 = 7;

    public void runOpMode() throws InterruptedException {
        robot = new HardwareBot(this);
        timer = new ElapsedTime();
        robot.camera.setAllianceColor("blue");

        waitForStart();

        timer.reset();
        while (timer.seconds() <= 2 && !isStopRequested()) {
            telemetry.addData("Pattern: ",robot.camera.getPattern());
            pattern = robot.camera.getPattern();
            telemetry.addData("Timer: ", timer.seconds());
            telemetry.update();
        }

        switch (pattern) {
            case 1:
                robot.accessories.readyToGrabOrUnlatch();
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH1,true);
                robot.drive.turnIMU(TURN_IMU_STEP2_PATH1,0.3,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH1,true);
                sleep(sleep);
                robot.drive.turnIMU(TURN_IMU_STEP4_PATH1,0.3,false);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistance(MOVE_DISTANCE_STEP5_PATH1,0.3, false);
                robot.drive.turnIMUOneSide(CURVE_TURN_ANGLE_STEP6_PATH1,0.4,false); // initially false before 85
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP7_PATH1,true);  // initially true
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH1,false);
                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP9_PATH1,0.4,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP10_PATH1,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH1,false);
                robot.drive.turnIMU(TURN_IMU_STEP12_PATH1,0.4,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP13_PATH1,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistance(MOVE_DISTANCE_STEP14_PATH1,0.4,false);


                //robot.drive.turnIMUOneSide(40,0.3,true);
                //robot.drive.moveDistance(43,0.4,true);
                break;

            case 2:
                robot.accessories.readyToGrabOrUnlatch();
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH2,true);
                robot.drive.turnIMU(TURN_IMU_STEP2_PATH2,0.3,true); //prev 37
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH2,true);
                sleep(sleep);
                robot.drive.turnIMU(TURN_IMU_STEP4_PATH2,0.25,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP5_PATH2,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP6_PATH2, false);
                //robot.drive.turnIMU(82,0.3,false);
                //robot.drive.turnIMUThreeWheel(82,0.3,false);
                robot.drive.turnIMUOneSideRevised(CURVE_TURN_ANGLE_STEP7_PATH2,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH2,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP9_PATH2,false);
                robot.drive.turnIMUOneSideRevised(TURN_ONESIDE_STEP10_PATH2,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH2,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP12_PATH2,false);
                robot.drive.turnIMU(TURN_IMU_STEP13_PATH2,0.4,false);
                robot.drive.moveDistance(MOVE_DISTANCE_STEP14_PATH2,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP15_PATH2,false);
//                robot.accessories.readyToGrabOrUnlatch();
//                robot.drive.turnIMUOneSide(37.5,0.3,true); //prev 37
//                robot.drive.moveDistance(23.5,0.4,true);
//                sleep(700);
//                robot.drive.turnIMUOneSide(36,0.3,false);
//                robot.accessories.Grab();
//                sleep(700);
//                robot.drive.turnIMU(17,0.3,true);
//                robot.drive.moveDistance(11,0.4, false);
//                robot.drive.turnIMU(100,0.3,false);
                //NEED TO TEST
                /*robot.drive.turnIMU(17,0.3,true);
                robot.drive.moveDistance(11,0.4, false);
                robot.drive.turnIMU(82,0.4,false); // initially false before 85
                 */
                /*
                robot.drive.moveDistance(68,0.4,true);  // initially true
                robot.accessories.readyToGrabOrUnlatch();
                sleep(700);
                robot.drive.moveDistance(56,0.4,false); //false before
                robot.drive.turnIMUOneSide(91,0.4,true); // true
                robot.drive.moveDistance(7,0.4,true);
                robot.accessories.Grab();
                sleep(700);
                robot.drive.moveDistance(9,0.4,false);
                robot.drive.turnIMU(83,0.4,false); //false before
                robot.drive.moveDistance(47,0.4,true); //true before
                robot.accessories.readyToGrabOrUnlatch();
                sleep(700);
                */
                break;

            case 3:
                robot.accessories.readyToGrabOrUnlatch();
                //robot.drive.turn
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH3,true);
                robot.drive.turnIMU(TURN_IMU_STEP2_PATH3,0.3,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH3,true);
                sleep(sleep);
                robot.drive.turnIMU(TURN_IMU_STEP4_PATH3,0.25,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP5_PATH3,true);
                robot.accessories.Grab();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP6_PATH3, false);
                robot.drive.turnIMUOneSide(CURVE_TURN_ANGLE_STEP7_PATH3,0.3,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH3,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP9_PATH3,false);
                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP10_PATH3,0.4,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH3,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP12_PATH3,false);
                robot.drive.turnIMU(TURN_IMU_STEP13_PATH3,0.4,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP14_PATH3,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP15_PATH3,false);

                //Old Code
                /*
                robot.accessories.readyToGrabOrUnlatch();
                //robot.drive.turn
                robot.drive.turnIMUOneSide(29,0.4,true);
                sleep(200);
                robot.drive.moveDistance(18,0.4,true);
                robot.drive.turnIMUOneSide(29,0.4,false);
                robot.accessories.Grab();
                sleep(700);

                robot.drive.moveDistance(14,0.4, false);
                robot.drive.turnIMU(91,0.3,false);
                robot.drive.moveDistance(66,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(700);

                robot.drive.moveDistance(56,0.4,false);
                robot.drive.turnIMUOneSide(87,0.4,true);
                robot.drive.moveDistance(4,0.4,true);
                robot.accessories.Grab();
                sleep(700);
                robot.drive.moveDistance(19,0.4,false);
                robot.drive.turnIMU(86,0.4,false);
                robot.drive.moveDistance(45,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(700);
                robot.drive.moveDistance(7,0.4,false);
                 */
                break;

            default:
                telemetry.addData("No skystone found: ", pattern);
        }
    }
}

