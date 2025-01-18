package DesignPatterns.ObserverPattern.Command;

// Receiver: Light
class Light0 {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// Receiver: Fan
class Fan0 {
    public void start() {
        System.out.println("Fan is STARTED");
    }
    public void stop() {
        System.out.println("Fan is STOPPED");
    }
}

// Invoker: RemoteControl
class RemoteControl0 {
    private Light0 light;
    private Fan0 fan;

    public RemoteControl0(Light0 light, Fan0 fan) {
        this.light = light;
        this.fan = fan;
    }

    public void pressLightOnButton() {
        light.turnOn();
    }

    public void pressLightOffButton() {
        light.turnOff();
    }

    public void pressFanStartButton() {
        fan.start();
    }

    public void pressFanStopButton() {
        fan.stop();
    }
}

// Client
public class WithoutCommandPattern_REMOTE {
    public static void main(String[] args) {
        Light0 light = new Light0();
        Fan0 fan = new Fan0();
        RemoteControl0 remote = new RemoteControl0(light, fan);

        remote.pressLightOnButton();
        remote.pressFanStartButton();
    }
}
