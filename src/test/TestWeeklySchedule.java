
import UseCase.WeeklySchedule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWeeklySchedule {
    static WeeklySchedule ws;

    @BeforeAll
    public static void setUp(){
        ws = new WeeklySchedule(new HashMap<String, Integer>());
    }

    @Test
    public void testAddSchedule(){
        ws = new WeeklySchedule(new HashMap<String, Integer>());
        String actual1 = ws.addSchedule("200");
        String expected1 = "Add your schedule successfully";
        assertEquals(expected1, actual1);

        String actual2 = ws.addSchedule("200");
        String expected2 = "Cannot add your schedule since your information exists";
        assertEquals(expected2, actual2);
    }

    @Test
    public void testGetSm(){
        ws = new WeeklySchedule(new HashMap<String, Integer>());
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("200", 40);
        ws.addSchedule("200");
        HashMap<String, Integer> actual = ws.getSm();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHour(){
        ws = new WeeklySchedule(new HashMap<String, Integer>());
        ws.addSchedule("200");
        Integer actual = ws.getHour("200");
        HashMap<String, Integer> expected1 = new HashMap<>();
        expected1.put("200", 40);
        Integer expected = expected1.get("200");
        assertEquals(expected, actual);

    }

    @Test
    public void testChangeSchedule(){
        String actual = ws.changeSchedule("200", -10);
        String expected = "Update your schedule successfully";
        assertEquals(expected, actual);

        String actual1 = ws.changeSchedule("100", 20);
        String expected1 = "Failed to update your schedule ";
        assertEquals(expected1, actual1);

        HashMap<String, Integer> expected3 = new HashMap<>();
        expected3.put("200", 30);
        Integer actual3 = ws.getHour("200");
        assertEquals(expected3.get("200"), actual3);
    }

}
