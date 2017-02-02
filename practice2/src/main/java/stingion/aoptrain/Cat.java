package stingion.aoptrain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by royalflush on 01.02.17.
 */
public class Cat implements Animal {
    @Getter
    @Setter
    private String species, colour;

    @Override
    public boolean hasFur() {
        return true;
    }

    @Override
    public Integer getNumberPaws() {
        return 4;
    }

    @Override
    public Boolean hasTail() {
        return true;
    }

    @Override
    public Boolean hasHotBlood() {
        return true;
    }

    @Override
    public boolean isGood() {
        return true;
    }
}
