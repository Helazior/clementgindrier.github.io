package com.nostra13.universalimageloader.core.assist.deque;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.Deque
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.BlockingDeque, com.nostra13.universalimageloader.core.assist.deque.Deque
    public T remove() {
        return (T) super.removeFirst();
    }
}
