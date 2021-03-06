package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		} else {
			if (this.data.equals(element)) {
				return this.data;
			} else {
				return this.next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		
		toArray(result, this, 0);
		
		return result;
	}
	
	public void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			array[index++] = node.getData();
			toArray(array, node.getNext(), index);
		}
	}	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
