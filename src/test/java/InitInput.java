import org.junit.BeforeClass;
import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.utils.MappingUtil;

import java.util.ArrayList;
import java.util.List;

import static org.oracle.codingchallange.constants.Constants.NEW_LINE;

public class InitInput {

    private static List<InputData> inputDataList = new ArrayList<>();

    private static StringBuffer testInput = new StringBuffer();

    private static StringBuffer emptyInput = new StringBuffer();

    private static StringBuffer faultyInput1 = new StringBuffer();

    private static StringBuffer faultyInput2 = new StringBuffer();

    private static StringBuffer faultyInput3 = new StringBuffer();

    private static StringBuffer faultyInput4 = new StringBuffer();

    private static StringBuffer faultyInput5 = new StringBuffer();


    @BeforeClass
    public static void init() {
        testInput.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append("1223456,2345,us_west,BlueTeam,ProjectBanana,2211s")
                .append(NEW_LINE)
                .append("3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s")
                .append(NEW_LINE)
                .append("1233456,2345,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        inputDataList = MappingUtil.mapRawInputToData(testInput);

        faultyInput1.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append("1223456,2345,ProjectBanana,2211s")
                .append(NEW_LINE)
                .append("3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s")
                .append(NEW_LINE)
                .append("1233456,2345,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        faultyInput2.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append("3244332,2346,,,ProjectCarrot,4322s")
                .append(NEW_LINE)
                .append("1233456,2345,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        faultyInput3.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append(",2345,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        faultyInput4.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append("12a3(32,32432,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        faultyInput5.append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                .append(NEW_LINE)
                .append("23421,anbc6534,us_west,BlueTeam,ProjectDate,2221s")
                .append(NEW_LINE)
                .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

    }

    public List<InputData> getInputDataList() {
        return inputDataList;
    }

    public static StringBuffer getTestInput() {
        return testInput;
    }

    public static StringBuffer getEmptyInput() {
        return emptyInput;
    }

    public static StringBuffer getFaultyInput1() {
        return faultyInput1;
    }

    public static StringBuffer getFaultyInput2() {
        return faultyInput2;
    }

    public static StringBuffer getFaultyInput3() {
        return faultyInput3;
    }

    public static StringBuffer getFaultyInput4() {
        return faultyInput4;
    }

    public static StringBuffer getFaultyInput5() {
        return faultyInput5;
    }
}
