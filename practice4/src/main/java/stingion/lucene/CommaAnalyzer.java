package stingion.lucene;/*
 * Created under not commercial project
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.util.Version;

import java.io.Reader;

public class CommaAnalyzer extends Analyzer {
    private final Version version;

    public CommaAnalyzer(final Version version) {
        this.version = version;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        Tokenizer tokenizer = new CommaCharTokenizer(version, reader);
        TokenStream filer = new LowerCaseFilter(version, tokenizer);
        return new TokenStreamComponents(tokenizer, filer);
    }
}
