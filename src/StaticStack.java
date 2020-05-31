/**
 * Implementa��o de uma Pilha com armazenamento est�tico,
 * baseado em array.
 */
public class StaticStack<E> implements Stack<E> {
	// �ndice do elemento no topo da pilha
	protected int top;

	// Array que armazena as refer�ncias para os elementos
	protected E elements[];

	/**
	 * Constr�i uma pilha com um tamanho m�ximo.
	 * @param maxSize O tamanho m�ximo da pilha
	 */
	public StaticStack(int maxSize) {
		elements = (E[])new Object[maxSize];
		top = -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#isEmpty()
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#isFull()
	 */
	public boolean isFull() {
		return top == elements.length - 1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#numElements()
	 */
	public int numElements() {
		return top + 1;
	}
	
	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#push(java.lang.Object)
	 */
	public void push(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		elements[++top] = element;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#pop()
	 */
	public E pop() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[top];
		elements[top--] = null; // p/ coleta de lixo
		return element;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Stack#top()
	 */
	public E top() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[top];
	}

	/**
	 * Retorna uma representa��o String da pilha.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[";
			for (int i = numElements() - 1; i >= 0; i--) {
				s += "\n" + elements[i];
			}
			s += "\n]";
			return s;
		}
	}
	
	/**
	 * 12. Implemente o método contains, definido abaixo, que informa se a pilha contém
	 * determinado elemento.
	 */
	public boolean contains(E element) {
		for (int i = numElements() - 1; i >= 0; i--) {
			if(element == elements[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 1. Implemente um método que inverte a ordem dos elementos da pilha.
	 */
	public void flip() {
		int tamanho = numElements();
		Stack<E> pilhaAuxA = new StaticStack<E>(numElements());
		Stack<E> pilhaAuxB = new StaticStack<E>(numElements());
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = this.pop();
			pilhaAuxA.push(elementoAux);
		}
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = pilhaAuxA.pop();
			pilhaAuxB.push(elementoAux);
		}
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = pilhaAuxB.pop();
			this.push(elementoAux);
		}
	}
	
	/**
	 * 2. Implemente uma sobrecarga do método push que recebe como parâmetro uma pilha, em vez de
	 * um elemento. Esse método deve adicionar à pilha corrente os elementos da pilha passada como
	 * parâmetro, porém mantendo a ordem original – ou seja, o elemento do topo da pilha passada
	 * como parâmetro deve ficar no topo da pilha corrente.
	 */
	public void push(StaticStack<E>pilha) throws OverflowException {
		if (isFull()) {
			throw new OverflowException();
		} else {
			pilha.flip();
			while(!pilha.isEmpty()) {
				E elementoAux = pilha.pop();
				this.push(elementoAux);
			}
		}
	}
	
	/**
	 * 3. Implemente um método equals para a pilha. Uma pilha será igual a outra se contiver os
	 * mesmos elementos, empilhados na mesma ordem. Para comparar os elementos, use também o
	 * método equals
	 */
	public boolean equals(Stack<E>pilha) {
		int tamanho = numElements();
		if(pilha.numElements() != tamanho) {
			return false;
		} else {
			for(int i = tamanho - 1; i >= 0; i--) {
				E aux = pilha.pop();
				if(!elements[i].equals(aux)) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * 4. Implemente um método clone para a pilha. Esse método deve retornar uma nova pilha contendo
	 * os mesmos elementos da atual. Os elementos em si não devem ser duplicados.
	 */
	public StaticStack<E> clone() {
		StaticStack<E> aux = new StaticStack<E>(elements.length);
		for(int i = 0; i < numElements(); i++) {
			aux.push(elements[i]);
		}
		return aux;
		
	}
	/**
	 * 5. Na classe StaticStack, implemente um método que apaga todos os elementos da pilha. Utilize
	 * a assinatura abaixo, completando o espaço em branco pela exceção correta a ser lançada por
	 * este método:
	 */
	public void clear() throws UnderflowException{
		if(isEmpty()) {
			throw new UnderflowException();
		} else {
			while(!isEmpty()) {
				this.pop();
			}
		}
	}
	
	
}