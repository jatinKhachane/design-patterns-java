package DesignPatterns.ObserverPattern.Command;


// Command Interface
interface Command {
    void execute();
}

// Receiver: Light
class Light {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// Receiver: Fan
class Fan {
    public void start() {
        System.out.println("Fan is STARTED");
    }
    public void stop() {
        System.out.println("Fan is STOPPED");
    }
}

// Concrete Command: Light On
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: Light Off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Concrete Command: Fan Start
class FanStartCommand implements Command {
    private Fan fan;

    public FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }
}

// Concrete Command: Fan Stop
class FanStopCommand implements Command {
    private Fan fan;

    public FanStopCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }
}

// Invoker: RemoteControl
class RemoteControl {
    private Command[] commands = new Command[4];

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void pressButton(int slot) {
        if (commands[slot] != null) {
            commands[slot].execute();
        } else {
            System.out.println("No command assigned to this button");
        }
    }
}

// Client
public class WithCommandPattern_REMOTE {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        // Creating commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanStart = new FanStartCommand(fan);
        Command fanStop = new FanStopCommand(fan);

        // Setting up the remote
        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, fanStart);
        remote.setCommand(3, fanStop);

        // Using the remote
        remote.pressButton(0);
        remote.pressButton(2);
        remote.pressButton(1);
        remote.pressButton(3);
    }
}