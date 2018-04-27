package com.oldscape.shared.utility;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.oldscape.shared.model.Node;

/**
 * Created by Sean on 13/08/2014.
 */
public final class MobList<T extends Node> extends AbstractList<T> implements Iterable<T> {

	private final Node[] mobs;

	private int size = 0;

	public MobList(int capacity) {
		mobs = new Node[capacity];
	}

	@Override
	public boolean add(T mob) {
		for (int id = 0; id < mobs.length; id++) {
			if (mobs[id] == null) {
				mobs[id] = mob;
				size++;

				mob.setIndex(id + 1);
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index > mobs.length)
			throw new IllegalArgumentException("Index error " + index + " either 0 or larger than " + mobs.length);

		T node = (T) mobs[index];

		return node;
	}

	@Override
	public boolean remove(Object obj) {

		if (!(obj instanceof Node)) {
			return false;
		}

		Node mob = (Node) obj;
		int id = mob.getIndex() - 1;
		T m = get(id);

		if (m == null)
			return false;

		mobs[id] = null;
		size--;
		mob.setIndex(0);
		return true;

	}

	@Override
	public boolean contains(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}

		Node mob = (Node) obj;

		return mobs[mob.getIndex()] != null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MobListIterator();
	}

	private class MobListIterator implements Iterator<T> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			for (int i = index; i < mobs.length; i++) {
				if (mobs[i] != null)
					return true;
			}

			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			for (; index < mobs.length; index++) {
				if (mobs[index] != null)
					return (T) mobs[index++];
			}

			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (index == 0 || mobs[index - 1] == null)
				throw new IllegalStateException();

			MobList.this.remove(mobs[index - 1]);
		}

	}

}
