grammar InputGrammar;

@header{
import grammar.*;
import java.util.HashMap;
}

run returns[Grammar grammar]
    : parseGrammar{ $grammar = $parseGrammar.grammar; } EOF;

parseGrammar returns[Grammar grammar]
    : parseRules parseTerms
    { $grammar = new Grammar($parseRules.rules, $parseRules.nonTerms, $parseTerms.terms); }
;

parseRules returns[List<Rule> rules, List<NonTerm> nonTerms] @init {
    $rules = new ArrayList<Rule>();
    $nonTerms = new ArrayList<NonTerm>();
    String args = null;
    String ret = null;
}
    : (
        NONTERM (ARGS{ args = $ARGS.text; })? (RETURN{ ret = $RETURN.text; })?
        {
            $nonTerms.add(new NonTerm($NONTERM.text, args, ret));
            args = null;
            ret = null;
        }
        ARROW parseStates { $rules.add(new Rule($NONTERM.text, $parseStates.states, $parseStates.args, $parseStates.codes));}
    )+
;

parseStates returns[List<String> states, List<String> args, ArrayList<String> codes] @init {
    $states = new ArrayList<String>();
    $args = new ArrayList<String>();
    $codes = new ArrayList<String>();
    String code = null;
}
    : (
        (parseNonTerm{ $states.add($parseNonTerm.nonTermName); $args.add($parseNonTerm.arg); }
        | TERM{ $states.add($TERM.text); $args.add(null); })
        (CODE{ code = $CODE.text; })? { $codes.add(code); code = null; }
    )+
    SEMICOLON
;

parseNonTerm returns[String nonTermName, String arg] @init {
     String args = null;
}
    : NONTERM (ARGS{ args = $ARGS.text; })? { $nonTermName = $NONTERM.text; $arg = args; args = null; }
;


parseTerms returns[HashMap<String, String> terms] @init {
    $terms = new HashMap<String, String>();
}
    : (TERM COLON REGEX SEMICOLON { $terms.put($TERM.text, $REGEX.text); })+
;

WS : [ \t\r\n]+ -> skip;

ARROW : '->';
COLON : ':' ;
SEMICOLON : ';';
NONTERM : [A-Z][A-Z0-9]* ;
TERM : [a-z]+;

ARGS : '(' NOTARGS* ')';
NOTARGS : ~(')');

RETURN : '[' NOTRETURN* ']';
NOTRETURN : ~(']');

CODE : '{' NOTCODE* '}';
NOTCODE : ~('}');

REGEX : '"' NOTREGEX* '"';
NOTREGEX : ~('\r' | '\n' | '"');

