package com.hossam.datastructure.linkedList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SingleLinkedList {
	private Element root;

	public void add(Object value) {
		Element element = new Element(value, null);
		add(element);
	}

	public void add(Element element) {
		if (root == null) {
			root = element;
			return;
		}

		Element cursor = root;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		cursor.setNext(cursor);
	}

	public void add(int index, Object value) {
		Element element = new Element(value, null);
		add(index, element);
	}

	public void add(int insertionIndex, Element element) {
		if (root == null) {
			root = element;
			return;
		}

		int index = 0;
		Element prevCursor = null;
		Element cursor = root;

		while (cursor.getNext() != null) {

			if (index == insertionIndex) {
				if (prevCursor != null)
					prevCursor.setNext(element);
				element.setNext(cursor);
				return;
			}

			prevCursor = cursor;
			cursor = cursor.getNext();
			index++;
		}

		cursor.setNext(element);
	}

	public void addAll(List<? extends Object> data) {
		data.stream().forEach(e -> add(e));
	}

	public void addAll(int index, List<? extends Object> data) {
		Collections.reverse(data);

		data.stream().forEach(element -> {
			add(index, element);
		});
	}

	public void addFirst(Object value) {
		Element element = new Element(value, null);
		addFirst(element);
	}

	public void addFirst(Element element) {
		if (root == null) {
			root = element;
		} else {
			element.setNext(root);
			root = element;
		}
	}

	public void addLast(Object value) {
		Element element = new Element(value, null);
		addLast(element);
	}

	public void addLast(Element element) {
		if (root == null) {
			root = element;
			return;
		}

		Element cursor = root;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}

		cursor.setNext(element);
	}

	public void clear() {
		this.root = null;
	}

	public boolean contains(Object value) {
		if (root == null)
			return false;

		Element cursor = root;
		while (cursor != null) {
			if (cursor.getValue().equals(value))
				return true;
			cursor = cursor.getNext();
		}

		return false;
	}

	public Element element() {
		return this.getFirst();
	}

	public Element getFirst() {
		return this.root;
	}

	public Element getLast() {
		if (this.root == null)
			return null;
		Element cursor = root;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}

	public Element get(int index) {
		if (this.root == null)
			return null;

		Element cursor = root;
		int currentIndex = 0;
		while (cursor != null && currentIndex != index) {
			cursor = cursor.getNext();
			currentIndex = currentIndex + 1;
		}

		if (cursor == null)
			return null;
		else
			return cursor;
	}

	public int indexOf(Object value) {
		Element element = new Element(value, null);
		return indexOf(element);
	}

	public int indexOf(Element element) {
		if (root == null)
			return -1;

		Element cursor = root;
		int currentIndex = 0;
		while (cursor != null) {
			if (cursor.getValue().equals(element.getValue()))
				return currentIndex;

			currentIndex = currentIndex + 1;
			cursor = cursor.getNext();
		}

		return -1;
	}

	public int lastIndexOf(Object value) {
		Element element = new Element(value, null);
		return lastIndexOf(element);
	}

	public int lastIndexOf(Element element) {
		if (root == null)
			return -1;

		Element cursor = root;
		int currentIndex = 0;
		int foundIndex = -1;

		while (cursor != null) {
			if (cursor.getValue().equals(element.getValue())) {
				foundIndex = currentIndex;
			}

			currentIndex = currentIndex + 1;
			cursor = cursor.getNext();
		}

		return foundIndex;
	}

	public void offer(Element element) {
		this.addLast(element);
	}

	public void offerLast(Element element) {
		this.addLast(element);
	}

	public void offerFirst(Element element) {
		this.addFirst(element);
	}

	public Element peek() {
		return this.getFirst();
	}

	public Element peekFirst() {
		return this.getFirst();
	}

	public Element peekLast() {
		return this.getLast();
	}

	public void remove(int index) {
		if (root == null)
			return;

		Element prevCursor = null;
		Element cursor = root;
		int currentIndex = 0;
		while (cursor != null) {

			if (currentIndex == index) {
				if (prevCursor == null) {
					root = null;
				} else {
					prevCursor.setNext(cursor.getNext());
					cursor = null;
				}
			}

			prevCursor = cursor;
			cursor = cursor.getNext();
			currentIndex = currentIndex + 1;
		}
	}

	public void remove() {
		this.removeFirst();
	}

	public void removeFirst() {
		if (root == null)
			return;

		root = root.getNext();
	}

	public void removeLast() {
		if (root == null)
			return;

		Element prevCursor = null;
		Element cursor = root;
		while (cursor.getNext() != null) {
			prevCursor = cursor;
			cursor = cursor.getNext();
		}

		if (prevCursor == null)
			root = null;
		else
			prevCursor.setNext(null);

	}

	public Element poll() {
		Element element = getFirst();
		removeFirst();
		return element;
	}

	public Element pollFirst() {
		return poll();
	}

	public Element pollLast() {
		Element element = getLast();
		removeLast();
		return element;
	}

	public int size() {
		if (root == null)
			return 0;

		int size = 0;
		Element cursor = root;
		while (cursor != null) {
			size = size + 1;
			cursor = cursor.getNext();
		}
		return size;
	}
}
