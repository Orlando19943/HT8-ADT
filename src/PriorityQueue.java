/**
 * 
 */

/**
 * @author Orlando
 * Interfaz PriorityQUEUE sacada de Canvas
 */
public interface PriorityQueue<E extends Comparable<E>>
{
	/**
	 * @pre: !isEmpty()
	 * @post: returns the minimum value in priority queue
	 * @return El valor mas minimo del queue
	 */
	public E getFirst();
	
	/**
	 * @pre: !isEmpty()
	 * @post: returns and removes minimum value from queue
	 * @return El valor mas minimo del queue
	 */
	public E remove();
	/**
	 * @pre: value is non-null comparable
	 * @post: value is added to priority queue
	 * @param value //valor que se desea agregar
	 */
	public void add(E value);
	
	/**
	 * @post: returns true iff no elements are in queue
	 * @return true o false dependiendo de qsi hay elementos en el queue
	 */
	public boolean isEmpty();
	
	/**
	 * @post: returns number of elements within queue
	 * @return el numero de elementos en la lista
	 */
	public int size();
	
	/**
	 * @post Elimina todos los elementos de la lista
	 * 
	 */
	public void clear();
}