import org.antlr.v4.runtime.*;

import javax.xml.transform.ErrorListener;
import java.util.ArrayList;
import java.util.List;

public class ConditionValidator {

    List<String> syntaxErrors;

    private class ErrorListener extends ConsoleErrorListener {

        List<String> syntaxErrors = new ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            syntaxErrors.add("line " + line + ":" + charPositionInLine + " " + msg);
        }

        public List<String> getSyntaxErrors(){
            return syntaxErrors;
        }
    }

    ConditionValidator(String input){
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromString(input));
        ConditionParser parser = new ConditionParser(new CommonTokenStream(lexer));

        ErrorListener errorListener = new ErrorListener();

        parser.addErrorListener(errorListener);
        lexer.addErrorListener(errorListener);

        parser.start();

        syntaxErrors = errorListener.getSyntaxErrors();

    }

    public boolean valid(){
        return syntaxErrors.size() == 0;
    }

    public List<String> getSyntaxErrors(){
        return syntaxErrors;
    }
}
