package stingion.lucene; /**
 * Created by joe on 09.11.15.
 */
import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.Version;

import java.io.Reader;

public class CommaCharTokenizer extends CharTokenizer {

    public CommaCharTokenizer(Version matchVersion, final Reader input) {
        super(matchVersion, input);
    }

    @Override
    protected boolean isTokenChar(final int c) {
        return ',' != c;
    }
}

