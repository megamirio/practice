package practice3.insertone;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class One {

    @Nullable
    @Contract("null, _  -> fail; _, null -> fail")
    public String getStr(Object obj, Integer i) {
        if (obj == null)
            throw new RuntimeException("RE");

        if (i < 0) {
            return null;
        }

        return "abc";
    }

    @Nullable
    public String second(@NotNull Integer i) {
        if (i == 0)
            return null;
        return "abc";
    }

    @NotNull
    public String third(@NotNull Integer i) {
        if (i == null)
            return null;
        return "abc";
    }
}
