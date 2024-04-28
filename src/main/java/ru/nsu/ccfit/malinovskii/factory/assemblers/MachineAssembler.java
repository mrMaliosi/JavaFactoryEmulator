package ru.nsu.ccfit.malinovskii.factory.assemblers;

public class MachineAssembler implements Assembler{
    private final int workersCount;

    public MachineAssembler() {
        this.workersCount = 0;
    }
    public MachineAssembler(int workersCount) {
        this.workersCount = workersCount;
    }

    public void initialize (int workersCount){
        workersCount = workersCount;
    }
}
