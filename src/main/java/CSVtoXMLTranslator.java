import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.stream.Collectors;

public class CSVtoXMLTranslator {

    private class XMLFromCSVListener extends CSVBaseListener{
        private List<String> headersNames;
        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public void exitHeader(CSVParser.HeaderContext ctx) {
            headersNames = ctx.TEXT().stream().map(x->x.getSymbol().getText()).collect(Collectors.toList());
        }

        @Override
        public void exitRow(CSVParser.RowContext ctx) {
            stringBuilder.append("<row>");

            for(int i = 0; i < headersNames.size(); i++){
                stringBuilder.append("<")
                        .append(headersNames.get(i))
                        .append(">")
                        .append(ctx.TEXT(i).getSymbol().getText())
                        .append("</")
                        .append(headersNames.get(i))
                        .append(">");
            }

            stringBuilder.append("</row>\n");
        }

        String getXmlText(){
            return "<root>\n" + stringBuilder.toString() + "</root>";
        }
    }

    public String map(String csvText){
        CSVLexer lexer = new CSVLexer(CharStreams.fromString(csvText));
        CSVParser parser = new CSVParser(new CommonTokenStream(lexer));
        XMLFromCSVListener listener = new XMLFromCSVListener();

        parser.addParseListener(listener);
        parser.file();

        return listener.getXmlText();
    }
}
