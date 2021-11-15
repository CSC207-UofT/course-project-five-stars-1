import Controller.ScheduleSystemController;
import UseCase.WeeklySchedule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScheduleSystemController {
    static ScheduleSystemController schc;

    @BeforeAll
    public static void setUpScheduleSystemController(){
        schc = new ScheduleSystemController(new HashMap<String, Integer>());
    }


    @Test
    public void testGetWeeklySchedule(){
        schc.addSchedule("200");
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("200", 40);
        assertEquals(expected, schc.getWeeklySchedule().getSm());
    }

    @Test
    public void testAddSchedule(){
        schc = new ScheduleSystemController(new HashMap<String, Integer>());
        String actual = schc.addSchedule("100");
        String expected = "Add your schedule successfully";
        assertEquals(expected, actual);
        HashMap<String, Integer> expected2 = new HashMap<>();
        expected2.put("100", 40);
        assertEquals(expected2, schc.getWeeklySchedule().getSm());

        String actual1 = schc.addSchedule("100");
        String expected1 = "Cannot add your schedule since your information exists";
        assertEquals(expected1, actual1);
    }

    @Test
    public void testCheckSchedule(){
        schc = new ScheduleSystemController(new HashMap<String, Integer>());
        schc.addSchedule("100");
        Integer actual = schc.checkSchedule("100");
        assertEquals(40, actual);
    }

    @Test
    public void testChangeSchedule(){
        schc = new ScheduleSystemController(new HashMap<String, Integer>());
        String actual1 = schc.changeSchedule("200", 20);
        String expected1 = "Failed to update your schedule ";
        assertEquals(expected1, actual1);

        schc.addSchedule("100");
        String actual = schc.changeSchedule("100", 20);
        String expected = "Update your schedule successfully";
        assertEquals(expected, actual);
        HashMap<String, Integer> expected2 = new HashMap<>();
        expected2.put("100", 60);
        assertEquals(expected2.get("100"), schc.checkSchedule("100"));


    }
}
