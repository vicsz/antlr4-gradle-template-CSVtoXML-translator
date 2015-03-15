import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.stream.Collectors;

public class CSVtoXMLTranslator {

    private class XMLFromCSVVisitor extends CSVBaseVisitor<Void> {
        private List<String> headersNames;
        private StringBuilder stringBuilder = new StringBuilder();

        public Void visitHdr(CSVParser.HdrContext ctx) {
            headersNames = ctx.row().field().stream().map(x->x.TEXT().getSymbol().getText()).collect(Collectors.toList());
            return null;
        }
        public Void visitRow(CSVParser.RowContext ctx) {
            stringBuilder.append("<row>");
            for(int i = 0; i < headersNames.size(); i++){
                stringBuilder.append("<" + headersNames.get(i) + ">" + ctx.field(i).getText() + "</" + headersNames.get(i) + ">");
            }
            stringBuilder.append("</row>\n");
            return null;
        }

        public String getXmlText(){
            return "<root>\n" + stringBuilder.toString() + "</root>";
        }
    }

    public String map(String csvText){
        CSVLexer lexer = new CSVLexer(new ANTLRInputStream(csvText));
        CSVParser parser = new CSVParser(new CommonTokenStream(lexer));
        XMLFromCSVVisitor visitor = new XMLFromCSVVisitor();

        parser.file().accept(visitor);

        return visitor.getXmlText();
    }
}
