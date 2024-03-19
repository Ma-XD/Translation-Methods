package parser

class Parser {
   private lateinit var lex: LexicalAnalyzer
   
   fun parse(input: String): Tree {
       lex = LexicalAnalyzer(input)
       lex.nextToken()
       val tree = parseE()
       assertToken(Token.END)
       return tree
   }
   
   private fun parseE(): Tree { 
       val node = "E"
       val children = ArrayList<Tree>()
       return when (lex.curToken) {
		   Token.LBRACKET, Token.N -> {
				val T_tree = parseT()
				children.add(T_tree)
				val T_res = T_tree.res as Int
				val E1_tree = parseE1(T_res)
				children.add(E1_tree)
				val E1_res = E1_tree.res as Int
				val res = E1_res;
				Tree(node, res=res, children=children)
           }
           

           else -> throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }    

   private fun parseE1(acc: Int): Tree { 
       val node = "E1"
       val children = ArrayList<Tree>()
       return when (lex.curToken) {
		   Token.ADD -> {
				assertToken(Token.ADD)
				children.add(Tree(lex.curString))
				lex.nextToken()
				val T_tree = parseT()
				children.add(T_tree)
				val T_res = T_tree.res as Int
				val acc1 = acc + T_res;
				val E1_tree = parseE1(acc1)
				children.add(E1_tree)
				val E1_res = E1_tree.res as Int
				val res = E1_res;
				Tree(node, res=res, children=children)
           }
           Token.SUB -> {
				assertToken(Token.SUB)
				children.add(Tree(lex.curString))
				lex.nextToken()
				val T_tree = parseT()
				children.add(T_tree)
				val T_res = T_tree.res as Int
				val acc1 = acc - T_res;
				val E1_tree = parseE1(acc1)
				children.add(E1_tree)
				val E1_res = E1_tree.res as Int
				val res = E1_res;
				Tree(node, res=res, children=children)
           }
           
           Token.RBRACKET, Token.END -> {
               val res = acc;
               Tree(node, res=res, children=children)
           }    
           else -> throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }    

   private fun parseT(): Tree { 
       val node = "T"
       val children = ArrayList<Tree>()
       return when (lex.curToken) {
		   Token.LBRACKET, Token.N -> {
				val F_tree = parseF()
				children.add(F_tree)
				val F_res = F_tree.res as Int
				val T1_tree = parseT1(F_res)
				children.add(T1_tree)
				val T1_res = T1_tree.res as Int
				val res = T1_res;
				Tree(node, res=res, children=children)
           }
           

           else -> throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }    

   private fun parseT1(acc: Int): Tree { 
       val node = "T1"
       val children = ArrayList<Tree>()
       return when (lex.curToken) {
		   Token.MUL -> {
				assertToken(Token.MUL)
				children.add(Tree(lex.curString))
				lex.nextToken()
				val F_tree = parseF()
				children.add(F_tree)
				val F_res = F_tree.res as Int
				val acc1 = acc * F_res;
				val T1_tree = parseT1(acc1)
				children.add(T1_tree)
				val T1_res = T1_tree.res as Int
				val res = T1_res;
				Tree(node, res=res, children=children)
           }
           Token.DIV -> {
				assertToken(Token.DIV)
				children.add(Tree(lex.curString))
				lex.nextToken()
				val F_tree = parseF()
				children.add(F_tree)
				val F_res = F_tree.res as Int
				val acc1 = acc / F_res;
				val T1_tree = parseT1(acc1)
				children.add(T1_tree)
				val T1_res = T1_tree.res as Int
				val res = T1_res;
				Tree(node, res=res, children=children)
           }
           
           Token.ADD, Token.RBRACKET, Token.SUB, Token.END -> {
               val res = acc;
               Tree(node, res=res, children=children)
           }    
           else -> throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }    

   private fun parseF(): Tree { 
       val node = "F"
       val children = ArrayList<Tree>()
       return when (lex.curToken) {
		   Token.LBRACKET -> {
				assertToken(Token.LBRACKET)
				children.add(Tree(lex.curString))
				lex.nextToken()
				val E_tree = parseE()
				children.add(E_tree)
				val E_res = E_tree.res as Int
				val res = E_res;
				assertToken(Token.RBRACKET)
				children.add(Tree(lex.curString))
				lex.nextToken()
				Tree(node, res=res, children=children)
           }
           Token.N -> {
				assertToken(Token.N)
				val res = getValue().toInt();
				children.add(Tree(lex.curString))
				lex.nextToken()
				Tree(node, res=res, children=children)
           }
           

           else -> throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }    



   private fun getValue() = lex.curString
   
   private fun assertToken(expected: Token) {
       if (lex.curToken != expected) {
           throw ParseException("Unexpected end token: "  + errorInfo())
       }
   }
   
   private fun errorInfo() = "found token " + lex.curToken.name + " at position " + (lex.curPos - lex.curString.length)
}   

class ParseException(message: String?) : Exception(message)