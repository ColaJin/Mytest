package hikversion;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Objects;


public class UserDevice {
    private String[] deviceIds;

    public String[] getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(String[] deviceIds) {
        this.deviceIds = deviceIds;
    }
}
