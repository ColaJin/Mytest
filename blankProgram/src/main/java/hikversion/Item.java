package hikversion;

import java.util.List;

/**
 * @author:jinyandong
 * @description:节目中的item
 * @Date:2023/8/22
 */
public class Item {
    private String _id;
    private Program _program;
    private Integer repeatTimes;
    private List<Schedule> schedules;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Program get_program() {
        return _program;
    }

    public void set_program(Program _program) {
        this._program = _program;
    }

    public Integer getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(Integer repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
