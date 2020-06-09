import model.PLC;
import types.Mode;

import java.util.Arrays;

public class AppPLC {
    private static final int AMOUNT_OF_PLCS = 1100;
    private static final int AMOUNT_OF_EMPLOYEES = 1100;
    private static final PLC[] plcs = new PLC[AMOUNT_OF_PLCS];
    static long amountRunMode;

    static {
        for (int i = 0; i < AMOUNT_OF_PLCS; i++) {
            plcs[i] = new PLC();
        }
    }

    public static void main(String[] args) {
        changePLCSModeByEveryEmployee();
        amountRunMode = countPLCRunMode(plcs);
    }

    private static long countPLCRunMode(PLC[] plcs) {
        return Arrays.stream(plcs)
                .parallel()
                .filter(plc -> plc.getMode().equals(Mode.RUN))
                .count();
    }

    private static void changePLCSModeByEveryEmployee() {
        for (int employeeIndex = 1; employeeIndex <= AMOUNT_OF_EMPLOYEES; employeeIndex++) {
            for (int plcIndex = employeeIndex - 1; plcIndex < AMOUNT_OF_PLCS; plcIndex += employeeIndex) {
                if (plcs[plcIndex].getMode() == null || plcs[plcIndex].getMode().equals(Mode.PROGRAM)) {
                    plcs[plcIndex].setMode(Mode.RUN);
                } else {
                    plcs[plcIndex].setMode(Mode.PROGRAM);
                }
            }
        }
    }


}
