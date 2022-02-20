import java.util.Stack;

public class LISPValidator{
    public static void main(String[] args) {
        
        String[] LISPStmts = new String[4];
        LISPStmts[0] = "(1=0)";
        LISPStmts[1] = "(1=0))";
        LISPStmts[2] = "(a *(7-2) 'func')";
        LISPStmts[3] = "(8*(a(y+t)*5)()";
        
        for(int i=0; i<LISPStmts.length; i++){
            String message = LISPStmts[i] += validateLISPStmt(LISPStmts[i]) ? " Is valid" : " Is not valid";
            System.out.println(message);
        }

    }
    /*
        //iterate through the char array
        //1. when we find an open paren add it to the Stack
        //2. when we find it's closing paren, pop the open paren from the Stack
        Output bool
        
    */
    public static boolean validateLISPStmt(String lispStmt)
    {
        String parensOnly = lispStmt.replaceAll("[^()\s]+",""); //Strip out everything except parens
        char[] chars = parensOnly.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<chars.length; i++){
            
            if(chars[i] == '(')
            {
                //Push the open paren on the stack
                stack.push(chars[i]);
                
            }
            else if(chars[i] == ')') 
            {
                if(! stack.isEmpty()) //We have an open paren
                {
                    //pop the open paren
                    stack.pop();
                }
                else{
                    //Stack has no open paren so the lisp stmt is invalid
                    return false;
                }
                
            }
        }

        return stack.isEmpty();
    }
}