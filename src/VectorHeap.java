import java.util.Vector;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order
	/**
	 * @post: Constructor de un nuevo priority queue
	 */
	public VectorHeap()
	{
		data = new Vector<E>();
	}
	/**
	 * @post: constructor de un nuevo priority queue con un vector desordenado
	 * @param v
	 */
	public VectorHeap(Vector<E> v)
	
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	/**
	 * @pre: Debe de haber almenos un elemento 
	 * @post: Regresas el padre del nodo 
	 * @param i
	 * @return El padre
	 */
	protected static int parent(int i)
	{
		return (i-1)/2;
	}
	/**
	 * @pre: Hay almenos un elemento
	 * @post: Regresa la posicion del hijo izquierdo
	 * @param i
	 * @return: El hijo en la posicion de la izquiera
	 */
	protected static int left(int i)
	
	{
		return 2*i+1;
	}
	/**
	 * @pre: Hay almenos un elemento 
	 * @post: Regresa la posicion del hijo derecha
	 * @param i
	 * @return: El hijo en la posicion de la derecha
	 */
	protected static int right(int i)
	{
		return 2*(i+1);
	}
	/**
	 * @pre: Hay almenos un elemento 
	 * @post: Mueve el nodo a la posicion correcta
	 * @param leaf
	 */
	protected void percolateUp(int leaf)
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
				(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}
	/**
	 * @pre: value is non-null comparable
	 * @post: value is added to priority queue
	 * @param value //valor que se desea agregar
	 */
	public void add(E value)

	{
		data.add(value);
		percolateUp(data.size()-1);
	}
	/**
	 * @pre: Hay almenos un elemento
	 * @post: Mueve el nodo a la posicion por debajo de la rama
	 * @param root
	 */
	protected void pushDownRoot(int root)

	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
						((data.get(childpos+1)).compareTo
								(data.get(childpos)) < 0))
				{
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo
						(value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // keep moving down
				} else { // found right location
					data.set(root,value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}
	/**
	 * @pre: !isEmpty()
	 * @post: returns and removes minimum value from queue
	 * @return El valor mas minimo del queue
	 */
	public E remove()
	
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}
	/**
	 * @pre: !isEmpty()
	 * @post: returns the minimum value in priority queue
	 * @return El valor mas minimo del queue
	 */
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return data.get(0);
	}
	/**
	 * @post: returns true iff no elements are in queue
	 * @return true o false dependiendo de qsi hay elementos en el queue
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return data.isEmpty();
	}
	/**
	 * @pre: la lista no esta vacia
	 * @post: returns number of elements within queue
	 * @return el numero de elementos en la lista
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}
	/**
	 * @pre: Hay valores en la lista
	 * @post Elimina todos los elementos de la lista
	 * 
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		int i=0;
        while(data.isEmpty()==false){
            data.remove(i);
            i++;
        }
	}
	/**
	 * 
	 * @param i
	 * @pre: la lista no esta vacia
	 * @post: regresa el valor de una posicion en especifico
	 * @return el valor de una posicion
	 */
	public E get(int i) {
		// TODO Auto-generated method stub
		return data.get(i);
	}


	
}
