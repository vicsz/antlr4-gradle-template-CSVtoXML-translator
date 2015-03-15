import org.junit.Test;

public class CSVtoXMLTranslatorTest {

    @Test
    public void shouldTestSomething(){

        String csvText =
            "Col1,Col2\n"+
            "1,text1\n"+
            "2,text2\n";

        String expectedXmlText =
            "<root>\n" +
            "<row><Col1>1</Col1><Col2>text1</Col2></row>\n" +
            "<row><Col1>2</Col1><Col2>text2</Col2></row>\n" +
            "</root>";

        String actualXmlText = new CSVtoXMLTranslator().map(csvText);

        assert (expectedXmlText.equals(actualXmlText));
    }
}
