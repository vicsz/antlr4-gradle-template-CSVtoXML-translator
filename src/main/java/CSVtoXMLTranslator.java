import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.stream.Collectors;

public class CSVtoXMLTranslator {

    private class XMLFromCSVListener extends CSVBaseListener{
        private List<String> headersNames;
        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public void exitHeader(CSVParser.HeaderContext ctx) {
            headersNames = ctx.field().stream().map(x->x.TEXT().getSymbol().getText()).collect(Collectors.toList());
        }

        @Override
        public void exitRow(CSVParser.RowContext ctx) {
            stringBuilder.append("<row>");
            for(int i = 0; i < headersNames.size(); i++){
                stringBuilder.append("<" + headersNames.get(i) + ">" + ctx.field(i).getText() + "</" + headersNames.get(i) + ">");
            }
            stringBuilder.append("</row>\n");
        }

        public String getXmlText(){
            return "<root>\n" + stringBuilder.toString() + "</root>";
        }
    }

    public String map(String csvText){
        CSVLexer lexer = new CSVLexer(new ANTLRInputStream(csvText));
        CSVParser parser = new CSVParser(new CommonTokenStream(lexer));
        XMLFromCSVListener listener = new XMLFromCSVListener();

        parser.addParseListener(listener);
        parser.file();

        return listener.getXmlText();
    }
}
