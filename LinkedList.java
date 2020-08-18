package project1;

public class LinkedList {

	Node first;
	Node last;

	public void addFirst(int i) {
		var node = new Node();
		node.value = i;
		if (first == null)
			first = last = node;
		else {
			node.next = first;
			first = node;
		}

	}

	public void addLast(int i) {
		var node = new Node();
		node.value = i;

		if (first == null)
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
	}

	public void deleteFirst() {
		if (first.next == null) {
			first = last = null;
		} else {

			var second = first.next;
			first.next = null;
			first = second;
		}

	}

	public void deleteLast() {
		var current = first;
		while (current != null) {
			if (current.next == last)
				break;
			current = current.next;
		}
		current.next = null;
		last = current;

	}

	public void contains(int i) {
		Node node = first;
		int count = 0;

		while (node != null) {
			count++;
			if (node.value == i) {
				System.out.println("found at " + count);
				return;
			} else {
				node = node.next;
			}
		}
		System.out.println("not found");
	}

	public void indexOf(int i) {

	}

}
