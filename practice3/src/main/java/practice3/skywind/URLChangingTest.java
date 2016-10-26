package practice3.skywind;

import org.junit.Test;

/**
 * Created by eugene on 26.10.16.
 */
public class URLChangingTest {

    @Test
    public void changingToBigbigdealsDomain() throws Exception {
        String urlInput1 = "https://sdfasdf.sdfsdf.dfd/sdf/sdfsdfsf";
        String urlInput2 = "https://sdfasdf.sdfs2333.343.com";

        String expectedInput1 = "https://sdfasdf.sdfsdf.dfd/sdf/sdfsdfsf";
        String expectedInput2 = "https://sdfasdf.sdfsdf.dfd/sdf/sdfsdfsf";

        ImageURLParser urlChanging=new ImageURLParser();
        urlChanging.changeDomainToBigbigdeals("sdfs");
    }

}