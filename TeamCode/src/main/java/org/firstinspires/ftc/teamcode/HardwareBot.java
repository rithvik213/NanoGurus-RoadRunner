package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled
public class HardwareBot {

    Drive drive;
    Camera camera;
    Accessories accessories;
    //MecanumDrive mecanum;

    private final LinearOpMode opMode1;

    public HardwareBot(LinearOpMode mode) {
        this.opMode1 = mode;
        drive = new Drive(mode);
        camera = new Camera(mode);
        accessories = new Accessories(mode);
    }

    public HardwareBot(LinearOpMode mode, boolean MecanumDrive) {
        this.opMode1 = mode;
       // mecanum = new MecanumDrive(mode);
    }

}
