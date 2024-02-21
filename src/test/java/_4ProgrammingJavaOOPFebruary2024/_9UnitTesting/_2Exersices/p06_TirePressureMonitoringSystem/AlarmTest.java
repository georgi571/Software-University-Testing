package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._2Exersices.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private static final double VALUE_LOWER_THAN_17 = 16;
    private static final double VALUE_HIGHER_THAN_21 = 22;
    private static final double VALUE_BETWEEN_17_AND_21 = 18;

    Sensor sensor;
    Alarm alarm;
    @Before
    public void setup() {
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmWIthLowerValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_LOWER_THAN_17);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWIthHigherValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_HIGHER_THAN_21);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWIthNormalValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_BETWEEN_17_AND_21);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}