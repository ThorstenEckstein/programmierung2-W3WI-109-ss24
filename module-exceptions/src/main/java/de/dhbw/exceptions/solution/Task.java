package de.dhbw.exceptions.solution;

public class Task implements Executable {

    @Override
    public void execute() throws CheckedException {
        throw new InterruptedException();
    }

}