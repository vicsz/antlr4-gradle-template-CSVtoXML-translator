import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {

        ANTLRInputStream stream = new ANTLRInputStream("Col1,Col2,Col3\n1,2,3\n4,5,6");
        CSVLexer lexer = new CSVLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);

        System.out.println(tokens.getNumberOfOnChannelTokens());

    }
}
