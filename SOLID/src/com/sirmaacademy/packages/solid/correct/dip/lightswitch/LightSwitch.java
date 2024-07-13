package com.sirmaacademy.packages.solid.correct.dip.lightswitch;

public class LightSwitch {
    private Switchable switchableDevice;

    public LightSwitch(Switchable switchableDevice) {
        this.switchableDevice = switchableDevice;
    }

    public void operate(boolean flag)
    {
        //1 for turn on
        //0 for turn off
        if(flag)
        {
            switchableDevice.turnOn();
            return;
        }
        switchableDevice.turnOff();
    }
}
