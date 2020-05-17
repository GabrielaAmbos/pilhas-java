
public class TesteTestePilha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercicios e = new Exercicios();
		String ex = "A + B(";
		char[] ex1 = ex.toCharArray();
		StaticStack<Character> s1 = new StaticStack<Character>(100);
		for(char c : ex1) {
			s1.push(c);
		}

		//)A + B(-C” e “(A + B)) – (C + D” 
		//“((A + B)” e “A + B(” 
		//“((A + B) – (C + D))”
			
		boolean a = e.checkBrackets(s1);
		System.out.println(a);

	}
}
