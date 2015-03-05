import java.util.regex.Pattern;
import java_cup.runtime.*;

public class ToyLangUtil {
    //Reserved words in Toy
    public static final String[] reserved = {"boolean", "break", "class", "double", "else"
            , "extends", "false", "for", "if", "implements", "int", "interface"
            , "newarray", "println", "readln", "return", "string", "true", "void", "while"};
    //Regular expressions for identifiers, integers, doubles, strings, operations, punctuation, and whitespace
    //Booleans are covered under identifiers and reserved words
    private static final String idRegex = "[A-Za-z_][A-Za-z0-9_]*";
    private static final String intRegex = "0[xX][0-9a-fA-F]+|\\d+";
    private static final String doubleRegex = "\\d+\\.\\d*[Ee][+-]\\d+|\\d+\\.\\d*[Ee]\\d+|\\d+\\.\\d*";
    //Recognize ASCII or Unicode parentheses
    private static final String stringRegex = "\".*?\"|“.*?”";
    private static final String opPuncRegex = "//|/\\*|\\*/|\\+|\\-|\\*|/|%|<=|>=|<|>|==|!=|&&|\\|\\||!|=|;|,|\\.|\\(|\\)|\\[|\\]|\\{|\\}|\"|“|”";
    private static final String whitespaceRegex = "[ \n\t]";
    //A combined regular expression for any possible combination of the above
    //Will work even when there are no whitespace characters in the input
    public static final String totRegex = stringRegex + '|' + idRegex + '|'
            + doubleRegex + '|' + intRegex + '|' + opPuncRegex + '|' + whitespaceRegex;

    public static boolean isIdentifier (String s) {
        return Pattern.matches(idRegex, s);
    }

    public static boolean isReserved (String s) {
        for (int i = 0; i < reserved.length; i++) {
            if (reserved[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIntConst (String s) {
        return Pattern.matches(intRegex, s);
    }

    public static boolean isDoubleConst (String s) {
        return Pattern.matches(doubleRegex, s);
    }

    public static boolean isStringConst (String s) {
        return Pattern.matches(stringRegex, s);
    }

    public static boolean isOperatorOrPunctuation (String s) {
        return Pattern.matches(opPuncRegex, s);
    }

    public static boolean isWhitespace (String s) {
        return Pattern.matches(whitespaceRegex, s);
    }

    public static int stringToToken (String s) {
        if (isReserved(s)) {
            if (s.equals("boolean")) {
                return sym.__boolean__;
            } else if (s.equals("break")) {
                return sym.__break__;
            } else if (s.equals("class")) {
                return sym.__class__;
            } else if (s.equals("double")) {
                return sym.__double__;
            } else if (s.equals("else")) {
                return sym.__else__;
            } else if (s.equals("extends")) {
                return sym.__extends__;
            } else if (s.equals("false")) {
                return sym.__booleanconstant__;
            } else if (s.equals("for")) {
                return sym.__for__;
            } else if (s.equals("if")) {
                return sym.__if__;
            } else if (s.equals("implements")) {
                return sym.__implements__;
            } else if (s.equals("int")) {
                return sym.__int__;
            } else if (s.equals("interface")) {
                return sym.__interface__;
            } else if (s.equals("newarray")) {
                return sym.__newarray__;
            } else if (s.equals("println")) {
                return sym.__println__;
            } else if (s.equals("readln")) {
                return sym.__readln__;
            } else if (s.equals("return")) {
                return sym.__return__;
            } else if (s.equals("string")) {
                return sym.__string__;
            } else if (s.equals("true")) {
                return sym.__booleanconstant__;
            } else if (s.equals("void")) {
                return sym.__void__;
            } else if (s.equals("while")) {
                return sym.__while__;
            } else {
                //Should never happen
                return sym.error;
            }
        } else if (isStringConst(s)) {
            return sym.__stringconstant__;
        } else if (isIdentifier(s)) {
            return sym.__id__;
        } else if (isDoubleConst(s)) {
            return sym.__doubleconstant__;
        } else if (isIntConst(s)) {
            return sym.__intconstant__;
        } else if (isOperatorOrPunctuation(s)) {
            if (s.equals("+")) {
                return sym.__plus__;
            } else if (s.equals("-")) {
                return sym.__minus__;
            } else if (s.equals("*")) {
                return sym.__multiplication__;
            } else if (s.equals("/")) {
                return sym.__division__;
            } else if (s.equals("%")) {
                return sym.__mod__;
            } else if (s.equals("<")) {
                return sym.__less__;
            } else if (s.equals("<=")) {
                return sym.__lessequal__;
            } else if (s.equals(">")) {
                return sym.__greater__;
            } else if (s.equals(">=")) {
                return sym.__greaterequal__;
            } else if (s.equals("==")) {
                return sym.__equal__;
            } else if (s.equals("!=")) {
                return sym.__notequal__;
            } else if (s.equals("&&")) {
                return sym.__and__;
            } else if (s.equals("||")) {
                return sym.__or__;
            } else if (s.equals("!")) {
                return sym.__not__;
            } else if (s.equals("=")) {
                return sym.__assignop__;
            } else if (s.equals(";")) {
                return sym.__semicolon__;
            } else if (s.equals(",")) {
                return sym.__comma__;
            } else if (s.equals(".")) {
                return sym.__period__;
            } else if (s.equals("(")) {
                return sym.__leftparen__;
            } else if (s.equals(")")) {
                return sym.__rightparen__;
            } else if (s.equals("[")) {
                return sym.__leftbracket__;
            } else if (s.equals("]")) {
                return sym.__rightbracket__;
            } else if (s.equals("{")) {
                return sym.__leftbrace__;
            } else if (s.equals("}")) {
                return sym.__rightbrace__;
            } else {
                //Includes multiline comment ends and double quotes
                return sym.error;
            }
        } else {
            //Includes whitespace
            return sym.error;
        }
    }

    public static String tokenToString (Symbol s) {
        for(int i = 0; i < sym.terminalNames.length; i++) {
            if(s.sym == i) {
                if(i == 0 || i == 1) {
                    return sym.terminalNames[i];
                } else {
                    return sym.terminalNames[i].substring(2, sym.terminalNames[i].length() - 2);
                }
            }
        }
        return "NOT_A_TOKEN";
    }
}
