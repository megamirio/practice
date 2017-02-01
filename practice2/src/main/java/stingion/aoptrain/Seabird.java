package stingion.aoptrain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by royalflush on 01.02.17.
 */
public class Seabird implements Bird {

    @Getter
    @Setter
    private String name;

    public Integer getNumberPaws() {
        return 2;
    }

    public Boolean hasTail() {
        return false;
    }

    public Boolean hasBeak() {
        return true;
    }

    public Boolean hasFeathers() {
        return true;
    }

    public boolean hasFur() {
        return false;
    }

    public Boolean hasHotBlood() {
        return false;
    }
}
