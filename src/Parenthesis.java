import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String s = "{[s+(a+b)+1]+2}";
        //String s = "{[s+(a+b+1]+2}";
        //String s = "{[s+(a+b+1])+2}}";
        String parentesis = "(){}[]";
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = parentesis.indexOf(c);
            if(index!=-1){
                if (index%2==0){
                    stack.push(c);
                } else {
                    if (stack.isEmpty()){
                        System.out.println("Ошибка в позиции "+i);
                        flag = false;
                        break;
                    }
                    char c2 = stack.peek();
                    int index2 = parentesis.indexOf(c2);
                    if(index - index2 == 1)
                        stack.pop();
                    else {
                        flag = false;
                        System.out.println("Скобка не парная - Ошибка в позиции "+i);
                        break;
                    }
                }
            }
        }
    if (!stack.isEmpty() && flag){
        System.out.println("Стек не пуст - Ошибка в позиции " + (s.length() - 1));
        flag = false;
    }
    else System.out.println("Все верно");
    }
}
