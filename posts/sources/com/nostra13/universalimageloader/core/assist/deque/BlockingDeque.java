package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean add(E e);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addFirst(E e);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addLast(E e);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean contains(Object obj);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E element();

    @Override // java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.Deque
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E peek();

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit);

    E pollFirst(long j, TimeUnit timeUnit);

    E pollLast(long j, TimeUnit timeUnit);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e);

    void putFirst(E e);

    void putLast(E e);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean remove(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take();

    E takeFirst();

    E takeLast();
}
