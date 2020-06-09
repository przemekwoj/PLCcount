import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppPLCTest {

    @Test
    public void shouldReturnAmountOfRunModePLC() {
        //given
        long expectedRunModePLCs = 33;
        //when
        AppPLC.main(null);
        //then
        assertEquals(expectedRunModePLCs, AppPLC.amountRunMode);
    }
}
