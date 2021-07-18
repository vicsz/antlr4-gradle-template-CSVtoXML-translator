import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVtoXMLTranslatorTest {

    @Test
    public void shouldGetCorrectXmlOutput(){
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

        assertEquals(expectedXmlText, actualXmlText);
    }
}
